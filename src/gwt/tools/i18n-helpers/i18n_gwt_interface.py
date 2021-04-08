INTERFACE_DEFINITION_START = "public interface {name} extends Constants {{"
INTERFACE_DEFINITION_END = "}"


class Constant:
    def __init__(self, name, default_value):
        self.name = name
        self.default_value = default_value

    def to_lines(self):
        lines = [
            DEFAULT_STRING_TEMPLATE.format(text=self.default_value),
            PROPERTY_DEFINITION_TEMPLATE.format(name=self.name),
        ]
        return lines


class Text:
    def __init__(self, text):
        """
        A placeholder for a string that enables the same interface as a Constant or Property

        Useful for inserting comments into lists of Constant or Property objects

        :param text: Some string message to be emitted
        """
        self.texts = []
        self.add_text(text)

    def add_text(self, text):
        self.texts.append(text)

    def to_lines(self):
        return list(self.texts)

    def __str__(self):
        return "\n".join(self.texts)


DEFAULT_PROPERTY_FORMATTER = "{name} = {value}"


class Property:
    def __init__(self, name, value):
        self.name = name
        self.value = value

    def __str__(self):
        return DEFAULT_PROPERTY_FORMATTER.format(name=self.name, value=self.value)


class I18NGwtConstantsInterfaceGenerator:
    def __init__(self, name):
        self.name = name
        self.imports = ["import com.google.gwt.i18n.client.Constants;"]
        self.packages = []
        self.constants = []

    def add_package(self, package):
        self.packages.append(package)

    def add_import(self, import_text):
        self.imports.append(import_text)

    def add_constant(self, constant=None, name=None, default_value=None, string=None):
        """
        Adds the definition of a constant to the constants that will be written on output

        Accepts one of:
            constant: A fully populated Constant instance
            name and default_value: Strings that define the name and the default value of the constant
            string: A String that is written out literally to the output (use this to intersperse comments between constants)

        TODO: Finish this docstring

        :param constant:
        :param name:
        :param default_value:
        :param string:
        """
        if not constant and not all(name, default_value) and not string:
            raise ValueError("Either constant, name and default_value, or string must be specified")
        if constant is None:
            if string is not None:
                constant = Text(string)
            else:
                constant = Constant(name, default_value)
        self.constants.append(constant)

    def constants_to_lines(self):
        # Translate constants to lists of the java statements that creates them
        constants_unflattened = [c.to_lines() for c in self.constants]

        # Flatten commands from nested lists (per constant) to single list of java statements
        statements = [line for command in constants_unflattened for line in command]
        return statements

    def write(self, filename, add_newlines=True):
        lines = self.packages + self.imports + [""]

        # Build the interface definition, indenting the inner statements
        interface_lines = \
            [INTERFACE_DEFINITION_START.format(name=self.name)] \
            + indent_to(self.constants_to_lines(), indent_level=1) \
            + [INTERFACE_DEFINITION_END]

        lines.extend(interface_lines)

        with open(filename, 'w') as fout:
            if add_newlines:
                join_on = "\n"
            else:
                join_on = ""
            lines = join_on.join(lines)
            fout.write(lines)


class I18NGwtPropertiesGenerator:
    def __init__(self, header: str = ""):
        self.headers = []
        self.properties = []
        self.property_formatter = DEFAULT_PROPERTY_FORMATTER
        self.add_header(header)

    def add_header(self, header):
        self.headers.append(header)

    def add_property(self, prop: Property = None, name: str = None, value: str = None):
        """
        Adds a property to be output in the properties file.

        Property should either be passed as a Property object or as name and value.

        :param prop: A Property object to be stored
        :param name: The name of the property (left side of the equals sign)
        :param value: The string value of the property (right hand side of equals sign)
        """
        if not prop and not all(name, value):
            raise ValueError("Either property or name and value must be specified")
        if prop is None:
            prop = Property(name, value)
        self.properties.append(prop)

    def write(self, filename: str, add_newlines: bool = True):
        if add_newlines:
            join_on = "\n"
        else:
            join_on = ""
        lines = join_on.join(self.headers +
                             [str(p) for p in self.properties]  # Convert to formatted strings
                             )

        with open(filename, 'w') as fout:
            fout.writelines(lines)


DEFAULT_STRING_TEMPLATE = '@DefaultStringValue("{text}")'
PROPERTY_DEFINITION_TEMPLATE = 'String {name}();'


def indent_to(lines, indent_level=0, spaces_per_indent=4):
    """Resets the leading indentation of an iterable of strings to the specified indent"""
    this_indent = " " * indent_level * spaces_per_indent
    return [this_indent + line.lstrip() for line in lines]

from element_parsers import Command, Menu, Text
from i18n_gwt_interface import I18NGwtConstantsInterfaceGenerator, I18NGwtPropertiesGenerator


DEFAULT_PARSERS = {
    'cmd': Command,
    'menu': Menu
}


def xml_to_interface(interface_name, root_element, element_type, element_parser=None, prefix: str = ""):
    if element_parser is None:
        element_parser = DEFAULT_PARSERS[element_type]
    interface = I18NGwtConstantsInterfaceGenerator(interface_name)
    print("WARNING: Add package?")

    # Get cmd's that are direct children of root element
    for element_xml in root_element.findall(element_type):
        cmd = element_parser(element_xml)
        for constant in cmd.to_constants(prefix=prefix):
            interface.add_constant(constant)
        interface.add_constant(Text(""))  # Newline to separate groups
    return interface


def xml_to_properties(root_element, element_type, element_parser=None, prefix: str = ""):
    # TODO: Add descriptive header
    properties = I18NGwtPropertiesGenerator(header="# Auto generated file - do not change manually")

    # Get cmd's that are direct children of root element
    for cmd_xml in root_element.findall("cmd"):
        cmd = Command(cmd_xml)
        for prop in cmd.to_properties(prefix=prefix):
            properties.add_property(prop)
        properties.add_property(Text(""))  # Newline to separate groups

    return properties

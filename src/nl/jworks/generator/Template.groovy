package nl.jworks.generator

import groovy.xml.XmlUtil

class Template {
    String name, value, description
    boolean reformat, shortenFQNames
    List<String> contexts, variables

    Template(name, description, value, variables = [], reformat = true, shortenFQNames = false, contexts = ["HTML_TEXT, HTML"]) {
        this.name = name
        this.description = description
        this.value = XmlUtil.escapeXml(value).replaceAll("\n","&#10;")
        this.reformat = reformat
        this.variables = variables
        this.shortenFQNames = shortenFQNames
        this.contexts = contexts
    }

    String toString() {
        String variables = variables.collect { var -> "<variable name=\"$var\" expression=\"\" defaultValue=\"\" alwaysStopAt=\"true\" />" }.join("\n")

        """<template name="$name" value="$value\$END\$" description="$description" toReformat="$reformat" toShortenFQNames="$shortenFQNames">
                $variables
                <context>
                    <option name="HTML_TEXT" value="true" />
                    <option name="HTML" value="true" />
                </context>
            </template>"""
    }
}

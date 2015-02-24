import nl.jworks.generator.Template

def colors = [
        "light", // light grey
        "stable", // grey
        "positive", // blue
        "calm", // cyan
        "balanced", // green
        "energized", // yellow
        "assertive", // red
        "royal", // purple
        "dark" // black
]

def headers = colors.collect { color ->
    new Template("ion-header:$color", "Header which is fixed at top of the screen ($color)", "<div class=\"bar bar-header bar-$color\">\n" + "  <h1 class=\"title\">\$title\$</h1>\n" + "</div>", ["title"])
}
def subheader = new Template("ion-subheader", "A secondary header bar can be placed below the original header bar.", "<div class=\"bar bar-subheader\">\n" + "  <h2 class=\"title\">Sub Header</h2>\n" + "</div>")

def footers = colors.collect { color ->
    new Template("ion-footer:$color", "Footers are regions at the bottom of a screen that can contain various types of content. ($color)", "<div class=\"bar bar-footer bar-$color\">\n" + "  <div class=\"title\">\$title\$</div>\n" + "</div>", ["title"])
}

def button = new Template("ion-button", "It's a button", "<button class=\"button\">\n" + "  Default\n" + "</button>")

def buttons = colors.collect { color ->
    new Template("ion-button:$color", "A button ($color)", "<button class=\"button button-$color\">\n" + "  \$title\$\n" + "</button>", ["title"])
}

def blockButtons = colors.collect { color ->
    new Template("ion-block-button:$color", "A button with display:block style ($color)", "<button class=\"button button-block button-$color\">\n" + "  \$title\$\n" + "</button>", ["title"])
}

def fullWidthBlockButtons = colors.collect { color ->
    new Template("ion-full-width-block-button:$color", "A button with display:block style without borders ($color)", "<button class=\"button button-full button-$color\">\n" + "  \$title\$\n" + "</button>", ["title"])
}

def smallButtons = colors.collect { color ->
    new Template("ion-small-button:$color", "A smaller button ($color)", "<button class=\"button button-small button-$color\">\n" + "  \$title\$\n" + "</button>", ["title"])
}

def largeButtons = colors.collect { color ->
    new Template("ion-big-button:$color", "A larger button ($color)", "<button class=\"button button-large button-$color\">\n" + "  \$title\$\n" + "</button>", ["title"])
}

def outlinedButtons = colors.collect { color ->
    new Template("ion-outline-button:$color", "A button with outline style, which also has a transparent background ($color)", "<button class=\"button button-outline button-$color\">\n" + "  \$title\$\n" + "</button>", ["title"])
}

def clearButtons = colors.collect { color ->
    new Template("ion-clear-button:$color", "A button without border ($color)", "<button class=\"button button-clear button-$color\">\n" + "  \$title\$\n" + "</button>", ["title"])
}

def iconButtons = null // TODO

def clearHeaderButtons = new Template("ion-clear-header-buttons", "A header with clear buttons", "<div class=\"bar bar-header\">\n" + "  <button class=\"button button-icon icon ion-navicon\"></button>\n" + "  <div class=\"h1 title\">Header Buttons</div>\n" + "  <button class=\"button button-clear button-positive\">Edit</button>\n" + "</div>")


//def buttonBar = new Template("ion-button-bar", "A button bar", "<div class=\"bar bar-header\">\n" + "  <button class=\"button button-icon icon ion-navicon\"></button>\n" + "  <div class=\"h1 title\">Header Buttons</div>\n" + "  <button class=\"button button-clear button-positive\">Edit</button>\n" + "</div>")
//def buttonBarColors = new Template("ion-button-bar", "A button bar", "<div class=\"bar bar-header\">\n" + "  <button class=\"button button-icon icon ion-navicon\"></button>\n" + "  <div class=\"h1 title\">Header Buttons</div>\n" + "  <button class=\"button button-clear button-positive\">Edit</button>\n" + "</div>")




def templates = [headers, subheader, footers, button, buttons, blockButtons, fullWidthBlockButtons, smallButtons, largeButtons,
                 outlinedButtons, clearButtons, clearHeaderButtons].flatten()


def template = """<templateSet group="Ionic">
    ${templates.join("\n")}
</templateSet>"""


new File("resources/liveTemplates/Ionic.xml").text = template



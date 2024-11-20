package com.lloppy.hapson.screen.groups.components

import kotlin.properties.Delegates

abstract class UiElement(val mediator: Mediator)

class Button(mediator: Mediator) : UiElement(mediator) {
    fun click() {
        mediator.notify(this, "click")
    }
}

class TextBox(mediator: Mediator) : UiElement(mediator) {
    var text: String by Delegates.observable("") { property, oldValue, newValue ->
        mediator.notify(this, "text_changed")
    }
}
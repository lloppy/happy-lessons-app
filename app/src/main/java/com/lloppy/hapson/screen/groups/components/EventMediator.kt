package com.lloppy.hapson.screen.groups.components

import android.util.Log

// Паттерн Mediator
interface Mediator {
    fun notify(sender: UiElement, event: String)
}

class DialogMediator : Mediator {
    val okButton = Button(this)
    val cancelButton = Button(this)
    val input = TextBox(this)

    private var inputText = ""

    override fun notify(sender: UiElement, event: String) {
        Log.e("Mediator", "Notify called with sender: ${sender::class.simpleName}, event: $event")
        when (sender) {
            input -> if (event == "text_changed") {
                inputText = input.text
                Log.e("Mediator", "Input text changed to: $inputText")
            }

            okButton -> if (event == "click") submit()
            cancelButton -> if (event == "click") dismiss()
        }
    }

    private fun dismiss() {
        Log.e("Mediator", "Dialog dismissed")
    }

    private fun submit() {
        Log.e("Mediator", "Form submitted with input: $inputText")
    }
}
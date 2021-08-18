package com.example

class FakePrinter : Printer {
    var message : String = ""
    override fun print(text: String) {
        message = text
    }
}
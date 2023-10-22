package com.example.alweb29.learnelectriccircuitsapp.flashnotes

class FlashNote(shortDef: String, longDef: String) {
    constructor(shortDef: String, longDef: String, image: Int) : this(shortDef, longDef) {
        imageR = image
    }

    var shortDefinition = shortDef
    var longDefinition = longDef
    var imageR = 0
}

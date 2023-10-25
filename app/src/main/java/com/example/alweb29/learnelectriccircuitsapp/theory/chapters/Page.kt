package com.example.alweb29.learnelectriccircuitsapp.theory.chapters

class Page (header: String, text: String){
    constructor(header: String, text: String, image: Int) : this(header, text) {
        imageR = image
    }
    
    var imageR = 0
    var header = header
    var text = text
}
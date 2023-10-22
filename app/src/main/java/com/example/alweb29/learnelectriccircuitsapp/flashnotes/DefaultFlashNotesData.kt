package com.example.alweb29.learnelectriccircuitsapp.flashnotes

import com.example.alweb29.learnelectriccircuitsapp.R


object DefaultFlashNotesData : FlashNotesDataSet {
    override var flashNotes: MutableList<FlashNote> = mutableListOf<FlashNote>()
    override var currentIndex = 0
    override var listSize = flashNotes.size

    init {
        populateFlashNotes()
    }

    fun populateFlashNotes() {

        flashNotes.add(FlashNote("small text", "long Text description"))
        flashNotes.add(FlashNote("small text2", "long Text description2", R.drawable.baseline_bolt_24))

        listSize = flashNotes.size
    }
}

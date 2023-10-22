package com.example.alweb29.learnelectriccircuitsapp.flashnotes

object UserFlashNotesData : FlashNotesDataSet {
    override var flashNotes: MutableList<FlashNote> = mutableListOf<FlashNote>()
    override var currentIndex = 0
    override var listSize = flashNotes.size

    init {
        populateDataSet()
    }

    private fun populateDataSet() {
        flashNotes.add(FlashNote("this is user flash note", "this is second text in user flash note"))
        flashNotes.add(FlashNote("this is user flash note2", "this is second text in user flash note2"))
        flashNotes.add(FlashNote("this is user flash note3", "this is second text in user flash note3"))

        listSize = flashNotes.size
    }
}
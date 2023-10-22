package com.example.alweb29.learnelectriccircuitsapp.flashnotes

interface FlashNotesDataSet {
    var flashNotes :MutableList<FlashNote>
    var currentIndex :Int
    var listSize :Int


    fun getNextFlashNote() : FlashNote{
        if (currentIndex>= listSize - 1){
            currentIndex = 0
            return flashNotes[0]
        }else{
            currentIndex++
            return flashNotes[currentIndex]
        }
    }
    fun getPreviousFlashNote():FlashNote{
        return if (currentIndex <= 0){
            currentIndex = listSize -1
            flashNotes[listSize - 1]
        }else{
            currentIndex--
            return flashNotes[currentIndex]
        }
    }

    fun getFirstFlashNote() : FlashNote{
        return flashNotes[0]
    }
}
package com.example.alweb29.learnelectriccircuitsapp.theory.chapters

interface Chapter {
    var pages : MutableList<Page>
    var currentIndex :Int
    var listSize :Int


    fun getNextPage() : Page {
        if (currentIndex>= listSize - 1){
            currentIndex = 0
            return pages[0]
        }else{
            currentIndex++
            return pages[currentIndex]
        }
    }
    fun getPreviousPage(): Page {
        return if (currentIndex <= 0){
            currentIndex = listSize -1
            pages[listSize - 1]
        }else{
            currentIndex--
            return pages[currentIndex]
        }
    }

    fun getFirstPage() : Page {
        return pages[0]
    }
}
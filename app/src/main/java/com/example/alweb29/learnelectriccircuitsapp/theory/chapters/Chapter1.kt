package com.example.alweb29.learnelectriccircuitsapp.theory.chapters

import com.example.alweb29.learnelectriccircuitsapp.R

object Chapter1 : Chapter{
    override var pages: MutableList<Page> = mutableListOf<Page>()
    override var currentIndex =0
    override var listSize = pages.size

    init {
        pages.add(Page("This is header of 1 page", "this is text \n \n \n more text\n\n\nmore text"))
        pages.add(Page("This is header of 2 page", "this is text \n \n \n more text\n\n\nmore text"))
        pages.add(Page("This is header of 3 page", "this is text ", R.drawable.parallel_connection_tochange))
        pages.add(Page("This is header of 4 page", "this is text \n \n \n more text\n\n\nmore text"))

        listSize= pages.size
    }
}
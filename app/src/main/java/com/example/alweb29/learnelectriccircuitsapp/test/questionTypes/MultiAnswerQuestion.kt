package com.example.alweb29.learnelectriccircuitsapp.test.questionTypes

data class MultiAnswerQuestion(
    val id: Int,
    val question: String,
    val image: Int,

    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,

    val correctAnswers: Array<Int>
)
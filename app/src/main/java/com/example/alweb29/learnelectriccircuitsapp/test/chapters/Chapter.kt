package com.example.alweb29.learnelectriccircuitsapp.test.chapters

import com.example.alweb29.learnelectriccircuitsapp.test.questionTypes.MultiAnswerQuestion

interface Chapter {
    val questionSet : Array<MultiAnswerQuestion>
    public fun getNextQuestion(currentIndex : Int) : MultiAnswerQuestion?{
        return if (currentIndex + 1 > questionSet.size){
            null
        }else{
            questionSet[currentIndex + 1]
        }
    }
    fun getTotalNumOfQuestions() : Int{
        return questionSet.size
    }
    fun getCorrectAnswer(questionIndex : Int) : Array<Int>{
        return questionSet[questionIndex].correctAnswers
    }
}
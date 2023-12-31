package com.example.alweb29.learnelectriccircuitsapp.test.chapters

import com.example.alweb29.learnelectriccircuitsapp.R
import com.example.alweb29.learnelectriccircuitsapp.test.questionTypes.MultiAnswerQuestion

object ChapterThree : Chapter {
    private var q1 = MultiAnswerQuestion(
        1,
        "q1",
        R.drawable.series_connection_to_change,
        "check this",
        "15",
        "5",
        "0",
        arrayOf(1,0,0,0)
    )

    private var q2 = MultiAnswerQuestion(
        2,
        "q2",
        R.drawable.series_connection_to_change,
        "10",
        "15",
        "this",
        "0",
        arrayOf(0,0,1,0)
    )

    private var q3 = MultiAnswerQuestion(
        3,
        "Check only correct answers",
        R.drawable.series_connection_to_change,
        "U=R*I",
        "this.",
        "none",
        " and this",
        arrayOf(0,1,0,1)
    )



    override val questionSet: Array<MultiAnswerQuestion> = arrayOf(q1, q2, q3)
}
package com.example.alweb29.learnelectriccircuitsapp.test.chapters

import com.example.alweb29.learnelectriccircuitsapp.R
import com.example.alweb29.learnelectriccircuitsapp.test.questionTypes.MultiAnswerQuestion

object ChapterOne : Chapter{

    private var q1 = MultiAnswerQuestion(
        1,
        "What is resistance of this if R1 = 5ohm and R2 = 10 ohm",
        R.drawable.parallel_connection_to_change,
        "10",
        "15",
        "5",
        "0",
        arrayOf(0,1,0,0)
    )

    private var q2 = MultiAnswerQuestion(
        2,
        "What is resistance of this if R1 = 10ohm and R2 = 10 ohm",
        R.drawable.parallel_connection_to_change,
        "10",
        "15",
        "20",
        "0",
        arrayOf(0,0,1,0)
    )

    private var q3 = MultiAnswerQuestion(
        1,
        "Check only correct answers",
        R.drawable.parallel_connection_to_change,
        "U=R*I",
        "U is directly proportional to I when R remains constant.",
        "none",
        " Ohm's Law is fundamental for understanding electrical circuits",
        arrayOf(1,1,0,1)
    )



    override val questionSet: Array<MultiAnswerQuestion> = arrayOf(q1, q2, q3)


}
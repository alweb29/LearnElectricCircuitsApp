package com.example.alweb29.learnelectriccircuitsapp.calendar

interface AlarmScheduler {
    fun schedule(item : Long)
    fun cancel (item :Long)
}
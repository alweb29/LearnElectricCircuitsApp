package com.example.alweb29.learnelectriccircuitsapp.flashnotes

import android.content.Context
import android.content.SharedPreferences
//import com.google.gson.Gson

class FlashNotesManager(context: Context) {
   /* private val preferences: SharedPreferences = context.getSharedPreferences("FlashNotes", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveFlashNotes(flashNotes: List<FlashNote>) {
        val json = gson.toJson(flashNotes)
        preferences.edit().putString("flashNotes", json).apply()
    }

    fun loadFlashNotes(): List<FlashNote> {
        val json = preferences.getString("flashNotes", null)
        return if (json != null) {
            gson.fromJson(json, Array<FlashNote>::class.java).toList()
        } else {
            emptyList()
        }
    }*/
}
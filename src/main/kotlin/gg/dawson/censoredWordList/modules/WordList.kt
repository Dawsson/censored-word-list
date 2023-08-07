package gg.dawson.censoredWordList.modules

import java.util.*

interface WordList {
    val addWords: Boolean
    fun getWords(): TreeSet<String>
}
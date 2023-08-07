package gg.dawson.censoredWordList.modules

import com.google.gson.internal.LinkedTreeMap
import gg.dawson.censoredWordList.util.fetchAndParseJson
import java.util.*

class CussWords : WordList {
    override val addWords: Boolean get() = false
    override fun getWords(): TreeSet<String> {
        val wordMap = fetchAndParseJson("https://paste.learnspigot.com/raw/ogehipowud") as LinkedTreeMap<*, *>
        return wordMap.keys.map { it.toString() }.toCollection(TreeSet())
    }
}
package gg.dawson.censoredWordList.modules

import com.google.gson.internal.LinkedTreeMap
import gg.dawson.censoredWordList.util.fetchAndParseJson
import java.util.TreeSet

class DictionaryWords : WordList {
    override val addWords: Boolean get() = true
    override fun getWords(): TreeSet<String> {
        val wordMap = fetchAndParseJson(
            "https://raw.githubusercontent.com/dwyl/english-words/master/words_dictionary.json",
        ) as LinkedTreeMap<*, *>

        return wordMap.keys.map { it.toString() }.toCollection(TreeSet())
    }

}
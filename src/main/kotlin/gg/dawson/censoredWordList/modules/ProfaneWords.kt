package gg.dawson.censoredWordList.modules

import gg.dawson.censoredWordList.util.fetchAndParseJson
import java.util.*

class ProfaneWords : WordList {
    override val addWords: Boolean get() = false
    override fun getWords(): TreeSet<String> =
        fetchAndParseJson("https://raw.githubusercontent.com/zacanger/profane-words/master/words.json")

}
package gg.dawson.censoredWordList

import gg.dawson.censoredWordList.modules.CussWords
import gg.dawson.censoredWordList.modules.DictionaryWords
import gg.dawson.censoredWordList.modules.ProfaneWords
import gg.dawson.censoredWordList.util.GSON
import java.io.File
import java.util.TreeSet

fun main(args : Array<String>) {
    generateWordList(args[0].toInt())
}

fun generateWordList(minimumWordLength: Int) {
    val finalWordList = TreeSet<String>()

    hashSetOf(
        DictionaryWords(),
        CussWords(),
        ProfaneWords(),
    ).forEach {
        if (it.addWords) finalWordList.addAll(it.getWords())
        else finalWordList.removeAll(it.getWords())

        finalWordList.removeIf { word -> word.length < minimumWordLength }
    }

    File("wordList_${minimumWordLength}.json").apply {
        createNewFile()
    }.writeText(GSON.toJson(finalWordList))
}
package gg.dawson.censoredWordList.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

val GSON: Gson = GsonBuilder().setPrettyPrinting().create()

inline fun <reified T> fetchAndParseJson(url: String): T {
    val jsonString = URL(url).openStream().use { input ->
        val reader = BufferedReader(InputStreamReader(input))
        reader.readText()
    }
    return GSON.fromJson(jsonString, T::class.java)
}


//fun readWordListFromURL(url: String, type: ): Type =
//    GSON.fromJson(URL(url).readText(), type)


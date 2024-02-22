package com.tibo47.weatherPaname

object ResourceReader {
    fun readText(resourceName: String): String =
        javaClass.classLoader?.getResource(resourceName)?.readText()
            ?: throw Exception("Unable to read text resource '$resourceName'")
}

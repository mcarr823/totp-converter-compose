package dev.mcarr.totpconverter.utilities

import kotlinx.serialization.json.Json

inline fun <reified T> jsonDecode(str: String): T {
    val format = Json{ ignoreUnknownKeys=true }
    return format.decodeFromString<T>(str)
}
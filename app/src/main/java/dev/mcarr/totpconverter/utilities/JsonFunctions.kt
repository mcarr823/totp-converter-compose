package dev.mcarr.totpconverter.utilities

import org.json.JSONArray
import org.json.JSONObject

fun JSONArray.toObjectList(): List<JSONObject> {
    val len = this.length()
    return (0 until len).map { this.getJSONObject(it) }
}

fun JSONArray.toStringList(): List<String> {
    val len = this.length()
    return (0 until len).map { this.getString(it) }
}

fun <T> JSONObject.mapJsonArray(key: String, callback: (JSONObject) -> T): List<T> =
    this.getJSONArray(key)
        .toObjectList()
        .map(callback)

fun <T : JSONObject> JSONObject.mapJsonArray(key: String): List<T> =
    this.getJSONArray(key)
        .toObjectList()
        .map{ it as T }

fun <T, R> Collection<T>.toJsonArray(transform: (T) -> R): JSONArray =
    JSONArray().apply {
        map(transform).forEach(::put)
    }
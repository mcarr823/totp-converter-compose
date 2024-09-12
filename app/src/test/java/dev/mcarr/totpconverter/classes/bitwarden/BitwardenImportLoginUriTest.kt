package dev.mcarr.totpconverter.classes.bitwarden

import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class BitwardenImportLoginUriTest{

    @Test
    fun test(){

        val str = BitwardenTestData.getLoginUri1()
        val json = Json.decodeFromString<BitwardenImportLoginUri>(str)

        assertNull(json.match)
        assertEquals("https://my.domain.com", json.uri)

    }

}
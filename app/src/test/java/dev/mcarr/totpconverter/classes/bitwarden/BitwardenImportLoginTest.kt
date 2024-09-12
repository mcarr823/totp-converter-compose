package dev.mcarr.totpconverter.classes.bitwarden

import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class BitwardenImportLoginTest{

    @Test
    fun test(){

        val str = BitwardenTestData.getLogin1()
        val json = Json.decodeFromString<BitwardenImportLogin>(str)

        assertEquals("testname", json.username)
        assertEquals("testpass", json.password)
        assertEquals("otpauth://totp/mysecret", json.totp)
        assertEquals(1, json.uris.size)

    }

}
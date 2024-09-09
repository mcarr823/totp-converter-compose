package dev.mcarr.totpconverter.classes.aegis

import kotlinx.serialization.json.Json
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Test

class AegisImportEntryInfoTest {

    @Test
    fun constructorTest(){
        val str = """{
                "secret":"test",
                "algo":"SHA1",
                "digits":6,
                "period":30
            }""".trimMargin()
        val aegis = Json.decodeFromString<AegisImportEntryInfo>(str)

        assertEquals("test", aegis.secret)
        assertEquals("SHA1", aegis.algo)
        assertEquals(6, aegis.digits)
        assertEquals(30, aegis.period)
    }

}
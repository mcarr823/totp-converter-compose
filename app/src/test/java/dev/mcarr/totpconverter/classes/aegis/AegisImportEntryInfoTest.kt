package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.utilities.jsonDecode
import kotlinx.serialization.json.Json
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Test

class AegisImportEntryInfoTest {

    @Test
    fun test1(){
        val str = AegisTestData.getEntryInfo1()
        val aegis = jsonDecode<AegisImportEntryInfo>(str)

        assertEquals("abc123", aegis.secret)
        assertEquals("SHA1", aegis.algo)
        assertEquals(6, aegis.digits)
        assertEquals(30, aegis.period)
    }

    @Test
    fun test2(){
        val str = AegisTestData.getEntryInfo2()
        val aegis = jsonDecode<AegisImportEntryInfo>(str)

        assertEquals("def345", aegis.secret)
        assertEquals("SHA1", aegis.algo)
        assertEquals(5, aegis.digits)
        assertEquals(30, aegis.period)
    }

    @Test
    fun test3(){
        val str = AegisTestData.getEntryInfo3()
        val aegis = jsonDecode<AegisImportEntryInfo>(str)

        assertEquals("efg456", aegis.secret)
        assertEquals("SHA512", aegis.algo)
        assertEquals(6, aegis.digits)
        assertEquals(30, aegis.period)
    }

}
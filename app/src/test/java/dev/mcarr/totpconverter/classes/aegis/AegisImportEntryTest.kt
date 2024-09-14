package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.utilities.jsonDecode
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class AegisImportEntryTest {

    private val itemTest = AegisJsonItemTest()

    @Test
    fun test1(){
        val str = AegisTestData.getItem1()
        val aegis = jsonDecode<AegisImportEntry>(str)
        val json = AegisJsonItem(aegis)
        itemTest.checkTotpEntry(json)
    }

    @Test
    fun test2(){
        val str = AegisTestData.getItem2()
        val aegis = jsonDecode<AegisImportEntry>(str)
        val json = AegisJsonItem(aegis)
        itemTest.checkSteamEntry(json)
    }

    @Test
    fun test3(){
        val str = AegisTestData.getItem3()
        val aegis = jsonDecode<AegisImportEntry>(str)
        val json = AegisJsonItem(aegis)
        itemTest.checkSha512Entry(json)
    }

}
package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.classes.GenericJsonEntry
import org.junit.Assert.assertEquals
import org.junit.Test

class AegisJsonTest{

    private val itemTest = AegisJsonItemTest()

    @Test
    fun testImport(){
        val testData = AegisTestData.getFullObject()
        val tfa = AegisJson.import(testData)

        // Check length
        assertEquals(3, tfa.entries.size)

        // Check all 3 entries
        itemTest.checkTotpEntry(tfa.entries[0])
        itemTest.checkSteamEntry(tfa.entries[1])
        itemTest.checkSha512Entry(tfa.entries[2])

    }

    @Test
    fun testExport(){
        val testData = AegisTestData.getFullObject()
        val tfa = AegisJson.import(testData)

        // Test the export function by exporting and
        // reimporting the data, then re-checking the
        // new export
        val str = AegisJson.export(tfa.entries)
        val result = AegisJson.import(str)

        // Run the same checks as before on the new export
        assertEquals(3, result.entries.size)
        itemTest.checkTotpEntry(result.entries[0])
        itemTest.checkSteamEntry(result.entries[1])
        itemTest.checkSha512Entry(result.entries[2])

    }

}
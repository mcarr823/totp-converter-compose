package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.utilities.jsonDecode
import org.junit.Assert.assertEquals
import org.junit.Test

class AegisImportTest {

    private val itemTest = AegisJsonItemTest()

    @Test
    fun test(){
        val str = AegisTestData.getFullObject()
        val aegis = jsonDecode<AegisImport>(str)

        assertEquals(3, aegis.db.entries.size)

        val totpEntry = AegisJsonItem(aegis.db.entries[0])
        itemTest.checkTotpEntry(totpEntry)

        val steamEntry = AegisJsonItem(aegis.db.entries[1])
        itemTest.checkSteamEntry(steamEntry)

        val sha512Entry = AegisJsonItem(aegis.db.entries[2])
        itemTest.checkSha512Entry(sha512Entry)
    }
}
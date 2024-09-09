package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.classes.GenericJsonEntry
import org.junit.Assert.assertEquals
import org.junit.Test

class AegisJsonTest{

    @Test
    fun testImportExport(){
        val testData = AegisTestData()
        val tfa = AegisJson.import(testData)

        // Check length
        assertEquals(3, tfa.entries.size)

        // Check all 3 entries
        checkTotpEntry(tfa.entries[0])
        checkSteamEntry(tfa.entries[1])
        checkSha512Entry(tfa.entries[2])

        // Test the export function by exporting and
        // reimporting the data, then re-checking the
        // new export
        val str = AegisJson.export(tfa.entries)
        val result = AegisJson.import(str)

        // Run the same checks as before on the new export
        assertEquals(3, result.entries.size)
        checkTotpEntry(result.entries[0])
        checkSteamEntry(result.entries[1])
        checkSha512Entry(result.entries[2])

    }

    private fun checkTotpEntry(obj: GenericJsonEntry) {
        assertEquals("totp", obj.type)
        assertEquals("MEGA - MEGA:test@test.com", obj.name)
        assertEquals("MEGA", obj.issuer)
        assertEquals("abc123", obj.secret)
        assertEquals(6, obj.digits)
        assertEquals("SHA1", obj.algo)
        assertEquals(30, obj.period)
    }

    private fun checkSteamEntry(obj: GenericJsonEntry){
        assertEquals("steam", obj.type)
        assertEquals("steam", obj.name)
        assertEquals("", obj.issuer)
        assertEquals("def345", obj.secret)
        assertEquals(5, obj.digits)
        assertEquals("SHA1", obj.algo)
        assertEquals(30, obj.period)
    }

    private fun checkSha512Entry(obj: GenericJsonEntry){
        assertEquals("totp", obj.type)
        assertEquals("myGov", obj.name)
        assertEquals("", obj.issuer)
        assertEquals("efg456", obj.secret)
        assertEquals(6, obj.digits)
        assertEquals("SHA512", obj.algo)
        assertEquals(30, obj.period)
    }

}
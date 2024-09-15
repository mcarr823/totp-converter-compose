package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.classes.GenericJsonEntry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BitwardenJsonTest{

    @Test
    fun testImportExport(){
        val testData = BitwardenTestData.getFullObject()
        val bw = BitwardenJson.import(testData)

        // Only 2 of the 5 items are actually 2FA tokens (type === 1),
        // so the length should be 2
        assertEquals(2, bw.entries.size)

        // Check entry 1
        // Note that the name="x" field is checked against
        // the issuer instead, since the issuer wasn't defined.
        checkEntry1(bw.entries[0])

        // Check entry 2
        checkEntry2(bw.entries[1])

        // Test the export function by exporting and
        // reimporting the data, then re-checking the
        // new export
        val str = BitwardenJson.export(bw.entries)
        println(str)
        val result = BitwardenJson.import(str)

        // Run the same checks as before on the new export
        assertEquals(2, result.entries.size)
        checkEntry1(result.entries[0])
        checkEntry2(result.entries[1])

    }

    fun checkEntry1(token: GenericJsonEntry) {
        assertEquals("mysecret", token.secret)
        assertEquals("", token.issuer)
        assertEquals("Login Item's Name", token.name)
    }

    fun checkEntry2(token: GenericJsonEntry) {
        assertEquals("abc123", token.secret)
        assertEquals("Facebook", token.issuer)
        assertEquals("MyUsername", token.name)
    }

}
package dev.mcarr.totpconverter.classes.bitwarden

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BitwardenJsonTest{

    @Test
    fun testImportExport(){
        val testData = BitwardenTestData()
        val bw = BitwardenJson.import(testData)

        // Only 2 of the 5 items are actually 2FA tokens (type === 1),
        // so the length should be 2
        assertEquals(2, bw.entries.size)

        // Check entry 1
        // Note that the name="x" field is checked against
        // the issuer instead, since the issuer wasn't defined.
        val token = bw.entries[0]
        assertEquals("mysecret", token.secret)
        assertEquals("Login Item's Name", token.issuer)
        assertEquals("", token.name)

        val token2 = bw.entries[1]
        assertEquals("abc123", token2.secret)
        assertEquals("Facebook", token2.issuer)
        assertEquals("MyUsername", token2.name)

        // TODO test json
        val str = BitwardenJson.export(bw.entries)
        val result = BitwardenJson.import(str)
        // TODO check result
    }

}
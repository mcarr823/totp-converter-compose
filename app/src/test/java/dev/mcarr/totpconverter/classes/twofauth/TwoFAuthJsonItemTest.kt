package dev.mcarr.totpconverter.classes.twofauth

import dev.mcarr.totpconverter.classes.GenericJsonEntry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class TwoFAuthJsonItemTest{

    @Test
    fun testImportExport(){
        val testData = TwoFAuthTestData.getFullObject()
        val tfa = TwoFAuthJson.import(testData)

        // Check all entries
        checkFirstEntry(tfa.entries[0])

        // Test the export function by exporting and
        // reimporting the data, then re-checking the
        // new export
        val str = TwoFAuthJson.export(tfa.entries)
        val result = TwoFAuthJson.import(str)

        // Run the same checks as before on the new export
        checkFirstEntry(result.entries[0])

    }

    fun checkFirstEntry(obj: GenericJsonEntry) {
        assertEquals("totp", obj.type)
        assertEquals("johndoe@facebook.com", obj.name)
        assertEquals("Facebook", obj.issuer)
        assertEquals("A4GRFTVVRBGY7UIW", obj.secret)
        assertEquals(6, obj.digits)
        assertEquals("sha1", obj.algo)
        assertEquals(30, obj.period)
    }

}
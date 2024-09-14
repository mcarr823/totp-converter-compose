package dev.mcarr.totpconverter.classes.twofauth

import dev.mcarr.totpconverter.classes.GenericJsonEntry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class TwoFAuthJsonTest {

    @Test
    fun testImportExport(){
        val testData = TwoFAuthTestData.getFullObject()
        val tfa = TwoFAuthJson.import(testData)

        // Check length
        assertEquals(1, tfa.entries.size)

        // Test the export function by exporting and
        // reimporting the data, then re-checking the
        // new export
        val str = TwoFAuthJson.export(tfa.entries)
        val result = TwoFAuthJson.import(str)

        // Run the same checks as before on the new export
        assertEquals(1, result.entries.size)

    }

}
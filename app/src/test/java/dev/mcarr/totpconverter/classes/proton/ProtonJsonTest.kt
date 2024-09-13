package dev.mcarr.totpconverter.classes.proton

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ProtonJsonTest {

    @Test
    fun testImportExport(){
        val testData = ProtonTestData.getFullObject()
        val tfa = ProtonJson.import(testData)

        assertEquals(2, tfa.entries.size)

        // Parse TOTP object
        val obj = tfa.entries[0]
        assertEquals("totp", obj.type)
        assertEquals("me@my.domain.com", obj.name)
        assertEquals("Proton", obj.issuer)
        assertEquals("abc123", obj.secret)
        assertEquals(6, obj.digits)
        assertEquals("SHA1", obj.algo)
        assertEquals(30, obj.period)

    }

}


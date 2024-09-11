package dev.mcarr.totpconverter.classes.twofauth

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class TwoFAuthJsonItemTest{

    @Test
    fun test(){

        val data = TwoFAuthImportToken(
            otp_type = "test1",
            account = "test2",
            service = "test3",
            icon = null,
            icon_mime = null,
            icon_file = null,
            secret = "test",
            digits = 6,
            algorithm = "SHA1",
            period = 30,
            counter = null,
            legacy_uri = ""
        )

        val item = TwoFAuthJsonItem(data)

        assertEquals("test1", item.type)
        assertEquals("test2", item.name)
        assertEquals("test3", item.issuer)
        assertEquals("test", item.secret)
        assertEquals("SHA1", item.algo)
        assertEquals(6, item.digits)
        assertEquals(30, item.period)
        assertEquals(true, item.websites.isEmpty())

    }

}
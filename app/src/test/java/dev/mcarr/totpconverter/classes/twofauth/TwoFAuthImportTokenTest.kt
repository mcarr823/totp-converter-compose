package dev.mcarr.totpconverter.classes.twofauth

import dev.mcarr.totpconverter.utilities.jsonDecode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class TwoFAuthImportTokenTest{

    @Test
    fun test(){

        val testData = TwoFAuthTestDataItem1()
        val obj = jsonDecode<TwoFAuthImportToken>(testData)

        assertEquals("totp", obj.otp_type)
        assertEquals("johndoe@facebook.com", obj.account)
        assertEquals("Facebook", obj.service)
        assertEquals("A4GRFTVVRBGY7UIW", obj.secret)
        assertEquals(6, obj.digits)
        assertEquals("sha1", obj.algorithm)
        assertEquals(30, obj.period)
        assertEquals("otpauth://totp/Facebook%3Ajohndoe%40facebook.com?issuer=Facebook&secret=A4GRFTVVRBGY7UIW", obj.legacy_uri)
        assertNull(obj.counter)
        assertEquals("image/png", obj.icon_mime)
        assertEquals("iVBORw0KGgoAAAARU5ErkJggg==", obj.icon_file)
        assertEquals("82yCBkDNghIMJ0RfTkFHLPGFaEZSimAWPB4PMVhT.png", obj.icon)

    }

}
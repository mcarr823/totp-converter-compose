package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.utilities.jsonDecode
import org.junit.Assert.assertEquals
import org.junit.Test

class ProtonImportContentTest{

    @Test
    fun test1(){
        val str = ProtonTestData.getContent1()
        val content = jsonDecode<ProtonImportContent>(str)

        assertEquals("me@my.domain.com", content.username)
        assertEquals("mypassword", content.password)
        assertEquals("otpauth://totp/Proton:proton%40my.domain.com?issuer=Proton&secret=abc123&algorithm=SHA1&digits=6&period=30", content.totpUri)

        assertEquals(2, content.urls.size)
        assertEquals("https://my.domain.com/login", content.urls[0])
        assertEquals("https://my.domain.com/", content.urls[1])

        assertEquals(2, content.passkeys.size)
        assertEquals("blahblah1", content.passkeys[0])
        assertEquals("blahblah2", content.passkeys[1])

    }

    @Test
    fun test2(){
        val str = ProtonTestData.getContent2()
        val content = jsonDecode<ProtonImportContent>(str)

        assertEquals("me@proton.com", content.username)
        assertEquals("", content.password)
        assertEquals("", content.totpUri)
        assertEquals(0, content.urls.size)
        assertEquals(0, content.passkeys.size)

    }
}
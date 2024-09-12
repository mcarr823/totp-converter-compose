package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.enums.BitwardenType
import dev.mcarr.totpconverter.utilities.jsonDecode
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class BitwardenImportItemTest{

    @Test
    fun test(){

        val str = BitwardenTestData.getLoginItem1()
        val json = jsonDecode<BitwardenImportItem>(str)

        assertEquals(BitwardenType.LOGIN.value, json.type)
        assertEquals("Login Item's Name", json.name)
        assertNotNull(json.login)

        val login = json.login!!

        assertEquals("testname", login.username)
        assertEquals("testpass", login.password)
        assertEquals("otpauth://totp/mysecret", login.totp)
        assertEquals(1, login.uris.size)

    }
    // TODO a test for each type. card, secure, etc.
}
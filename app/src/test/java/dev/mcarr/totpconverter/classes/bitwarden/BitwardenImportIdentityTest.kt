package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.enums.BitwardenType
import dev.mcarr.totpconverter.utilities.jsonDecode
import org.junit.Assert.assertEquals
import org.junit.Test

class BitwardenImportIdentityTest{

    @Test
    fun test(){

        val str = BitwardenTestData.getIdentity1()
        val json = jsonDecode<BitwardenImportIdentity>(str)

        assertEquals("test1", json.title)
        assertEquals("test2", json.firstName)
        assertEquals("test3", json.middleName)
        assertEquals("test4", json.lastName)
        assertEquals("test5", json.address1)
        assertEquals("test6", json.address2)
        assertEquals("test7", json.address3)
        assertEquals("test8", json.city)
        assertEquals("test9", json.state)
        assertEquals("test10", json.postalCode)
        assertEquals("test11", json.country)
        assertEquals("test12", json.company)
        assertEquals("test13", json.email)
        assertEquals("test14", json.phone)
        assertEquals("test15", json.ssn)
        assertEquals("test16", json.username)
        assertEquals("test17", json.passportInt)
        assertEquals("test18", json.licenseInt)

    }

}
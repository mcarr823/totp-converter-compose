package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.utilities.jsonDecode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class BitwardenImportSecureNoteTest{

    @Test
    fun test1(){

        val str = BitwardenTestData.getSecureNote1()
        val json = jsonDecode<BitwardenImportSecureNote>(str)

        assertEquals(0, json.type)
    }

    @Test
    fun test2(){

        val str = BitwardenTestData.getSecureNote2()
        val json = jsonDecode<BitwardenImportSecureNote>(str)

        assertNull(json.type)
    }

}
package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.utilities.jsonDecode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class BitwardenImportFieldTest{

    @Test
    fun test(){

        val str = BitwardenTestData.getField1()
        val json = jsonDecode<BitwardenImportField>(str)

        assertEquals("custom-field-1", json.name)
        assertEquals("custom-field-value", json.value)
        assertEquals(0, json.type)
        assertNull(json.linkedId)


    }

}
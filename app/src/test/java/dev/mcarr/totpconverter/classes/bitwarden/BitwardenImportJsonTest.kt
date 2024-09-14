package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.utilities.jsonDecode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class BitwardenImportJsonTest{

    @Test
    fun test(){

        val str = BitwardenTestData.getFullObject()
        val json = jsonDecode<BitwardenImportJson>(str)

        assertNull(json.encrypted)
        assertNotNull(json.folders)
        assertEquals(1, json.folders!!.size)
        assertEquals(5, json.items.size)
    }

}
package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.utilities.jsonDecode
import org.junit.Assert.assertEquals
import org.junit.Test

class BitwardenImportFolderTest{

    @Test
    fun test(){

        val str = BitwardenTestData.getFolder1()
        val json = jsonDecode<BitwardenImportFolder>(str)

        assertEquals("123456789", json.id)
        assertEquals("Folder Name", json.name)
    }

}
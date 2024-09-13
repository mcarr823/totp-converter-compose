package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.utilities.jsonDecode
import org.junit.Assert.assertEquals
import org.junit.Test

class ProtonImportVaultTest{

    @Test
    fun test(){

        val str = ProtonTestData.getVault1()
        val json = jsonDecode<ProtonImportVault>(str)

        assertEquals("Personal", json.name)
        assertEquals("Personal vault", json.description)
        //json.display
        assertEquals(2, json.items.size)

    }

}
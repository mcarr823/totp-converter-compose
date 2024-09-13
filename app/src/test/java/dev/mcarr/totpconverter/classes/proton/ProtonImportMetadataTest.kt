package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.utilities.jsonDecode
import org.junit.Assert.assertEquals
import org.junit.Test

class ProtonImportMetadataTest{

    @Test
    fun test1(){
        val str = ProtonTestData.getMetadata1()
        val meta = jsonDecode<ProtonImportMetadata>(str)

        assertEquals("my.domain.com", meta.name)
        assertEquals("testnote", meta.note)
        assertEquals("15b83727", meta.itemUuid)
    }

    @Test
    fun test2(){
        val str = ProtonTestData.getMetadata2()
        val meta = jsonDecode<ProtonImportMetadata>(str)

        assertEquals("account.proton.me", meta.name)
        assertEquals("", meta.note)
        assertEquals("f2ded5eb", meta.itemUuid)
    }

}
package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.utilities.jsonDecode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ProtonImportItemTest{

    @Test
    fun test1(){

        val str = ProtonTestData.getItem1()
        val json = jsonDecode<ProtonImportItem>(str)

        assertEquals("item1", json.itemId)
        assertEquals("share1", json.shareId)
        //assertEquals(, json.data)
        assertEquals(1, json.state)
        assertNull(json.aliasEmail)
        assertEquals(3, json.contentFormatVersion)
        assertEquals(1697597454, json.createTime)
        assertEquals(1715201864, json.modifyTime)
        assertEquals(false, json.pinned)

    }

    @Test
    fun test2(){

        val str = ProtonTestData.getItem2()
        val json = jsonDecode<ProtonImportItem>(str)

        assertEquals("item2", json.itemId)
        assertEquals("share2", json.shareId)
        //assertEquals(, json.data)
        assertEquals(1, json.state)
        assertNull(json.aliasEmail)
        assertEquals(1, json.contentFormatVersion)
        assertEquals(1697597453, json.createTime)
        assertEquals(1708056760, json.modifyTime)
        assertEquals(true, json.pinned)

    }

}
package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.utilities.jsonDecode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ProtonImportDataTest{

    @Test
    fun test1(){
        val str = ProtonTestData.getData1()
        val data = jsonDecode<ProtonImportData>(str)

        assertEquals("login", data.type)
        assertEquals(4, data.lastRevision)
        assertEquals(0, data.extraFields.size)
        //assertEquals(0, data.metadata)
        //assertEquals(0, data.content)

        assertEquals(1, data.platformSpecific.size)
        assertEquals(true, data.platformSpecific.containsKey("android"))
        assertEquals(0, data.platformSpecific.get("android")!!.allowedApps!!.size)

    }

    @Test
    fun test2(){
        val str = ProtonTestData.getData2()
        val data = jsonDecode<ProtonImportData>(str)

        assertEquals("login", data.type)
        assertNull(data.lastRevision)
        assertEquals(0, data.extraFields.size)
        //assertEquals(0, data.metadata)
        //assertEquals(0, data.content)

        assertEquals(1, data.platformSpecific.size)
        assertEquals(true, data.platformSpecific.containsKey("android"))
        assertEquals(4, data.platformSpecific.get("android")!!.allowedApps!!.size)

    }

}
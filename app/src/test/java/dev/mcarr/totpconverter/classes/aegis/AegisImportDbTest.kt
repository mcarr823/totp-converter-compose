package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.utilities.jsonDecode
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class AegisImportDbTest {

    @Test
    fun constructorTest(){
        val str = AegisTestData.getDb1()
        val db = jsonDecode<AegisImportDb>(str)

        assertEquals(3, db.entries.size)
        //assertEquals(0, db.groups.size)
        assertEquals(3, db.version)
    }

}
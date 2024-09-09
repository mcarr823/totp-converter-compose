package dev.mcarr.totpconverter.classes.aegis

import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class AegisImportDbTest {

    @Test
    fun constructorTest(){
        val str = """{"entries": [{
            "type":"test1",
            "name": "test2",
            "issuer": "test3",
            "info":{
                "secret":"test",
                "algo":"SHA1",
                "digits":6,
                "period":30
            }
        }]}""".trimMargin()
        val db = Json.decodeFromString<AegisImportDb>(str)

        assertEquals(1, db.entries.size)

        val aegis = db.entries[0]
        assertEquals("test1", aegis.type)
        assertEquals("test2", aegis.name)
        assertEquals("test3", aegis.issuer)
        assertEquals("test", aegis.info.secret)
        assertEquals("SHA1", aegis.info.algo)
        assertEquals(6, aegis.info.digits)
        assertEquals(30, aegis.info.period)
    }

}
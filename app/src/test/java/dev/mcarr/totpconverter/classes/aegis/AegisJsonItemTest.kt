package dev.mcarr.totpconverter.classes.aegis

import org.junit.Assert.assertEquals
import org.junit.Test

class AegisJsonItemTest {

    @Test
    fun test(){

        val data = AegisImportEntry(
            type = "test1",
            name = "test2",
            issuer = "test3",
            info = AegisImportEntryInfo(
                secret = "test",
                algo = "SHA1",
                digits = 6,
                period = 30
            )
        )
        val aegis = AegisJsonItem(data)

        assertEquals("test1", aegis.type)
        assertEquals("test2", aegis.name)
        assertEquals("test3", aegis.issuer)
        assertEquals("test", aegis.secret)
        assertEquals("SHA1", aegis.algo)
        assertEquals(6, aegis.digits)
        assertEquals(30, aegis.period)
        assertEquals(true, aegis.websites.isEmpty())

    }

}
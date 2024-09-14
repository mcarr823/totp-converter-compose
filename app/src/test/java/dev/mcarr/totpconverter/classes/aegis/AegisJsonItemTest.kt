package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.classes.GenericJsonEntry
import org.junit.Assert.assertEquals
import org.junit.Test

class AegisJsonItemTest {

    @Test
    fun testTotpEntry(){

        val data = AegisImportEntry(
            type = "totp",
            name = "MEGA - MEGA:test@test.com",
            issuer = "MEGA",
            info = AegisImportEntryInfo(
                secret = "abc123",
                algo = "SHA1",
                digits = 6,
                period = 30
            )
        )
        val aegis = AegisJsonItem(data)

        checkTotpEntry(aegis)

    }

    @Test
    fun testSteamEntry(){

        val data = AegisImportEntry(
            type = "steam",
            name = "steam",
            issuer = "",
            info = AegisImportEntryInfo(
                secret = "def345",
                algo = "SHA1",
                digits = 5,
                period = 30
            )
        )
        val aegis = AegisJsonItem(data)

        checkSteamEntry(aegis)

    }

    @Test
    fun testSha512Entry(){

        val data = AegisImportEntry(
            type = "totp",
            name = "myGov",
            issuer = "",
            info = AegisImportEntryInfo(
                secret = "efg456",
                algo = "SHA512",
                digits = 6,
                period = 30
            )
        )
        val aegis = AegisJsonItem(data)

        checkSha512Entry(aegis)

    }

    fun checkTotpEntry(obj: GenericJsonEntry) {
        assertEquals("totp", obj.type)
        assertEquals("MEGA - MEGA:test@test.com", obj.name)
        assertEquals("MEGA", obj.issuer)
        assertEquals("abc123", obj.secret)
        assertEquals(6, obj.digits)
        assertEquals("SHA1", obj.algo)
        assertEquals(30, obj.period)
    }

    fun checkSteamEntry(obj: GenericJsonEntry){
        assertEquals("steam", obj.type)
        assertEquals("steam", obj.name)
        assertEquals("", obj.issuer)
        assertEquals("def345", obj.secret)
        assertEquals(5, obj.digits)
        assertEquals("SHA1", obj.algo)
        assertEquals(30, obj.period)
    }

    fun checkSha512Entry(obj: GenericJsonEntry){
        assertEquals("totp", obj.type)
        assertEquals("myGov", obj.name)
        assertEquals("", obj.issuer)
        assertEquals("efg456", obj.secret)
        assertEquals(6, obj.digits)
        assertEquals("SHA512", obj.algo)
        assertEquals(30, obj.period)
    }

}
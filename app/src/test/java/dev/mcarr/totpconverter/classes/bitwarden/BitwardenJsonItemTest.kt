package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.enums.BitwardenType
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class BitwardenJsonItemTest{

    @Test
    fun test(){

        val data = BitwardenImportItem(
            type = BitwardenType.LOGIN.value,
            name = "test2",
            login = BitwardenImportLogin(
                uris = listOf(),
                username = "",
                password = "",
                totp = ""
            ),
            passwordHistory = null,
            revisionDate = null,
            creationDate = null,
            deletedDate = null,
            id = null,
            organizationId = null,
            folderId = null,
            reprompt = null,
            notes = null,
            favorite = null,
            secureNote = null,
            card = null,
            fields = null,
            identity = null,
            collectionIds = null,
        )
        val bw = BitwardenJsonItem(data)

        assertEquals("totp", bw.type)
        assertEquals("", bw.name)
        assertEquals("test2", bw.issuer)
        assertEquals("", bw.secret)
        assertEquals("sha1", bw.algo)
        assertEquals(6, bw.digits)
        assertEquals(30, bw.period)
        assertEquals(true, bw.websites.isEmpty())

    }

}
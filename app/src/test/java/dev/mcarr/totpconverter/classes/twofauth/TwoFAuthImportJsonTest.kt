package dev.mcarr.totpconverter.classes.twofauth

import dev.mcarr.totpconverter.utilities.jsonDecode
import kotlinx.datetime.Instant
import kotlinx.datetime.toInstant
import org.junit.Assert.assertEquals
import org.junit.Test

class TwoFAuthImportJsonTest{

    @Test
    fun test(){

        val testData = TwoFAuthTestData.getFullObject()
        val tfa = jsonDecode<TwoFAuthImportJson>(testData)

        assertEquals("2fauth_v5.1.1", tfa.app)
        assertEquals(1, tfa.schema)
        assertEquals(Instant.parse("2024-04-07T12:16:29.606564Z"), tfa.datetime)

        // Check length
        assertEquals(1, tfa.data.size)

    }

}
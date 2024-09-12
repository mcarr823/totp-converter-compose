package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.classes.aegis.AegisImportDb
import dev.mcarr.totpconverter.enums.BitwardenType
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class BitwardenImportCardTest{

    @Test
    fun test(){

        val str = BitwardenTestData.getCard1()
        val json = Json.decodeFromString<BitwardenImportCard>(str)

        assertEquals("Mr Test", json.cardholderName)
        assertEquals("Mastercard", json.brand)
        assertEquals("0123456789", json.number)
        assertEquals("1990", json.expYear)
        assertEquals("1", json.expMonth)
        assertEquals("456", json.code)

    }

}
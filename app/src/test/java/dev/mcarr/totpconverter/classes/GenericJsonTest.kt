package dev.mcarr.totpconverter.classes

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class GenericJsonTest{

    @Test
    fun testParseOtpAuthUriInvalidFormat(){
        val uriString = "auth://totp/mysecret"
        val args = GenericJson.parseOtpAuthUri(uriString)
        assertEquals("", args.secret)
        assertEquals(6, args.digits)
        assertEquals(30, args.period)
        assertEquals("sha1", args.algo)
        assertEquals("", args.name)
        assertEquals("", args.issuer)
    }

    @Test
    fun testParseOtpAuthUriFormat1(){
        val uriString = "otpauth://totp/mysecret"
        val args = GenericJson.parseOtpAuthUri(uriString)
        assertEquals("mysecret", args.secret)
        assertEquals(6, args.digits)
        assertEquals(30, args.period)
        assertEquals("sha1", args.algo)
        assertEquals("", args.name)
        assertEquals("", args.issuer)
    }

    @Test
    fun testParseOtpAuthUriFormat2(){
        val uriString = "otpauth://totp/Facebook:myusername?issuer=Facebook&secret=abc"
        val args = GenericJson.parseOtpAuthUri(uriString)
        assertEquals("abc", args.secret)
        assertEquals(6, args.digits)
        assertEquals(30, args.period)
        assertEquals("sha1", args.algo)
        assertEquals("myusername", args.name)
        assertEquals("Facebook", args.issuer)
    }

    @Test
    fun testParseOtpAuthUriFormat3(){
        val uriString = "otpauth://totp/Facebook:myusername?secret=abc"
        val args = GenericJson.parseOtpAuthUri(uriString)
        assertEquals("abc", args.secret)
        assertEquals(6, args.digits)
        assertEquals(30, args.period)
        assertEquals("sha1", args.algo)
        assertEquals("myusername", args.name)
        assertEquals("Facebook", args.issuer)
    }

    @Test
    fun testParseOtpAuthUriFormat4(){
        val uriString = "otpauth://totp/Facebook?secret=abc"
        val args = GenericJson.parseOtpAuthUri(uriString)
        assertEquals("abc", args.secret)
        assertEquals(6, args.digits)
        assertEquals(30, args.period)
        assertEquals("sha1", args.algo)
        assertEquals("", args.name)
        assertEquals("Facebook", args.issuer)
    }

    @Test
    fun testParseOtpAuthUriFormat5(){
        val uriString = "otpauth://totp/Facebook?secret=abc&digits=5&period=10&algorithm=SHA512"
        val args = GenericJson.parseOtpAuthUri(uriString)
        assertEquals("abc", args.secret)
        assertEquals(5, args.digits)
        assertEquals(10, args.period)
        assertEquals("SHA512", args.algo)
        assertEquals("", args.name)
        assertEquals("Facebook", args.issuer)
    }

}
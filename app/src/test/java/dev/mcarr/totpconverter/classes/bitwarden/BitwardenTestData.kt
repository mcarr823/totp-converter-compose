package dev.mcarr.totpconverter.classes.bitwarden

object BitwardenTestData {

    fun getFullObject(): String {

        val item1 = getLoginItem1()
        val item2 = getLoginItem2()
        val item3 = getCardItem1()
        val item4 = getSecureNoteItem1()
        val item5 = getIdentityItem1()

        return """
            { "items": [ $item1, $item2, $item3, $item4, $item5 ] }
        """.trimIndent()
    }

    fun getLoginItem1(): String = """
        {
            "type": 1,
            "name": "Login Item's Name",
            "login": ${getLogin1()}
        }
    """.trimIndent()

    fun getLogin1(): String = """
        {
            "username": "testname",
            "password": "testpass",
            "totp": "otpauth://totp/mysecret",
            "uris":[${getLoginUri1()}]
        }
    """.trimIndent()

    fun getLoginUri1(): String = """
        {
            "match":null,
            "uri":"https://my.domain.com"
        }
    """.trimIndent()

    fun getSecureNoteItem1(): String = """
        {
            "type": 2,
            "name": "Secure Note Item's Name",
            "secureNote": {}                     
        }
    """.trimIndent()

    fun getCardItem1(): String = """
        {
            "type": 3,
            "name": "Card Item's Name",
            "card": ${getCard1()}              
        }
    """.trimIndent()

    fun getCard1(): String = """
        {
            "cardholderName": "Mr Test",
            "brand": "Mastercard",
            "number": "0123456789",
            "expMonth": "1",
            "expYear": "1990",
            "code": "456"
        }
    """.trimIndent()

    fun getIdentityItem1(): String = """
        {
            "type": 4,
            "name": "Identity Item's Name",
            "identity": {}                    
        }
    """.trimIndent()

    fun getLoginItem2(): String = """
        {
            "type": 1,
            "name": "MyUsername",
            "login": {
                "totp": "otpauth://totp/MyUsername?issuer=Facebook&secret=abc123",
                "uris":[{
                    "match":null,
                    "uri":"https://my.domain.com"
                }]
            }
        }
    """.trimIndent()

}
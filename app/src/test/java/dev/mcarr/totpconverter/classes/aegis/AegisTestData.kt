package dev.mcarr.totpconverter.classes.aegis

object AegisTestData {
    fun getFullObject(): String {
        return """
            {
                "version": 1,
                "header": {
                    "slots": null,
                    "params": null
                },
                "db": ${getDb1()}
            }
        """.trimIndent()
    }

    fun getDb1() = """
        {
            "version": 3,
            "entries": [
                ${getItem1()},
                ${getItem2()},
                ${getItem3()}
            ],
            "groups": []
        }
    """.trimIndent()

    fun getItem1() = """
        {
            "type": "totp",
            "uuid": "078c5a24-657d-4088-97a0-ce14102d2158",
            "name": "MEGA - MEGA:test@test.com",
            "issuer": "MEGA",
            "note": "",
            "favorite": false,
            "icon": null,
            "info": ${getEntryInfo1()},
            "groups": []
        }
    """.trimIndent()

    fun getItem2() = """
        {
            "type": "steam",
            "uuid": "0c919828-9d81-45d2-a0d7-0f9b5a703061",
            "name": "steam",
            "issuer": "",
            "note": "",
            "favorite": false,
            "icon": null,
            "info": ${getEntryInfo2()},
            "groups": []
        }
    """.trimIndent()

    fun getItem3() = """
        {
            "type": "totp",
            "uuid": "af1f60d7-67ac-45c4-9d9c-de566377b61a",
            "name": "myGov",
            "issuer": "",
            "note": "",
            "favorite": false,
            "icon": null,
            "info": ${getEntryInfo3()},
            "groups": []
        }
    """.trimIndent()

    fun getEntryInfo1() = """
        {
            "secret": "abc123",
            "algo": "SHA1",
            "digits": 6,
            "period": 30
        }
    """.trimIndent()

    fun getEntryInfo2() = """
        {
            "secret": "def345",
            "algo": "SHA1",
            "digits": 5,
            "period": 30
        }
    """.trimIndent()

    fun getEntryInfo3() = """
        {
            "secret": "efg456",
            "algo": "SHA512",
            "digits": 6,
            "period": 30
        }
    """.trimIndent()
}
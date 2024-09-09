package dev.mcarr.totpconverter.classes.aegis

fun AegisTestData(): String {
    return """
        {
            "version": 1,
            "header": {
                "slots": null,
                "params": null
            },
            "db": {
                "version": 3,
                "entries": [
                    {
                        "type": "totp",
                        "uuid": "078c5a24-657d-4088-97a0-ce14102d2158",
                        "name": "MEGA - MEGA:test@test.com",
                        "issuer": "MEGA",
                        "note": "",
                        "favorite": false,
                        "icon": null,
                        "info": {
                            "secret": "abc123",
                            "algo": "SHA1",
                            "digits": 6,
                            "period": 30
                        },
                        "groups": []
                    },
                    {
                        "type": "steam",
                        "uuid": "0c919828-9d81-45d2-a0d7-0f9b5a703061",
                        "name": "steam",
                        "issuer": "",
                        "note": "",
                        "favorite": false,
                        "icon": null,
                        "info": {
                            "secret": "def345",
                            "algo": "SHA1",
                            "digits": 5,
                            "period": 30
                        },
                        "groups": []
                    },
                    {
                        "type": "totp",
                        "uuid": "af1f60d7-67ac-45c4-9d9c-de566377b61a",
                        "name": "myGov",
                        "issuer": "",
                        "note": "",
                        "favorite": false,
                        "icon": null,
                        "info": {
                            "secret": "efg456",
                            "algo": "SHA512",
                            "digits": 6,
                            "period": 30
                        },
                        "groups": []
                    }
                ],
                "groups": []
            }
        }
    """.trimIndent()
}
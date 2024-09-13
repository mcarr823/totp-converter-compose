package dev.mcarr.totpconverter.classes.proton

object ProtonTestData {
    fun getFullObject(): String {
        return """
        {
            "encrypted": false,
            "userId": "test",
            "vaults":
            {
                "vault2": ${getVault1()}
            }
        }
    """.trimIndent()
    }

    fun getVault1() = """
        {
            "name": "Personal",
            "description": "Personal vault",
            "display":
            {
                "color": 0,
                "icon": 0
            },
            "items": [ ${getItem1()}, ${getItem2()} ]
        }
    """.trimIndent()

    fun getItem1() = """
        {
            "itemId": "item1",
            "shareId": "share1",
            "data": ${getData1()},
            "state": 1,
            "aliasEmail": null,
            "contentFormatVersion": 3,
            "createTime": 1697597454,
            "modifyTime": 1715201864,
            "pinned": false
        }
    """.trimIndent()

    fun getItem2() = """
        {
            "itemId": "item2",
            "shareId": "share2",
            "data": ${getData2()},
            "state": 1,
            "aliasEmail": null,
            "contentFormatVersion": 1,
            "createTime": 1697597453,
            "modifyTime": 1708056760,
            "pinned": true
        }
    """.trimIndent()

    fun getMetadata1() = """
        {
            "name": "my.domain.com",
            "note": "testnote",
            "itemUuid": "15b83727"
        }
    """.trimIndent()

    fun getMetadata2() = """
        {
            "name": "account.proton.me",
            "note": "",
            "itemUuid": "f2ded5eb"
        }
    """.trimIndent()

    fun getContent1() = """
        {
            "username": "me@my.domain.com",
            "password": "mypassword",
            "urls":
            [
                "https://my.domain.com/login",
                "https://my.domain.com/"
            ],
            "totpUri": "otpauth://totp/Proton:proton%40my.domain.com?issuer=Proton&secret=abc123&algorithm=SHA1&digits=6&period=30",
            "passkeys":
            [
                "blahblah1",
                "blahblah2"
            ]
        }
    """.trimIndent()

    fun getContent2() = """
        {
            "username": "me@proton.com",
            "password": "",
            "urls": [],
            "totpUri": "",
            "passkeys": []
        }
    """.trimIndent()

    fun getData1() = """
        {
            "metadata": ${getMetadata1()},
            "extraFields": [],
            "platformSpecific":
            {
                "android":
                {
                    "allowedApps": []
                }
            },
            "type": "login",
            "content": ${getContent1()},
            "lastRevision": 4
        }
    """.trimIndent()

    fun getData2() = """
        {
            "metadata": ${getMetadata2()},
            "extraFields": [],
            "platformSpecific": {
                "android": {
                    "allowedApps": [
                        {
                            "packageName": "me.proton.android.drive",
                            "hashes": [
                                "me.proton.android.drive"
                            ],
                            "appName": "me.proton.android.drive"
                        },
                        {
                            "packageName": "ch.protonvpn.android",
                            "hashes": [],
                            "appName": "Proton VPN"
                        },
                        {
                            "packageName": "ch.protonmail.android",
                            "hashes": [],
                            "appName": "Proton Mail"
                        },
                        {
                            "packageName": "me.proton.android.calendar",
                            "hashes": [],
                            "appName": "Proton Calendar"
                        }
                    ]
                }
            },
            "type": "login",
            "content": ${getContent2()}
        }
    """.trimIndent()
}
package dev.mcarr.totpconverter.classes.bitwarden

fun BitwardenTestData(): String {
    return """
        {
          "items": [
            {
            "type": 1,
            "name": "Login Item's Name",
            "login": {
              "totp": "otpauth://totp/mysecret",
              "uris":[{
                "match":null,
                "uri":"https://my.domain.com"
              }]
            }
          },
          {
            "type": 2,
            "name": "Secure Note Item's Name",
            "secureNote": {}                     
          },
          {
            "type": 3,
            "name": "Card Item's Name",
            "card": {}                         
          },
          {
            "type": 4,
            "name": "Identity Item's Name",
            "identity": {}                     
          },
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
          ]
        }
    """.trimIndent()
}
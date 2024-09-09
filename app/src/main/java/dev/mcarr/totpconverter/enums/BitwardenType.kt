package dev.mcarr.totpconverter.enums

enum class BitwardenType(val value: Int){
    LOGIN(1),
    SECURE_NOTE(2),
    CARD(3),
    IDENTITY(4)
}
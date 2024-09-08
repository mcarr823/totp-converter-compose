package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportJson
import org.json.JSONObject

class ProtonImport : JSONObject(), IProtonImportJson {

    override val encrypted = getBoolean("encrypted")

    override val vaults = arrayListOf<ProtonImportVault>().apply {
        val v = getJSONObject("vaults")
        v.keys().forEach { key ->
            val value = v.getJSONObject(key) as ProtonImportVault
            add(value)
        }
    }

}


package dev.mcarr.totpconverter.classes.proton

import dev.mcarr.totpconverter.interfaces.proton.IProtonImportJson
import dev.mcarr.totpconverter.interfaces.proton.IProtonImportVault
import kotlinx.serialization.Serializable
import org.json.JSONObject

@Serializable
data class ProtonImport(
    override val encrypted: Boolean,
    override val vaults: List<IProtonImportVault>
) : IProtonImportJson {



//    override val vaults: List<ProtonImportVault>().apply {
//        val v = getJSONObject("vaults")
//        v.keys().forEach { key ->
//            val value = v.getJSONObject(key) as ProtonImportVault
//            add(value)
//        }
//    }

}


package dev.mcarr.totpconverter.classes.bitwarden

import dev.mcarr.totpconverter.interfaces.bitwarden.IBitwardenImportFolder
import org.json.JSONObject

class BitwardenImportFolder : JSONObject(), IBitwardenImportFolder {
    override val id = getString("id");
    override val name = getString("name");
}
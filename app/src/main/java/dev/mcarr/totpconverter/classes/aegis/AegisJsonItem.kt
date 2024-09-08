package dev.mcarr.totpconverter.classes.aegis

import dev.mcarr.totpconverter.classes.GenericJsonEntry
import dev.mcarr.totpconverter.interfaces.aegis.IAegisImportEntry

class AegisJsonItem(data: IAegisImportEntry) : GenericJsonEntry() {

    override val type = data.type
    override val name = data.name;
    override val issuer = data.issuer;
    override val secret = data.info.secret;
    override val algo = data.info.algo;
    override val digits = data.info.digits;
    override val period = data.info.period;
    override val websites: List<String> = listOf();

}
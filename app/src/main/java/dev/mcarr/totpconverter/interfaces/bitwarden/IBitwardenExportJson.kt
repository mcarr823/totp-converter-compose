package dev.mcarr.totpconverter.interfaces.bitwarden

/**
 * Represents a minimal JSON object in the format expected by Bitwarden
 * when importing data. Based on:
 * https://bitwarden.com/help/condition-bitwarden-import/#minimum-required-key-value-pairs
 *
 * eg.
 * {"items": [
 *     {
 *         "type": 1,
 *         "name": "My Service",
 *         "login": {
 *             "totp": "otpauth://totp/mysecret",
 *             "uris": [
 *                 "https://my.service.com"
 *             ]
 *         }
 *     }
 * ]}
 */

interface IBitwardenExportJson{
    val items: List<IBitwardenExportItem>;
}

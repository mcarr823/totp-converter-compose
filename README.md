# TOTP Converter

[![Compile debug](https://github.com/mcarr823/totp-converter-compose/actions/workflows/compile.yml/badge.svg)](https://github.com/mcarr823/totp-converter-compose/actions/workflows/compile.yml)
[![Unit tests](https://github.com/mcarr823/totp-converter-compose/actions/workflows/unittest.yml/badge.svg)](https://github.com/mcarr823/totp-converter-compose/actions/workflows/unittest.yml)

This program converts JSON files between a few different 2FA providers' formats.

The intended use for this program is to move from one 2FA provider to another by exporting your tokens from one provider and converting them into a different format.

This app is the Android port of the [self-hosted web version](https://github.com/mcarr823/totp-json-converter).

* This app is a work-in-progress and is not yet functional.

![Preview Image](screenshots/home.png)

## License

This app uses the Github icon provided by Github, per their [terms of use](https://github.com/logos).

Other icons are provided by Google under Apache License Version 2.0 as part of their [Material Icons](https://developers.google.com/fonts/docs/material_icons) library.

The source code for this app itself is GPLv3 licensed. See the [LICENSE file](./LICENSE).

## TODO

- support for other providers
- support for username/password fields as well
- settings page to enable/disable username, password, etc.
- support for encrypted import files
- support for encrypted export files


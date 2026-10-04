# Easier Proud Soul Acquisition

Minecraft Forge **1.20.1** addon mod.

## License

Code: MIT. Models and textures: CC BY-NC 4.0 (noncommercial use with attribution).
See [LICENSE](../LICENSE) and [LICENSE-ASSETS.md](../LICENSE-ASSETS.md) for scope
and terms. Permissions granted for previously released versions remain unchanged.

## Feature
Adds an extra way to obtain SlashBlade:Resharped item `slashblade:proudsoul`:

- When **grass, tall grass, or fern** is broken, there is a **10%** chance to drop `proudsoul_seed`.
- Plant the seeds to grow proudsoul crops that yield `slashblade:proudsoul`.

Implementation modifies grass loot tables to add seed drops.

## Dev setup
This project depends on `SlashBlade_Resharped` from MMMaven.

### If Gradle fails to download from MMMaven (SSL/PKIX)
Some networks / Windows trust stores can cause:

`SSLHandshakeException: PKIX path building failed`

Workarounds:

1. **Recommended**: download the mod jar manually and put it in `libs/`.
   - Create `libs/`
   - Put `SlashBlade_Resharped-<version>.jar` there
   - The build script can be configured to use `flatDir { dir 'libs' }`.

2. Configure your corporate proxy / install missing CA certificates for Java.

## Config / Data
Global loot modifier JSON:
- `src/main/resources/data/forge/loot_modifiers/global_loot_modifiers.json`
- `src/main/resources/data/forge/loot_modifiers/proudsoul_drop.json`

You can tweak the drop chance in the mod's config file (`config/easier_proud_soul_acquisition-common.toml`).


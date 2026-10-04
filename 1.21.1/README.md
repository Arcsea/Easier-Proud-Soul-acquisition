# Minecraft 1.21.1 NeoForge 版本

此目录是「简易耀魂获取」的 Minecraft **1.21.1 / NeoForge** 项目，开发环境使用
**Java 21**，需要安装 SlashBlade: Resharped。

## 功能

- 破坏短草、高草或蕨，默认有 10% 概率掉落耀魂种子。
- 在耕地上种植种子，作物经过 0～7 共八个生长阶段。
- 成熟作物收获 1 个耀魂和种子，种子数量受时运影响；未成熟作物掉落种子。
- 种子掉落概率可通过 `config/easierproudsoulacquisition-common.toml`
  中的 `grassSeedChance` 调整。

## 构建

在此目录运行 `./gradlew build`（Windows 使用 `gradlew.bat build`）。
输出位于 `build/libs/`，JAR 名称包含 `neoforge-1.21.1`。

构建脚本从 CurseMaven 获取 SlashBlade 开发依赖。

## 许可

代码：MIT，见 [LICENSE](../LICENSE)。
模型与材质：非商用（CC BY-NC 4.0），见 [LICENSE-ASSETS.md](../LICENSE-ASSETS.md)。

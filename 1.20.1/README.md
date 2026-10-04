# Minecraft 1.20.1 Forge 版本

此目录是「简易耀魂获取」的 Minecraft **1.20.1 / Forge** 项目，开发环境使用
**Java 17**，需要安装 SlashBlade: Resharped。

## 功能

- 破坏草、高草或蕨，默认有 10% 概率掉落耀魂种子。
- 在耕地上种植种子，作物经过 0～7 共八个生长阶段。
- 成熟作物收获 1～3 个耀魂和 1～2 个种子；未成熟作物掉落种子。
- 种子掉落概率可通过 `config/easier_proud_soul_acquisition-common.toml`
  中的 `grass_seed_drop.chance` 调整。

## 构建

在此目录运行 `./gradlew build`（Windows 使用 `gradlew.bat build`）。
输出位于 `build/libs/`，JAR 名称包含 `forge-1.20.1`。

SlashBlade 开发依赖优先使用 `libs/SlashBlade_Resharped-0.6.0.jar`；
该文件不存在时，构建脚本从 CurseMaven 获取依赖。

## 许可

代码：MIT，见 [LICENSE](../LICENSE)。
模型与材质：非商用（CC BY-NC 4.0），见 [LICENSE-ASSETS.md](../LICENSE-ASSETS.md)。

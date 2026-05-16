package org.examplea.easier_proud_soul_acquisition;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public final class Config {
    private Config() {}

    public static final ForgeConfigSpec SPEC;

    // existing example config fields used by the template mod main class
    // NOTE: don't call .get() in static init (Forge loads configs later in lifecycle).
    public static ForgeConfigSpec.BooleanValue logDirtBlock;
    public static ForgeConfigSpec.IntValue magicNumber;
    public static ForgeConfigSpec.ConfigValue<String> magicNumberIntroduction;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> items;

    // grass breaking seed drop config
    public static ForgeConfigSpec.DoubleValue grassSeedChance;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("General settings").push("general");
        logDirtBlock = builder
            .comment("Log the DIRT block registry name on common setup")
            .define("logDirtBlock", true);
        magicNumber = builder
            .comment("An example number")
            .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);
        magicNumberIntroduction = builder
            .comment("Intro text for magic number")
            .define("magicNumberIntroduction", "The magic number is: ");
        items = builder
            .comment("An example list")
            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), o -> o instanceof String);
        builder.pop();

        builder.comment("Grass breaking seed drop settings").push("grass_seed_drop");
        grassSeedChance = builder
            .comment("Drop chance for proudsoul seeds when breaking grass (0.0-1.0)")
            .defineInRange("chance", 0.10d, 0.0d, 1.0d);
        builder.pop();

        SPEC = builder.build();
    }

    // ---- Safe getters (use defaults if accessed too early during dev bootstrap) ----

    public static boolean logDirtBlock() {
        try {
            return logDirtBlock.get();
        } catch (IllegalStateException ignored) {
            return true;
        }
    }

    public static int magicNumber() {
        try {
            return magicNumber.get();
        } catch (IllegalStateException ignored) {
            return 42;
        }
    }

    public static String magicNumberIntroduction() {
        try {
            return magicNumberIntroduction.get();
        } catch (IllegalStateException ignored) {
            return "The magic number is: ";
        }
    }

    public static List<? extends String> items() {
        try {
            return items.get();
        } catch (IllegalStateException ignored) {
            return List.of("minecraft:iron_ingot");
        }
    }

    public static double grassSeedChance() {
        try {
            return grassSeedChance.get();
        } catch (IllegalStateException ignored) {
            return 0.10d;
        }
    }
}

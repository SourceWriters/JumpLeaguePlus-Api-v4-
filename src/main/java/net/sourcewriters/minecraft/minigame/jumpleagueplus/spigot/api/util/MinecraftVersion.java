package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.util;

import org.bukkit.Bukkit;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.exception.IncompatibleDataException;

public enum MinecraftVersion {

    UNKNOWN(-1),
    v1_8(0x0),
    v1_9(0x0),
    v1_10(0x0),
    v1_11(0x0),
    v1_12(0x0),
    v1_13(0x1),
    v1_14(0x1),
    v1_15(0x1),
    v1_16(0x1),
    v1_17(0x1),
    v1_18(0x1),
    v1_19(0x1);

    public static final MinecraftVersion VERSION = parseVersion();

    private static MinecraftVersion parseVersion() {
        try {
            String formatted = Bukkit.getServer().getClass().getPackage().getName().split("\\.", 4)[3];
            String[] parts = formatted.split("_");
            if (parts.length < 2) {
                return MinecraftVersion.UNKNOWN;
            }
            return MinecraftVersion.valueOf(parts[0] + '_' + parts[1]);
        } catch (IllegalArgumentException | NoClassDefFoundError ignore) {
            return MinecraftVersion.UNKNOWN;
        }
    }

    public static MinecraftVersion getVersion(short versionId) {
        MinecraftVersion[] versions = MinecraftVersion.values();
        if (versionId < 0 || versionId > versions.length) {
            return MinecraftVersion.UNKNOWN;
        }
        return versions[versionId];
    }

    public static CompatibilityState getState(short versionId) {
        return VERSION.getCompatibilityState(versionId);
    }

    public static CompatibilityState getStateOrThrow(short versionId) throws IncompatibleDataException {
        CompatibilityState state = VERSION.getCompatibilityState(versionId);
        if (state == CompatibilityState.INCOMPATIBLE) {
            throw new IncompatibleDataException(versionId);
        }
        return state;
    }

    private final int features;
    private final short versionId = (short) (ordinal() - 1);

    private MinecraftVersion(int features) {
        this.features = features;
    }

    public int getFeatures() {
        return features;
    }

    public short getVersionId() {
        return versionId;
    }

    public boolean isBlockDataSupported() {
        return Bit.isSet(features, 0x1);
    }

    public CompatibilityState getCompatibilityState(short versionId) {
        MinecraftVersion version = getVersion(versionId);
        if (version == null) {
            return CompatibilityState.INCOMPATIBLE;
        }
        if (this.features == version.features) {
            return this.versionId >= versionId ? CompatibilityState.FULL : CompatibilityState.PARTIEL;
        }
        return CompatibilityState.INCOMPATIBLE;
    }

}

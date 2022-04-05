package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.util;

import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Bee;
import org.bukkit.generator.WorldInfo;

public enum CoreVersion {

    v1_8,
    v1_13,
    v1_15,
    v1_17;

    public static final CoreVersion VERSION = detectVersion();

    private static CoreVersion detectVersion() {
        try {
            WorldInfo.class.getClass();
            return CoreVersion.v1_17;
        } catch (NoClassDefFoundError ignore) {
        }
        try {
            Bee.class.getClass();
            return CoreVersion.v1_15;
        } catch (NoClassDefFoundError ignore) {
        }
        try {
            BlockData.class.getClass();
            return CoreVersion.v1_13;
        } catch (NoClassDefFoundError ignore) {
        }
        return CoreVersion.v1_8;
    }

}

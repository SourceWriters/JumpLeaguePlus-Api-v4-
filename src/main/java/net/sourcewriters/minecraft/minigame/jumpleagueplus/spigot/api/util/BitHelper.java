package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.util;

public final class BitHelper {

    private BitHelper() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static long merge20BitUnsigned(final long value) {
        return (Math.abs(value) & 0xFFFFF) << 0;
    }

    public static long unmerge20BitUnsigned(final long value) {
        return value >> 0 & 0xFFFFF;
    }

    public static long merge24BitSigned(final long value) {
        if (value < 0) {
            return 1 & 0b1 | (Math.abs(value) & 0x7FFFFFF) << 1;
        }
        return 0 & 0b1 | (Math.abs(value) & 0x7FFFFFF) << 1;
    }

    public static long unmerge24BitSigned(final long value) {
        final long out = value >> 1 & 0x7FFFFFF;
        if ((value >> 0 & 0b1) == 1) {
            return -out;
        }
        return out;
    }

}
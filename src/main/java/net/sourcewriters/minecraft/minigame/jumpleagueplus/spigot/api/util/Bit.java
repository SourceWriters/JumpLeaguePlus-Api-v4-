package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.util;

public final class Bit {

    private Bit() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static long set(final long value, final long mask, final boolean state) {
        if (state) {
            if ((value & mask) != mask) {
                return value | mask;
            }
            return value;
        }
        if ((value & mask) == mask) {
            return value ^ mask;
        }
        return value;
    }

    public static boolean isSet(final long value, final long mask) {
        return (value & mask) == mask;
    }

    public static int set(final int value, final int mask, final boolean state) {
        if (state) {
            if ((value & mask) != mask) {
                return value | mask;
            }
            return value;
        }
        if ((value & mask) == mask) {
            return value ^ mask;
        }
        return value;
    }

    public static boolean isSet(final int value, final int mask) {
        return (value & mask) == mask;
    }

    public static short set(final short value, final short mask, final boolean state) {
        return (short) set((int) value, (int) mask, state);
    }

    public static boolean isSet(final short value, final short mask) {
        return (value & mask) == mask;
    }

    public static byte set(final byte value, final byte mask, final boolean state) {
        return (byte) set((byte) value, (byte) mask, state);
    }

    public static boolean isSet(final byte value, final byte mask) {
        return (value & mask) == mask;
    }

}

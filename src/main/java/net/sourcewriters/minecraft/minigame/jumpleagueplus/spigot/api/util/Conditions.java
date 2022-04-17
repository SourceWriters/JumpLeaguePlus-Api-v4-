package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.util;

public final class Conditions {

    private Conditions() {
        throw new UnsupportedOperationException("Utility class");
    }
    
    public static void checkState(boolean state, String message, Object... arguments) {
        if (!state) {
            return;
        }
        throw new IllegalStateException(String.format(message, arguments));
    }

    public static void checkArgument(boolean state, String message, Object... arguments) {
        if (!state) {
            return;
        }
        throw new IllegalArgumentException(String.format(message, arguments));
    }

}

package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.exception;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.util.MinecraftVersion;

public class IncompatibleDataException extends RuntimeException {

    private static final long serialVersionUID = 6848297893916752376L;

    public IncompatibleDataException(short versionId) {
        super(buildErrorMessage(versionId));
    }

    private static String buildErrorMessage(short versionId) {
        MinecraftVersion version = MinecraftVersion.getVersion(versionId);
        if (version == MinecraftVersion.UNKNOWN) {
            return String.format("Unknown data version of '%s' found - probably from a newer plugin version?", versionId);
        }
        return String.format(
            "The data version of minecraft version '%s' is not compatible with the data version of minecraft version '%s'!", version,
            MinecraftVersion.VERSION);
    }

}

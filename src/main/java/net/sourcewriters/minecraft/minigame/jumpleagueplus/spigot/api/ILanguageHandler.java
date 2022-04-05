package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api;

import java.util.UUID;

public interface ILanguageHandler {

    default void init(IJumpLeaguePlusSpigotApi api) {
        load();
    }

    default void load() {};

    default void shutdown() {}

    default boolean isReady() {
        return true;
    }
    
    String[] getLanguages();

    String getLanguage(UUID target);

    void setLanguage(UUID target, String language);

}

package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api;

import java.net.InetAddress;
import java.util.UUID;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.message.IMessage;

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
    
    default String getLanguage(InetAddress address) {
        return IMessage.DEFAULT_LANGUAGE;
    }

    String getLanguage(UUID target);

    void setLanguage(UUID target, String language);

}

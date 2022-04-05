package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.common.api.IGameInfo;

public interface IJumpLeaguePlusSpigotApi {

    IStatsHandler getStatsHandler();
    
    MessageHandler getMessageHandler();

    ILanguageHandler getLanguageHandler();

    IParkourHandler getParkourHandler();
    
    IParkourManager getParkourManager();
    
    IGameInfo getGameInfo();
    
    void callEvent(Event event);

    static IJumpLeaguePlusSpigotApi getApi() {
        return Bukkit.getServicesManager().getRegistration(IJumpLeaguePlusSpigotApi.class).getProvider();
    }

}

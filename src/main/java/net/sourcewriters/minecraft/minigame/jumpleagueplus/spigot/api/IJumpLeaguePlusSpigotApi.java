package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;

public interface IJumpLeaguePlusSpigotApi {

    IStatsHandler getStatsHandler();
    
    MessageHandler getMessageHandler();

    ILanguageHandler getLanguageHandler();

    IParkourHandler getParkourHandler();
    
    IParkourManager getParkourManager();
    
    void callEvent(Event event);

    static IJumpLeaguePlusSpigotApi getApi() {
        return Bukkit.getServicesManager().getRegistration(IJumpLeaguePlusSpigotApi.class).getProvider();
    }

}

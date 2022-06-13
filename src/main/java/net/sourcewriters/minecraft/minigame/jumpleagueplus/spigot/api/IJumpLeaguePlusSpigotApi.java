package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api;

import java.util.concurrent.CompletableFuture;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.common.api.IGameInfo;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.common.api.JumpGamePhase;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.random.ISeededRandom;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.random.RandomType;

public interface IJumpLeaguePlusSpigotApi {

    IStatsHandler getStatsHandler();

    MessageHandler getMessageHandler();

    ILanguageHandler getLanguageHandler();

    IParkourHandler getParkourHandler();

    IParkourManager getParkourManager();

    ILootManager getLootManager();

    JumpGamePhase getGamePhase();

    IGameInfo getGameInfo();

    CompletableFuture<Void> callEvent(Event event);

    ISeededRandom newRandom(RandomType type);
    
    boolean isDebug();

    static IJumpLeaguePlusSpigotApi getApi() {
        return Bukkit.getServicesManager().getRegistration(IJumpLeaguePlusSpigotApi.class).getProvider();
    }

}

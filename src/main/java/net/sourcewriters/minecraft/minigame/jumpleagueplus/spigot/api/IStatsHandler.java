package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.bukkit.entity.AnimalTamer;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.GlobalStats;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.RoundStats;

public interface IStatsHandler {

    default void init(IJumpLeaguePlusSpigotApi api) {}

    default void shutdown() {}

    default boolean isReady() {
        return true;
    }
    
    void resetRound();
    
    void removeRoundUser(UUID user);
    
    UUID[] getRoundUsers();
    
    default RoundStats getRoundStats(AnimalTamer tamer) {
        return getRoundStats(tamer.getUniqueId());
    }

    RoundStats getRoundStats(UUID owner);

    GlobalStats getStats(UUID owner);

    default CompletableFuture<Void> save(RoundStats stats) {
        return save(getStats(stats.getOwner()).add(stats));
    }

    CompletableFuture<Void> save(GlobalStats stats);

}

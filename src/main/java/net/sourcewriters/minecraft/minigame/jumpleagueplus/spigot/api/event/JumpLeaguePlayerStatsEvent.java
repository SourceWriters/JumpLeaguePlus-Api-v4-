package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import java.util.Objects;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.RoundStats;

public abstract class JumpLeaguePlayerStatsEvent extends JumpLeaguePlayerEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final RoundStats stats;

    public JumpLeaguePlayerStatsEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull Player player, @NonNull RoundStats stats) {
        super(api, player);
        this.stats = Objects.requireNonNull(stats);
    }

    @NonNull
    public RoundStats getStats() {
        return stats;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

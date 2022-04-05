package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import java.util.Objects;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.RoundStats;

public class JumpLeaguePlayerLostEvent extends JumpLeaguePlayerStatsEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Player killer;

    public JumpLeaguePlayerLostEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull Player player, @NonNull Player killer, @NonNull RoundStats stats) {
        super(api, player, stats);
        this.killer = Objects.requireNonNull(killer);
    }

    @NonNull
    public Player getKiller() {
        return killer;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

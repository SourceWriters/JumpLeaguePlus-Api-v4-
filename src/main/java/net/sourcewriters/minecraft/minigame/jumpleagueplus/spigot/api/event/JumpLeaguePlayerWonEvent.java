package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.RoundStats;

public class JumpLeaguePlayerWonEvent extends JumpLeaguePlayerStatsEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    public JumpLeaguePlayerWonEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull Player player, @NonNull RoundStats stats) {
        super(api, player, stats, false);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

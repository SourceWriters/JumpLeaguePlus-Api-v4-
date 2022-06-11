package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import java.util.Objects;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;

public class JumpLeaguePlayerDeathEvent extends JumpLeaguePlayerEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Player killer;

    public JumpLeaguePlayerDeathEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull Player player, @NonNull Player killer) {
        super(api, player, false);
        this.killer = Objects.requireNonNull(killer);
    }

    @NonNull
    public final Player getKiller() {
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

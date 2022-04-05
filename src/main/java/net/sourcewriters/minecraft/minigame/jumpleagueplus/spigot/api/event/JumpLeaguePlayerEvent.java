package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import java.util.Objects;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;

public abstract class JumpLeaguePlayerEvent extends JumpLeagueEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Player player;

    public JumpLeaguePlayerEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull Player player) {
        super(api);
        this.player = Objects.requireNonNull(player);
    }

    @NonNull
    public final Player getPlayer() {
        return player;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

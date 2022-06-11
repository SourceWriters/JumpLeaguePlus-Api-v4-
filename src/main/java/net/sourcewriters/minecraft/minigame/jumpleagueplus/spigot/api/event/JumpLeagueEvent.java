package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import java.util.Objects;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;

public abstract class JumpLeagueEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final IJumpLeaguePlusSpigotApi api;

    public JumpLeagueEvent(@NonNull IJumpLeaguePlusSpigotApi api, boolean async) {
        super(async);
        this.api = Objects.requireNonNull(api);
    }

    @NonNull
    public final IJumpLeaguePlusSpigotApi getApi() {
        return api;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

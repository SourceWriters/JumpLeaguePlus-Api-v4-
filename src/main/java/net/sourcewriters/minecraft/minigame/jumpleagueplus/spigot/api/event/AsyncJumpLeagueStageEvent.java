package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourStage;

public abstract class AsyncJumpLeagueStageEvent extends JumpLeagueEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final IParkourStage stage;

    public AsyncJumpLeagueStageEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull IParkourStage stage) {
        super(api, true);
        this.stage = stage;
    }

    @NonNull
    public final IParkourStage getStage() {
        return stage;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

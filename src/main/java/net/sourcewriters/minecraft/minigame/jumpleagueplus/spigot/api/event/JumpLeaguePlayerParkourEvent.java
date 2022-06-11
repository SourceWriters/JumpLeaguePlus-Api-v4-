package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import java.util.Objects;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourModule;

public abstract class JumpLeaguePlayerParkourEvent extends JumpLeaguePlayerEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final IParkourModule module;
    private final int moduleId;

    public JumpLeaguePlayerParkourEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull Player player, @NonNull IParkourModule module, @NonNull int moduleId, boolean async) {
        super(api, player, async);
        this.module = Objects.requireNonNull(module);
        this.moduleId = Objects.requireNonNull(moduleId);
    }

    @NonNull
    public IParkourModule getModule() {
        return module;
    }

    @NonNull
    public int getModuleId() {
        return moduleId;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

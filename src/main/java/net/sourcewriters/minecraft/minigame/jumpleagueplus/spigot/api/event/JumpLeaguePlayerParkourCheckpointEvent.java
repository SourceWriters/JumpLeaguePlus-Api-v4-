package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import java.util.Objects;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourModule;

public class JumpLeaguePlayerParkourCheckpointEvent extends JumpLeaguePlayerParkourEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final IParkourModule oldModule;
    private final int oldModuleId;

    public JumpLeaguePlayerParkourCheckpointEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull Player player, @NonNull IParkourModule module, @NonNull int moduleId,
        @NonNull IParkourModule oldModule, @NonNull int oldModuleId) {
        super(api, player, module, moduleId);
        this.oldModule = Objects.requireNonNull(oldModule);
        this.oldModuleId = Objects.requireNonNull(oldModuleId);
    }

    @NonNull
    public IParkourModule getOldModule() {
        return oldModule;
    }

    @NonNull
    public int getOldModuleId() {
        return oldModuleId;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

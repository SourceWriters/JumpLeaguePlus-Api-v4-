package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import java.util.Objects;

import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.order.IParkourDifficultyCollection;

public class JumpLeagueParkourOrderEvent extends JumpLeagueEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final IParkourDifficultyCollection modules;

    public JumpLeagueParkourOrderEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull IParkourDifficultyCollection modules) {
        super(api);
        this.modules = Objects.requireNonNull(modules);
    }

    @NonNull
    public IParkourDifficultyCollection getModules() {
        return modules;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

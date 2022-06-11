package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourModule;

public class JumpLeaguePlayerParkourFailEvent extends JumpLeaguePlayerParkourEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    public JumpLeaguePlayerParkourFailEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull Player player, @NonNull IParkourModule module,
        @NonNull int moduleId) {
        super(api, player, module, moduleId, false);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourStage;

public class AsyncJumpLeagueStageExitEvent extends AsyncJumpLeagueStageEvent {

    private final Player player;

    public AsyncJumpLeagueStageExitEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull IParkourStage stage, @NonNull Player player) {
        super(api, stage);
        this.player = player;
    }

    @NonNull
    public final Player getPlayer() {
        return player;
    }

}

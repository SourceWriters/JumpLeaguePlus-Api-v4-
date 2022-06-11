package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourStage;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourStage.EnterState;

public class AsyncJumpLeagueStageEnterEvent extends AsyncJumpLeagueStageEvent {

    private final Player player;
    private EnterState state;

    public AsyncJumpLeagueStageEnterEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull IParkourStage stage, @NonNull Player player,
        @NonNull EnterState state) {
        super(api, stage);
        this.player = player;
        this.state = state;
    }

    @NonNull
    public final Player getPlayer() {
        return player;
    }

    public final boolean canEnter() {
        return state.canEnter();
    }

    @NonNull
    public final EnterState getState() {
        return state;
    }

    public final void setState(EnterState state) {
        this.state = state == null ? EnterState.DENIED : state;
    }

}

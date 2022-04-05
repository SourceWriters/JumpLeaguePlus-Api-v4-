package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourStage;

public class JumpLeagueStageExpandEvent extends JumpLeagueStageEvent {

    private final Player player;

    private int newWidth;
    private int newLength;

    public JumpLeagueStageExpandEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull IParkourStage stage, @NonNull Player player) {
        super(api, stage);
        this.player = player;
    }

    @NonNull
    public final Player getPlayer() {
        return player;
    }

    public final int getNewLength() {
        return newLength;
    }

    public final int getNewWidth() {
        return newWidth;
    }

    public final void setNewWidth(int newWidth) {
        this.newWidth = newWidth;
    }

    public final void setNewLength(int newLength) {
        this.newLength = newLength;
    }

    public final int getOldLength() {
        return getStage().getLength();
    }

    public final int getOldWidth() {
        return getStage().getWidth();
    }

}

package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import java.util.Optional;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.RoundStats;

public class JumpLeaguePlayerDisqualifyEvent extends JumpLeagueEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final RoundStats stats;
    private final UUID uniqueId;
    private final Reason reason;

    public JumpLeaguePlayerDisqualifyEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull UUID unqiueId, @NonNull RoundStats stats,
        @NonNull Reason reason) {
        super(api);
        this.uniqueId = unqiueId;
        this.stats = stats;
        this.reason = reason;
    }

    public OfflinePlayer getOfflinePlayer() {
        return Bukkit.getOfflinePlayer(uniqueId);
    }

    public Optional<Player> getPlayer() {
        return Optional.ofNullable(Bukkit.getPlayer(uniqueId));
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public RoundStats getStats() {
        return stats;
    }

    public Reason getReason() {
        return reason;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public static enum Reason {

        LEFT,
        NO_REJOIN;

    }

}

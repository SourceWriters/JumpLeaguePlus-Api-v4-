package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import java.util.Objects;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.ILanguageHandler;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IParkourHandler;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IStatsHandler;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.MessageHandler;

public class JumpLeagueApiInitEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private IStatsHandler statsHandler;
    private IParkourHandler parkourHandler;
    private MessageHandler messageHandler;
    private ILanguageHandler languageHandler;

    public JumpLeagueApiInitEvent(@NonNull IStatsHandler statsHandler, @NonNull MessageHandler messageHandler,
        @NonNull ILanguageHandler languageHandler, @NonNull IParkourHandler parkourHandler) {
        this.statsHandler = Objects.requireNonNull(statsHandler);
        this.messageHandler = Objects.requireNonNull(messageHandler);
        this.languageHandler = Objects.requireNonNull(languageHandler);
        this.parkourHandler = Objects.requireNonNull(parkourHandler);
    }

    public void setMessageHandler(@NonNull MessageHandler messageHandler) {
        this.messageHandler = Objects.requireNonNull(messageHandler);
    }

    @NonNull
    public MessageHandler getMessageHandler() {
        return messageHandler;
    }

    public void setStatsHandler(@NonNull IStatsHandler statsHandler) {
        this.statsHandler = Objects.requireNonNull(statsHandler);
    }

    @NonNull
    public IStatsHandler getStatsHandler() {
        return statsHandler;
    }

    public void setLanguageHandler(@NonNull ILanguageHandler languageHandler) {
        this.languageHandler = Objects.requireNonNull(languageHandler);
    }

    @NonNull
    public ILanguageHandler getLanguageHandler() {
        return languageHandler;
    }

    public void setParkourHandler(@NonNull IParkourHandler parkourHandler) {
        this.parkourHandler = Objects.requireNonNull(parkourHandler);
    }

    @NonNull
    public IParkourHandler getParkourHandler() {
        return parkourHandler;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

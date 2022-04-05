package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.MessageHandler;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.message.IMessage;

public final class JumpLeagueMessageRegisterEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final MessageHandler messageHandler;
    private final IMessage message;

    public JumpLeagueMessageRegisterEvent(MessageHandler messageHandler, IMessage message) {
        this.messageHandler = messageHandler;
        this.message = message;
    }

    public MessageHandler getMessageHandler() {
        return messageHandler;
    }

    public IMessage getMessage() {
        return message;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

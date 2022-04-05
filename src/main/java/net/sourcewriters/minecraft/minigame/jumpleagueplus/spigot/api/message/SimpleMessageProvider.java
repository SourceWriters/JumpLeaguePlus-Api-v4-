package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.message;

import java.util.UUID;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.MessageHandler;

public final class SimpleMessageProvider implements IMessageProvider {

    private final MessageHandler messageHandler;
    private final String id;

    public SimpleMessageProvider(final MessageHandler messageHandler, final String id) {
        this.messageHandler = messageHandler;
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public IMessage getFor(UUID target) {
        return messageHandler.getMessage(target, id);
    }

    @Override
    public IMessage getFor(String language) {
        return messageHandler.getMessage(language, id);
    }

}

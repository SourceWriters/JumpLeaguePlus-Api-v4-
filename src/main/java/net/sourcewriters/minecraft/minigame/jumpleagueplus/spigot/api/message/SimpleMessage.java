package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.message;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.MessageHandler;

public final class SimpleMessage implements IMessage {

    private final MessageHandler messageHandler;
    private final String language;

    private final String id;
    private final String fallback;

    private String translation = null;

    public SimpleMessage(final MessageHandler messageHandler, final String language, final String id, final String fallback) {
        this.messageHandler = messageHandler;
        this.language = language;
        this.id = id;
        this.fallback = fallback;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String language() {
        return language;
    }

    @Override
    public String fallback() {
        return fallback;
    }

    @Override
    public String translation() {
        return translation;
    }

    @Override
    public SimpleMessage translation(String translation) {
        this.translation = translation;
        return this;
    }

    @Override
    public String asMessageString(Keyed... placeholders) {
        return messageHandler.asMessageString(this, placeholders);
    }

    @Override
    public String asColoredMessageString(Keyed... placeholders) {
        return messageHandler.asColoredMessageString(this, placeholders);
    }

}

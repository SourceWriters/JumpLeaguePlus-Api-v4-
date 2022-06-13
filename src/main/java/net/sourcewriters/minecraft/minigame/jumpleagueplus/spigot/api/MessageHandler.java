package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api;

import java.net.InetAddress;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.AnimalTamer;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event.AsyncJumpLeagueMessageRegisterEvent;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.message.IMessage;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.message.IMessageProvider;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.message.Keyed;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.message.Placeholder;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.message.SimpleColor;

public abstract class MessageHandler {

    private ILanguageHandler languageHandler;
    private IJumpLeaguePlusSpigotApi api;

    public final void init(IJumpLeaguePlusSpigotApi api) {
        this.languageHandler = api.getLanguageHandler();
        this.api = api;
        initInternal(api);
    }

    protected final ILanguageHandler getLanguageHandler() {
        return languageHandler;
    }

    protected final IJumpLeaguePlusSpigotApi getApi() {
        return api;
    }

    protected void initInternal(IJumpLeaguePlusSpigotApi api) {
        load();
    };

    public void load() {};

    public void shutdown() {}

    public boolean isReady() {
        return true;
    }

    public final String asMessageString(final IMessage message, final Keyed... placeholders) {
        if (message == null) {
            return "null";
        }
        return apply(message.language(), message.asString(), placeholders);
    }

    protected final String apply(String language, String output, final Keyed[] placeholders) {
        final Placeholder[] values = Placeholder.parse(output);
        if (values.length == 0) {
            return output;
        }
        for (final Placeholder value : values) {
            if (value.isMessage()) {
                final IMessage target = getMessage(language, value.getId());
                if (target == null) {
                    continue;
                }
                output = value.replace(output, target.asMessageString(placeholders));
                continue;
            }
            for (final Keyed placeholder : placeholders) {
                if (!value.getId().equals(placeholder.getKey())) {
                    continue;
                }
                String content = placeholder.getValueOrDefault("null").toString();
                if (!"null".equals(content)) {
                    content = apply(language, content, placeholders);
                }
                output = value.replace(output, content);
                break;
            }
        }
        return output;
    }

    public final String asColoredMessageString(IMessage message, Keyed... placeholders) {
        return SimpleColor.apply(asMessageString(message, placeholders));
    }

    public final IMessage registerMessage(String id, String fallback) throws IllegalArgumentException {
        return registerMessage(IMessage.DEFAULT_LANGUAGE, id, fallback);
    }

    public abstract IMessageProvider getMessageHandler(String id);

    public final IMessage registerMessage(String language, String id, String fallback) throws IllegalArgumentException {
        IMessage message = registerMessageInternal(language, id, fallback);
        api.callEvent(new AsyncJumpLeagueMessageRegisterEvent(this, message));
        return message;
    }

    protected abstract IMessage registerMessageInternal(String language, String id, String fallback) throws IllegalArgumentException;

    public abstract List<IMessage> getMessages(String language);

    public final IMessage getMessage(AnimalTamer target, String id) {
        return getMessage(target.getUniqueId(), id);
    }

    public final IMessage getMessage(InetAddress target, String id) {
        return getMessage(languageHandler.getLanguage(target), id);
    }

    public final IMessage getMessage(UUID target, String id) {
        return getMessage(languageHandler.getLanguage(target), id);
    }

    public abstract IMessage getMessage(String language, String id);

    public final IMessage getMessageExact(InetAddress target, String id) {
        return getMessageExact(languageHandler.getLanguage(target), id);
    }

    public final IMessage getMessageExact(AnimalTamer target, String id) {
        return getMessageExact(target.getUniqueId(), id);
    }

    public final IMessage getMessageExact(UUID target, String id) {
        return getMessageExact(languageHandler.getLanguage(target), id);
    }

    public abstract IMessage getMessageExact(String language, String id);

}

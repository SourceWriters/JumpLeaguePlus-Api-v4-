package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api;

import java.net.InetAddress;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.AnimalTamer;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event.JumpLeagueMessageRegisterEvent;
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
        String output = message.asString();
        final Placeholder[] values = Placeholder.parse(output);
        if (values.length == 0) {
            return output;
        }
        for (final Placeholder value : values) {
            if (value.isMessage()) {
                final IMessage target = getMessage(message.language(), value.getId());
                if (target == null) {
                    continue;
                }
                output = value.replace(output, message.asMessageString(placeholders));
                continue;
            }
            for (final Keyed placeholder : placeholders) {
                if (!value.getId().equals(placeholder.getKey())) {
                    continue;
                }
                output = value.replace(output, placeholder.getValueOrDefault("null").toString());
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
        api.callEvent(new JumpLeagueMessageRegisterEvent(this, message));
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

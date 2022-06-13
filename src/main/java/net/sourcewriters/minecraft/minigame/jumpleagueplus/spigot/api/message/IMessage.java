package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.message;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public interface IMessage {

    static final String DEFAULT_LANGUAGE = "default";

    String id();

    String language();

    String fallback();

    String translation();

    IMessage translation(String translation);

    String asMessageString(Keyed... placeholders);

    default Placeholder[] getPlaceholders() {
        return Placeholder.parse(asString());
    }

    default String asColoredMessageString(Keyed... placeholders) {
        return SimpleColor.apply(asMessageString(placeholders));
    }

    default String asString() {
        String translation = translation();
        if (translation == null) {
            return fallback();
        }
        return translation;
    }

    static IMessage empty(String id) {
        return empty(DEFAULT_LANGUAGE, id);
    }

    static IMessage empty(String language, String id) {
        return new EmptyMessage(language, id);
    }

    default void send(CommandSender sender, Keyed... placeholders) {
        String message = asColoredMessageString(placeholders);
        if (message.contains("\n")) {
            sender.sendMessage(message.split("\n"));
            return;
        }
        sender.sendMessage(message);
    }

    default void broadcast(Keyed... placeholders) {
        Bukkit.broadcastMessage(asColoredMessageString(placeholders));
    }

}

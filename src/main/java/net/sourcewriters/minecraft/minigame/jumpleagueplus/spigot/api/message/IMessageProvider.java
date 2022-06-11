package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.message;

import java.net.InetAddress;
import java.util.Collection;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

public interface IMessageProvider {

    String getId();

    IMessage getFor(UUID target);

    IMessage getFor(InetAddress target);

    IMessage getFor(String language);

    default String getMessageFor(CommandSender target, Keyed... placeholders) {
        if (target instanceof HumanEntity) {
            return getMessageFor((HumanEntity) target, placeholders);
        }
        return getMessageFor(IMessage.DEFAULT_LANGUAGE, placeholders);
    }

    default String getMessageFor(HumanEntity target, Keyed... placeholders) {
        return getMessageFor(target.getUniqueId(), placeholders);
    }

    default String getMessageFor(InetAddress target, Keyed... placeholders) {
        return getFor(target).asColoredMessageString(placeholders);
    }

    default String getMessageFor(UUID target, Keyed... placeholders) {
        return getFor(target).asColoredMessageString(placeholders);
    }

    default String getMessageFor(String language, Keyed... placeholders) {
        return getFor(language).asColoredMessageString(placeholders);
    }

    default void sendConsole(Keyed... placeholders) {
        send(Bukkit.getConsoleSender(), placeholders);
    }

    default void send(CommandSender sender, Keyed... placeholders) {
        if (sender instanceof HumanEntity) {
            send((HumanEntity) sender, placeholders);
            return;
        }
        getFor(IMessage.DEFAULT_LANGUAGE).send(sender, placeholders);
    }

    default void send(Player player, Keyed... placeholders) {
        getFor(player.getUniqueId()).send(player, placeholders);
    }

    default void send(OfflinePlayer player, Keyed... placeholders) {
        if (!player.isOnline()) {
            return;
        }
        getFor(player.getUniqueId()).send(player.getPlayer(), placeholders);
    }

    default void send(HumanEntity entity, Keyed... placeholders) {
        getFor(entity.getUniqueId()).send(entity, placeholders);
    }

    default void broadcast(Keyed... placeholders) {
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        for (Player player : players) {
            send(player, placeholders);
        }
        send(Bukkit.getConsoleSender());
    }

    default void broadcast(World world, Keyed... placeholders) {
        Collection<? extends Player> players = world.getPlayers();
        for (Player player : players) {
            send(player, placeholders);
        }
    }

}

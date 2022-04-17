package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api;

import org.bukkit.plugin.Plugin;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.LootTable;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.provided.IProvidedLootIO;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.util.PluginKey;

public interface ILootManager {

    boolean register(LootTable lootTable);

    LootTable get(PluginKey key);

    LootTable get(String pluginKey);

    LootTable[] getAll(Plugin plugin);

    void unregisterAll(Plugin plugin);

    IProvidedLootIO getProvidedLootIO();

}

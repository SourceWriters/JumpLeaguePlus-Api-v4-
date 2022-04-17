package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot;

import java.util.Objects;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.random.IRandom;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.util.PluginKey;

public abstract class LootTable {

    private final PluginKey key;

    public LootTable(PluginKey key) {
        this.key = Objects.requireNonNull(key, "PluginKey can't be null!");
    }

    public final PluginKey getKey() {
        return key;
    }

    public abstract void fill(IContainer container, IRandom random);

}

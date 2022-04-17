package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.provided;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.util.PluginKey;

public interface ILootTableBuilder {

    /**
     * Sets the chance to choose a loot pool or drop nothing
     * 
     * @param  chance between 0 and 1
     * 
     * @return        the loot table builder itself
     */
    ILootTableBuilder dropChance(double chance);

    /**
     * Create a new loot pool for this table
     * 
     * @return the builder for the new pool
     */
    ILootPoolBuilder newPool();

    /**
     * Build and register the loot table
     * 
     * @param  key the unique {@code PluginKey} of the table
     * 
     * @return     if the loot table was registered or not
     */
    boolean register(PluginKey key);

}

package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.provided;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.util.PluginKey;

public interface ILootTableBuilder {

    /**
     * Sets the minimum amount of items that should be generated
     * 
     * @param  minimum                  the amount of different items
     * 
     * @return                          the loot table builder itself
     * 
     * @throws IllegalArgumentException If minimum is lower than 0
     */
    ILootTableBuilder minimum(int minimum) throws IllegalArgumentException;

    /**
     * Sets the maximum amount of items that should be generated
     * 
     * If the maximum amount is lower than the minimum then it will be set to the
     * minimum amount of items
     * 
     * @param  maximum the amount of different items
     * 
     * @return         the loot table builder itself
     */
    ILootTableBuilder maximum(int maximum);

    /**
     * Sets the chance to choose a loot pool or drop nothing
     * 
     * @param  chance                   between 0 and 1
     * 
     * @return                          the loot table builder itself
     * 
     * @throws IllegalArgumentException If the chance is lower than or equal to 0 or
     *                                      higher than or equal to 1
     */
    ILootTableBuilder dropChance(double chance) throws IllegalArgumentException;

    /**
     * Create a new loot pool for this table
     * 
     * @param  chance number between 0 and 1 which determines how rare the pool is
     * 
     * @return        the builder for the new pool
     * 
     * @throws IllegalArgumentException If the chance is lower than or equal to 0 or
     *                                      higher than or equal to 1
     */
    ILootPoolBuilder newPool(double chance);

    /**
     * Build and register the loot table
     * 
     * @param  key                   the unique {@code PluginKey} of the table
     * 
     * @return                       if the loot table was registered or not
     * 
     * @throws IllegalStateException If the minimum and maximum amount of items is
     *                                   zero
     */
    boolean register(PluginKey key) throws IllegalStateException;

}

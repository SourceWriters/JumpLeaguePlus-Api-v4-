package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.provided;

import org.bukkit.inventory.ItemStack;

public interface ILootPoolBuilder {

    /**
     * Adds a item to the loot pool
     * 
     * This method creates a clone of the item and sets its amount to <code>1</code>
     * 
     * @param  chance                   the chance-range that the item got to be
     *                                      chosen
     * @param  itemStack                the item
     * 
     * @return                          the loot pool builder itself
     * 
     * @throws IllegalArgumentException If the ItemStack amount is lower or equal to
     *                                      <code>0</code> or the amount is
     *                                      higher than the maximal stack size of
     *                                      the item
     */
    ILootPoolBuilder add(double chance, ItemStack itemStack);

    /**
     * Adds a item to the loot pool
     * 
     * This method creates a clone of the item and sets its amount to <code>1</code>
     * 
     * @param  chance                   the chance-range that the item got to be
     *                                      chosen
     * @param  itemStack                the item
     * @param  max                      the maximum amount of items
     * 
     * @return                          the loot pool builder itself
     * 
     * @throws IllegalArgumentException If the maximum amount is lower or equal to
     *                                      <code>0</code> or the maximum amount is
     *                                      higher than the maximal stack size of
     *                                      the item
     */
    ILootPoolBuilder add(double chance, ItemStack itemStack, int amount) throws IllegalArgumentException;

    /**
     * Adds a item to the loot pool
     * 
     * This method creates a clone of the item and sets its amount to <code>1</code>
     * 
     * @param  chance                   the chance-range that the item got to be
     *                                      chosen
     * @param  itemStack                the item
     * @param  min                      the minimum amount of items
     * @param  max                      the maximum amount of items
     * 
     * @return                          the loot pool builder itself
     * 
     * @throws IllegalArgumentException If the minimum amount is lower or equal to
     *                                      <code>0</code> or the maximum amount is
     *                                      higher than the maximal stack size of
     *                                      the item or if the maximum amount is
     *                                      lower as the minimum amount
     */
    ILootPoolBuilder add(double chance, ItemStack itemStack, int min, int max) throws IllegalArgumentException;

    /**
     * Build and add the loot pool to the loot table builder
     * 
     * @return the loot table builder which created this loot pool builder
     */
    ILootTableBuilder build();

}

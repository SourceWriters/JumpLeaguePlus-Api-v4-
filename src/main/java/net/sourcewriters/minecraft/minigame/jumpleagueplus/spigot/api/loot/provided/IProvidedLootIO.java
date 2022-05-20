package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.provided;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.LootTable;

public interface IProvidedLootIO {

    /**
     * Creates a new loot table builder
     * 
     * @return the loot table builder
     */
    ILootTableBuilder newBuilder();

    /**
     * Saves a loot table to a file
     * 
     * @param  file                     the file to be saved to
     * @param  table                    the loot table to be saved
     * 
     * @throws IllegalArgumentException If the loot table has a not supported type
     * @throws IOException              If there was an error while saving the loot
     *                                      table
     */
    void saveToFile(File file, LootTable table) throws IllegalStateException, IllegalArgumentException, IOException;

    /**
     * Loads a loot table from a file
     * 
     * @param  file                  the file to be loaded from
     * 
     * @return                       the loaded loot table as loot table builder
     * 
     * @throws FileNotFoundException If the file doesn't exist
     * @throws IOException           If something went wrong while loading the loot
     *                                   table
     */
    ILootTableBuilder loadFromFile(File file) throws IllegalStateException, FileNotFoundException, IOException;

}

package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot;

import org.bukkit.inventory.ItemStack;

public interface IContainer {
    
    int size();
    
    int free();
    
    boolean accept(ItemStack itemStack) throws IllegalArgumentException;

}

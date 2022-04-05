package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.order;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourModule;

public interface IParkourModuleCollection {
    
    int amount();
    
    IParkourModule moduleAt(int position);
    
    void move(int fromPosition, int toPosition);

}

package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api;

import java.util.List;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.ChunkPosition;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.Position;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourDifficulty;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourModule;

public interface IParkourManager {
    
    List<IParkourDifficulty> getDifficulties();
    
    List<IParkourModule> getGameModules();
    
    IParkourDifficulty getDifficulty(String id);
    
    int getGameModuleId(IParkourModule module);
    
    IParkourModule getGameModule(int moduleId);
    
    ChunkPosition getGameModuleStart(ChunkPosition position, int moduleId);
    
    Position[] getStartPositions();
    
    int getGameModuleIdFor(ChunkPosition position);
    
    int getGameModuleAmount();
    
    int getGameModuleMinimumAmount();
    
    int getGameModuleMaximumAmount();

}

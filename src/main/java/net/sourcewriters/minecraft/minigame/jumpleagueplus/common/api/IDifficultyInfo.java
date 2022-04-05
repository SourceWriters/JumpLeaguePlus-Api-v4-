package net.sourcewriters.minecraft.minigame.jumpleagueplus.common.api;

import java.util.List;

public interface IDifficultyInfo {
    
    int getScore();
    
    int getPoints();
    
    String getId();
    
    String getName();
    
    List<IModuleInfo> getModules();
    
    int getModuleAmount();

}

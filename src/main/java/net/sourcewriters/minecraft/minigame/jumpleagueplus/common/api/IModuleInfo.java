package net.sourcewriters.minecraft.minigame.jumpleagueplus.common.api;

import java.util.List;
import java.util.UUID;

public interface IModuleInfo {
    
    IDifficultyInfo getDifficulty();
    
    String getName();
    
    String getBiome();

    int getWidth();
    
    default int getChunkWidth() {
        return getWidth() * 2;
    }

    int getLength();
    
    default int getChunkLength() {
        return getLength() * 2;
    }

    int getBlockAmount();

    int getChestAmount();

    List<UUID> getBuilders();

    String getBuilderTeam();

}

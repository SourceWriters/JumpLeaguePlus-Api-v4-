package net.sourcewriters.minecraft.minigame.jumpleagueplus.common.api;

import java.util.List;
import java.util.UUID;

public interface IGameInfo {

    List<IDifficultyInfo> getDifficulties();

    int getDifficultyAmount();

    List<IModuleInfo> getModules();

    int getModuleAmount();

    int getPlayerMinimum();

    int getPlayerAmount();

    int getPlayerMaximum();

    int getSpectatorAmount();

    JumpGamePhase getPhase();
    
    String getMapName();

    int getTime();

    List<UUID> getPlayerAlive();

}

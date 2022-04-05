package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.order;

import java.util.List;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourDifficulty;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourModule;

public interface IParkourDifficultyCollection {

    int moduleAmount();

    int difficultyAmount();

    void move(int fromPosition, int toPosition);

    IParkourDifficulty difficultyAt(int poisition);

    IParkourModuleCollection modulesOf(IParkourDifficulty difficulty);
    
    List<IParkourModule> toImmutableList();

}

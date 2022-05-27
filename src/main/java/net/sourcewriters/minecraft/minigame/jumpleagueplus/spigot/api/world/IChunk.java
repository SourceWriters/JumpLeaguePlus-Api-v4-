package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.world;

import org.bukkit.generator.ChunkGenerator.ChunkData;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.ChunkPosition;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourDifficulty;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourModule;

public interface IChunk {
    
    IJumpLeaguePlusSpigotApi getApi();
    
    IParkourDifficulty getDifficulty();
    
    IParkourModule getModule();

    ChunkData getChunkData();
    
    ChunkPosition getPosition();

    ChunkTask task(IChunkPopulator populator);

    boolean isGenerated();
    
    boolean isLast();

}

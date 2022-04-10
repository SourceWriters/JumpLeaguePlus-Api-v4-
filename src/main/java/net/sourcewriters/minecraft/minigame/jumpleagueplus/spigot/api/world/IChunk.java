package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.world;

import org.bukkit.generator.ChunkGenerator.ChunkData;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.ChunkPosition;

public interface IChunk {

    ChunkData getChunkData();
    
    ChunkPosition getPosition();

    ChunkTask task(IChunkPopulator populator);

    boolean isGenerated();
    
    boolean isLast();

}

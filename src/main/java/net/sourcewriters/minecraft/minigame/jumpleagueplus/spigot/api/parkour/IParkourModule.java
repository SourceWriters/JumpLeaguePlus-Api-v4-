package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour;

import java.util.Collection;
import java.util.UUID;

import org.bukkit.World;
import org.bukkit.block.Biome;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.ChunkPosition;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.Position;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.world.IChunk;

public interface IParkourModule {

    String getName();

    Biome getBiome();

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

    void paste(IChunk data, int worldHeightMin, int worldHeightMax, ChunkPosition offset);

    void paste(World world, int x, int y, int z);

    IParkourBlock getBlock(int x, int y, int z);

    IParkourBlock getBlock(Position position);

    Position[] getChestLocations();

    Position getStartLocation();

    String getDifficultyId();

    Collection<UUID> getBuilders();

    String getBuilderTeam();

}

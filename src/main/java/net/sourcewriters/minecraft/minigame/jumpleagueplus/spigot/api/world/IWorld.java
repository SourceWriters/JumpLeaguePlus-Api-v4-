package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.world;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.block.Biome;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Consumer;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.ChunkPosition;

public interface IWorld {
    
    IJumpLeaguePlusSpigotApi getApi();

    Object getGenerationSource();
    
    ChunkPosition getPosition();
    
    String getName();

    UUID getId();
    
    long getSeed();
    
    int getMinHeight();

    int getMaxHeight();

    default boolean isInRegion(Location location) {
        return isInRegion(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    boolean isInRegion(int x, int y, int z);

    int getBiomeLayerStartHeight();

    int getBiomeLayerAmount();

    default void setBiomeLayers(int x, int z, Biome biome) {
        int height = getBiomeLayerAmount();
        int start = getBiomeLayerStartHeight();
        for (int index = 0; index < height; index++) {
            setBiome(x, start + (index << 2), z, biome);
        }
    }

    default void setBiome(Location location, Biome biome) {
        setBiome(location.getBlockX(), location.getBlockY(), location.getBlockZ(), biome);
    }

    void setBiome(int x, int y, int z, Biome biome);

    default Biome[] getBiomeLayers(int x, int z) {
        Biome[] biomes = new Biome[getBiomeLayerAmount()];
        int start = getBiomeLayerStartHeight();
        for (int index = 0; index < biomes.length; index++) {
            biomes[index] = getBiome(x, start + (index << 2), z);
        }
        return biomes;
    }

    default Biome getBiome(Location location) {
        return getBiome(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    Biome getBiome(int x, int y, int z);

    default BlockState getState(Location location) {
        return getState(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    BlockState getState(int x, int y, int z);

    boolean generateTree(Location location, Random random, TreeType type);

    Entity spawnEntity(Location location, EntityType type);

    Entity spawnEntity(Location location, EntityType type, boolean randomizeData);

    List<Entity> getEntities();

    List<BlockState> getTileEntities();

    List<LivingEntity> getLivingEntities();

    <T extends Entity> Collection<T> getEntitiesByClass(Class<T> cls);

    Collection<Entity> getEntitiesByClasses(Class<?>... classes);

    <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException;

    <T extends Entity> T spawn(Location location, Class<T> clazz, Consumer<T> function) throws IllegalArgumentException;

    <T extends Entity> T spawn(Location location, Class<T> clazz, boolean randomizeData, Consumer<T> function)
        throws IllegalArgumentException;

}

package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.world;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.ChunkPosition;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.random.ISeededRandom;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourDifficulty;

@FunctionalInterface
public interface IChunkPopulator {

    void populate(IJumpLeaguePlusSpigotApi api, IParkourDifficulty difficulty, IWorld world, ChunkPosition position, ISeededRandom random);

}

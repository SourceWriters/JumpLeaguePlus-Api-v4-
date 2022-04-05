package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.world;

import java.util.Random;

@FunctionalInterface
public interface IChunkPopulator {

    void populate(Random random, IWorld world);

}

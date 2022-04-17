package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.random;

public final class StaticRandom implements IRandom {

    public static final StaticRandom INSTANCE = new StaticRandom();

    private StaticRandom() {}

    @Override
    public double nextDouble() {
        return Math.random();
    }

}

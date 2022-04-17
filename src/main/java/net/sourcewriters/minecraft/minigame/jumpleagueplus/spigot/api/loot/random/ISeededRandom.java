package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.random;

public interface ISeededRandom extends IRandom {

    long seed();

    ISeededRandom seed(long seed);

    default long state() {
        return seed();
    }

    default ISeededRandom state(long state) {
        return seed(state);
    }

}

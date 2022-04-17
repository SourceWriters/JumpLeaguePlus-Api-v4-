package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.loot.random;

import java.util.Objects;
import java.util.Random;

public final class JavaRandom implements IRandom {

    private final Random random;

    public JavaRandom(final Random random) {
        this.random = Objects.requireNonNull(random);
    }

    @Override
    public double nextDouble() {
        return random.nextDouble();
    }

}

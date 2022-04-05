package net.sourcewriters.minecraft.minigame.jumpleagueplus.bungee.api;

import java.util.concurrent.Future;

public interface INetFuture<V> extends Future<V> {

    default void cancel() {
        cancel(false);
    }

    String getTag();

}

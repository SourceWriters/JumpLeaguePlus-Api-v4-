package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.message;

import java.util.function.Supplier;

public final class Keyed {

    private final String key;
    private final Object value;

    private Keyed(final String key, final Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Object getValueOrDefault(final Object fallback) {
        if (value == null) {
            return fallback;
        }
        return value;
    }

    public Object getValueOrThrow(final Supplier<Throwable> supplier) throws Throwable {
        if (value == null) {
            throw supplier.get();
        }
        return value;
    }

    public static Keyed of(final String key, final Object value) {
        return new Keyed(key, value);
    }

}

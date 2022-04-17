package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.util;

import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.plugin.Plugin;

public final class PluginContainer {

    private static final ConcurrentHashMap<String, PluginContainer> CONTAINERS = new ConcurrentHashMap<>();

    public static PluginContainer get(Plugin plugin) {
        return CONTAINERS.computeIfAbsent(plugin.getName(), (i) -> new PluginContainer(plugin));
    }

    public static Optional<PluginContainer> get(String id) {
        return Optional.ofNullable(CONTAINERS.get(id));
    }

    private final String id;

    private WeakReference<Plugin> pluginRef;

    private PluginContainer(Plugin plugin) {
        this.id = Objects.requireNonNull(plugin, "plugin can't be null").getName();
        this.pluginRef = new WeakReference<>(plugin);
    }

    public void setPlugin(Plugin plugin) {
        if (plugin == null || plugin.getName().equals(id)) {
            return;
        }
        pluginRef = new WeakReference<>(plugin);
    }

    public Optional<Plugin> getPlugin() {
        return Optional.ofNullable(pluginRef.get());
    }

    public Plugin getPluginOrNull() {
        return pluginRef.get();
    }

    public String getId() {
        return id;
    }

}

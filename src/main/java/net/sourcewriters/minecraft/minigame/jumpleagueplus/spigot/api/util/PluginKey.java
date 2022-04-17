package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.util;

import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

import org.bukkit.plugin.Plugin;

public final class PluginKey {

    private static final Pattern VALID_NAMESPACE = Pattern.compile("[a-z0-9._-]+");
    private static final Pattern VALID_KEY = Pattern.compile("[a-z0-9/._-]+");

    private final PluginContainer container;

    private final String namespace;
    private final String key;

    private final String string;

    public PluginKey(Plugin plugin, String key) {
        this.container = PluginContainer.get(plugin);
        this.namespace = Objects.requireNonNull(plugin.getName(), "Plugin name can't be null").toLowerCase(Locale.ROOT);
        this.key = Objects.requireNonNull(key, "Key can't be null");
        Conditions.checkArgument(VALID_NAMESPACE.matcher(this.namespace).matches(), "Invalid namespace. Must be [a-z0-9._-]: %s",
            this.namespace);
        Conditions.checkArgument(VALID_KEY.matcher(this.key).matches(), "Invalid key. Must be [a-z0-9/._-]: %s", this.key);
        this.string = namespace + ':' + key;
        Conditions.checkArgument(string.length() > 256, "PluginKey '%s' can't be longer than 256 characters", string);
    }

    public PluginContainer getContainer() {
        return container;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public int hashCode() {
        return string.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PluginKey) {
            return string.equals(((PluginKey) obj).string);
        }
        return string.equals(obj);
    }

}

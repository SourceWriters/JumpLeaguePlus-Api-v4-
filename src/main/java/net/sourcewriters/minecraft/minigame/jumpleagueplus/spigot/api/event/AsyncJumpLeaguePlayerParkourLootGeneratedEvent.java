package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import java.util.List;
import java.util.Objects;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourModule;

public class AsyncJumpLeaguePlayerParkourLootGeneratedEvent extends JumpLeaguePlayerParkourEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Location location;
    private final List<ItemStack> items;

    public AsyncJumpLeaguePlayerParkourLootGeneratedEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull Player player, @NonNull IParkourModule module, @NonNull int moduleId,
        @NonNull Location location, @NonNull List<ItemStack> items) {
        super(api, player, module, moduleId, true);
        this.location = Objects.requireNonNull(location);
        this.items = Objects.requireNonNull(items);
    }

    @NonNull
    public Location getLocation() {
        return location;
    }

    @NonNull
    public List<ItemStack> getItems() {
        return items;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

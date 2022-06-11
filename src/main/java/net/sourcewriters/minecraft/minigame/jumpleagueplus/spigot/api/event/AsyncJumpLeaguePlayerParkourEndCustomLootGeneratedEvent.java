package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import java.util.List;
import java.util.Objects;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourModule;

public class AsyncJumpLeaguePlayerParkourEndCustomLootGeneratedEvent extends JumpLeaguePlayerParkourEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final List<ItemStack> items;

    public AsyncJumpLeaguePlayerParkourEndCustomLootGeneratedEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull Player player,
        @NonNull IParkourModule module, @NonNull int moduleId, @NonNull List<ItemStack> items) {
        super(api, player, module, moduleId, true);
        this.items = Objects.requireNonNull(items);
    }

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

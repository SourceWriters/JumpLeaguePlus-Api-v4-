package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.event;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.IJumpLeaguePlusSpigotApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourDifficulty;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourModule;

public class JumpLeagueParkourChoosenEvent extends JumpLeagueEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Set<IParkourModule> modules;
    private final int minimumModuleAmount;
    private final int maximumModuleAmount;

    public JumpLeagueParkourChoosenEvent(@NonNull IJumpLeaguePlusSpigotApi api, @NonNull int minimumModuleAmount,
        @NonNull int maximumModuleAmount, @NonNull Set<IParkourModule> modules) {
        super(api, false);
        this.minimumModuleAmount = Objects.requireNonNull(minimumModuleAmount);
        this.maximumModuleAmount = Objects.requireNonNull(maximumModuleAmount);
        this.modules = Objects.requireNonNull(modules);
    }

    @NonNull
    public int getMinimumModuleAmount() {
        return minimumModuleAmount;
    }

    @NonNull
    public int getMaximumModuleAmount() {
        return maximumModuleAmount;
    }

    @NonNull
    public Set<IParkourModule> getModules() {
        return modules;
    }

    @NonNull
    public Set<IParkourModule> getModulesOfDifficulty(IParkourDifficulty difficulty) {
        if (difficulty == null) {
            return Collections.emptySet();
        }
        return getModulesOfDifficulty(difficulty.getId());
    }

    @NonNull
    public Set<IParkourModule> getModulesOfDifficulty(String difficultyId) {
        return modules.stream().filter(module -> module.getDifficultyId().equals(difficultyId)).collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}

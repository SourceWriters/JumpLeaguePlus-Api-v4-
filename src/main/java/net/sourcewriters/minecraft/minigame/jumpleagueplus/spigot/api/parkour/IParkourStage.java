package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour;

import java.util.Collection;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.AreaBox;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.ChunkPosition;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.Position;

public interface IParkourStage {

    String getName();

    UUID getCreator();

    Collection<UUID> getContributors();

    boolean isContributor(UUID uniqueId);

    Collection<UUID> getBanned();

    void setBanned(UUID uniqueId, boolean banned);

    boolean isBanned(UUID uniqueId);

    AreaBox getArea();

    default boolean isInStage(Location location) {
        if (!getWorld().getUID().equals(location.getWorld().getUID())) {
            return false;
        }
        return getArea().inside(Position.ofLocation(location));
    }

    default boolean isInStage(World world, ChunkPosition chunk) {
        if (!getWorld().getUID().equals(world.getUID())) {
            return false;
        }
        return getArea().intersects(chunk);
    }

    default boolean intersects(IParkourStage stage) {
        return getArea().intersects(stage.getArea());
    }

    World getWorld();

    Biome getBiome();

    void setBiome(Biome biome);

    int getWidth();

    boolean setWidth(int width);

    int getLength();

    boolean setLength(int length);

    boolean setDimension(int width, int length);

    String getTeam();

    void setTeam(String name);

    boolean enter(Player player);

    boolean exit(Player player);

    default EnterState getEnterState(Player player) {
        if (isContributor(player.getUniqueId())) {
            return EnterState.ALLOWED;
        }
        if (isBanned(player.getUniqueId())) {
            return EnterState.BANNED;
        }
        return EnterState.DENIED;
    }

    IParkourModule create(IParkourDifficulty difficulty);

    static enum EnterState {

        ALLOWED,
        DENIED,
        BANNED;

        public boolean canEnter() {
            return this == ALLOWED;
        }

    }

}

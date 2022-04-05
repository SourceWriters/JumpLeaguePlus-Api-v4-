package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour;

import java.util.Collection;
import java.util.UUID;

import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.Position;

public interface IParkourStage {

    UUID getCreator();

    Collection<UUID> getContributors();

    Position getLowerCorner();

    Position getUpperCorner();

    Biome getBiome();

    void setBiome(Biome biome);

    int getWidth();

    void setWidth(int width);

    int getLength();

    void setLength(int length);

    String getTeam();

    void setTeam(String name);

    void enter(Player player);

    IParkourModule create();

}

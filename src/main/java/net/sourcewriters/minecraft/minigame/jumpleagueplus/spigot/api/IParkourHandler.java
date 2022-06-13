package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api;

import java.io.File;
import java.util.Collection;
import java.util.UUID;

import org.bukkit.Location;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.exception.IncompatibleDataException;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourModule;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour.IParkourStage;

public interface IParkourHandler {
    
    IBlockIO getBlockIO();
    
    void loadStages();
    
    void saveStages();

    Collection<IParkourModule> getModules();

    IParkourModule getModule(String name);
    
    File getSource(IParkourModule module);
    
    IParkourModule load(File file) throws IncompatibleDataException;
    
    boolean save(IParkourModule module);
    
    IParkourStage getStage(Location location);
    
    IParkourStage getStage(String name);
    
    boolean deleteStage(String name);
    
    IParkourStage createStage(String name, UUID creator, Location location, int initialWidth, int initialHeight);

}

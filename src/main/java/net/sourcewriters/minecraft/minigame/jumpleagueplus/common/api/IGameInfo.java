package net.sourcewriters.minecraft.minigame.jumpleagueplus.common.api;

import java.util.List;
import java.util.UUID;

public interface IGameInfo {

    /**
     * Gets the difficulty info list that contains the whole info about all
     * difficulties which are used in this game
     * 
     * @return the difficulty info list
     */
    List<IDifficultyInfo> getDifficulties();

    /**
     * Gets the amount of difficulties that are used in this game
     * 
     * @return the amount of difficulties
     */
    int getDifficultyAmount();

    /**
     * Gets the module info list that contains the whole info about all modules
     * which are used in this game
     * 
     * @return
     */
    List<IModuleInfo> getModules();

    /**
     * Gets the amount of modules that are used in this game
     * 
     * @return the amount of modules
     */
    int getModuleAmount();

    /**
     * Gets the minimum amount of players that are required for this game to start
     * 
     * @return the minimum amount of players
     */
    int getPlayerMinimum();

    /**
     * Gets the current amount of players that joined this game
     * 
     * @return the current amount of players
     */
    int getPlayerAmount();

    /**
     * Gets the maximum amount of players that can join this game
     * 
     * @return the maximum amount of players
     */
    int getPlayerMaximum();

    /**
     * Gets the amount of players that are currently spectating this game
     * 
     * @return the amount of spectators
     */
    int getSpectatorAmount();

    /**
     * Gets the current phase of this game
     * 
     * @return the current phase
     */
    JumpGamePhase getPhase();

    /**
     * Gets the arena map name of this game
     * 
     * @return the arena map name
     */
    String getMapName();

    /**
     * Gets the time until the next phase of this game starts
     * 
     * @return the time
     */
    int getTime();

    /**
     * The UUID list which contains the UUID of all alive players of this game
     * 
     * @return the UUID list
     */
    List<UUID> getPlayerAlive();

}

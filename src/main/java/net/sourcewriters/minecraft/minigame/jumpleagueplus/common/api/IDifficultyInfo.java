package net.sourcewriters.minecraft.minigame.jumpleagueplus.common.api;

import java.util.List;

public interface IDifficultyInfo {

    /**
     * Gets the difficulty score of this difficulty
     * 
     * @return the difficulty score
     */
    int getScore();

    /**
     * Gets the points that are awarded if a player finishes a module with this
     * difficulty
     * 
     * @return the points
     */
    int getPoints();

    /**
     * Gets the id of this difficulty
     * 
     * @return the id
     */
    String getId();

    /**
     * Gets the name of this difficulty
     * 
     * @return the name
     */
    String getName();

    /**
     * Gets the modules which are ranked with this difficulty
     * 
     * @return the modules
     */
    List<IModuleInfo> getModules();

    /**
     * Gets the amount of modules which are ranked with this difficulty
     * 
     * @return the amount of modules
     */
    int getModuleAmount();

}

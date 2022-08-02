package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.world;

import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.AreaBox;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data.Position;

public interface IOffset {

    AreaBox getGenerationBox(IChunk chunk, int worldHeightMin, int worldHeightMax);
    
    Position getOrigin();

}

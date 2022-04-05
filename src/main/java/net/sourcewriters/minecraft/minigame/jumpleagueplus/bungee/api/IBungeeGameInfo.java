package net.sourcewriters.minecraft.minigame.jumpleagueplus.bungee.api;

import net.md_5.bungee.api.config.ServerInfo;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.common.api.IGameInfo;

public interface IBungeeGameInfo extends IGameInfo {

    ServerInfo getServer();

}

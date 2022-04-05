package net.sourcewriters.minecraft.minigame.jumpleagueplus.bungee.api;

import java.util.concurrent.CompletableFuture;

import net.md_5.bungee.api.config.ServerInfo;

public interface IJumpLeaguePlusBungeeApi {

    INetFuture<Boolean> isJumpLeagueServer(ServerInfo server);

    INetFuture<IBungeeGameInfo> getGameInfo(ServerInfo server);

    CompletableFuture<IBungeeGameInfo[]> getKnownServers();

}

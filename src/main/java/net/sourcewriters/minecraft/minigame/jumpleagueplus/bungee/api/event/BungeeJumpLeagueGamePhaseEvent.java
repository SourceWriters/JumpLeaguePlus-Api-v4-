package net.sourcewriters.minecraft.minigame.jumpleagueplus.bungee.api.event;

import net.md_5.bungee.api.config.ServerInfo;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.bungee.api.IJumpLeaguePlusBungeeApi;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.common.api.JumpGamePhase;

public final class BungeeJumpLeagueGamePhaseEvent extends BungeeJumpLeagueEvent {
    
    protected final ServerInfo serverInfo;
    protected final JumpGamePhase phase;

    public BungeeJumpLeagueGamePhaseEvent(final IJumpLeaguePlusBungeeApi api, final ServerInfo serverInfo, final JumpGamePhase phase) {
        super(api);
        this.serverInfo = serverInfo;
        this.phase = phase;
    }
    
    public ServerInfo getServerInfo() {
        return serverInfo;
    }
    
    public JumpGamePhase getPhase() {
        return phase;
    }

}

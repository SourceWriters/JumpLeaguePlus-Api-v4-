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

    /**
     * Gets the server info of the server that the phase was updated at
     * 
     * @return the server info
     */
    public ServerInfo getServerInfo() {
        return serverInfo;
    }

    /**
     * Gets the phase that the server updated to
     * 
     * @return the phase
     */
    public JumpGamePhase getPhase() {
        return phase;
    }

}

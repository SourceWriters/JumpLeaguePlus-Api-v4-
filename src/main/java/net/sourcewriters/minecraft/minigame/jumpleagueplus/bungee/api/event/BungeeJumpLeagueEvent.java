package net.sourcewriters.minecraft.minigame.jumpleagueplus.bungee.api.event;

import net.md_5.bungee.api.plugin.Event;
import net.sourcewriters.minecraft.minigame.jumpleagueplus.bungee.api.IJumpLeaguePlusBungeeApi;

public abstract class BungeeJumpLeagueEvent extends Event {

    protected final IJumpLeaguePlusBungeeApi api;

    public BungeeJumpLeagueEvent(final IJumpLeaguePlusBungeeApi api) {
        this.api = api;
    }

    public final IJumpLeaguePlusBungeeApi getApi() {
        return api;
    }

}

package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data;

import java.util.Objects;
import java.util.UUID;

public final class RoundStats {

    private final UUID owner;

    private int points;

    private int kills;
    private int deaths;
    private double damageTaken;
    private double damageDealt;
    private boolean wonDeathmatch;

    private int fails;
    private int chests;
    private int checkpoints;
    private double distanceReached;
    private boolean wonParkour;

    private boolean disqualified;

    public RoundStats(UUID owner) {
        this.owner = Objects.requireNonNull(owner);
    }

    public UUID getOwner() {
        return owner;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getKills() {
        return kills;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDamageTaken(double damageTaken) {
        this.damageTaken = damageTaken;
    }

    public double getDamageTaken() {
        return damageTaken;
    }

    public void setDamageDealt(double damageDealt) {
        this.damageDealt = damageDealt;
    }

    public double getDamageDealt() {
        return damageDealt;
    }

    public void setWonDeathmatch(boolean wonDeathmatch) {
        this.wonDeathmatch = wonDeathmatch;
    }

    public boolean hasWonDeathmatch() {
        return wonDeathmatch;
    }

    public int hasWonDeathmatchAsInt() {
        if (wonDeathmatch) {
            return 1;
        }
        return 0;
    }

    public void setFails(int fails) {
        this.fails = fails;
    }

    public int getFails() {
        return fails;
    }

    public void setChests(int chests) {
        this.chests = chests;
    }

    public int getChests() {
        return chests;
    }

    public void setCheckpoints(int checkpoints) {
        this.checkpoints = checkpoints;
    }

    public int getCheckpoints() {
        return checkpoints;
    }

    public void setDistanceReached(double distanceReached) {
        this.distanceReached = distanceReached;
    }

    public double getDistanceReached() {
        return distanceReached;
    }

    public void setDisqualified(boolean disqualified) {
        this.disqualified = disqualified;
    }

    public boolean isDisqualified() {
        return disqualified;
    }
    
    public int isDisqualifiedAsInt() {
        if (disqualified) {
            return 1;
        }
        return 0;
    }

    public void setWonParkour(boolean wonParkour) {
        this.wonParkour = wonParkour;
    }

    public boolean hasWonParkour() {
        return wonParkour;
    }

    public int hasWonParkourAsInt() {
        if (wonParkour) {
            return 1;
        }
        return 0;
    }

}

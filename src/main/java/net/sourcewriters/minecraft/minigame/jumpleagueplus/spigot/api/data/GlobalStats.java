package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.UUID;

public final class GlobalStats {

    private final UUID owner;

    private final BigInteger points;

    private final long gamesPlayed;
    private final long gamesWon;
    private final long gamesLost;
    private final double gamesWonLostRatio;
    private final long gamesParkourWon;
    private final long gamesParkourLost;
    private final double gamesParkourWonLostRatio;

    private final long kills;
    private final long deaths;
    private final double killDeathRatio;

    private final BigDecimal damageTaken;
    private final BigDecimal damageDealt;
    private final double damageTakenDealthRatio;

    private final long checkpointsReached;
    private final long chestsLooted;
    private final long parkourFails;

    private final BigDecimal distanceReached;
    private final double averageDistanceReached;

    public GlobalStats(UUID owner) {
        this(owner, BigInteger.ZERO, 0, 0, 0, 0, 0, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, 0, 0, 0);
    }

    public GlobalStats(UUID owner, BigInteger points, long gamesPlayed, long gamesWon, long gamesParkourWon, long kills, long deaths,
        BigDecimal damageTaken, BigDecimal damageDealt, BigDecimal distanceReached, long checkpointsReached, long chestsLooted,
        long parkourFails) {
        this.owner = Objects.requireNonNull(owner);
        this.points = points;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesPlayed - gamesWon;
        this.gamesWonLostRatio = gamesWon / Math.max(1D, gamesLost);
        this.gamesParkourWon = gamesParkourWon;
        this.gamesParkourLost = gamesPlayed - gamesParkourWon;
        this.gamesParkourWonLostRatio = gamesParkourWon / Math.max(1D, gamesParkourLost);
        this.kills = kills;
        this.deaths = deaths;
        this.killDeathRatio = kills / Math.max(1D, deaths);
        this.damageTaken = damageTaken;
        this.damageDealt = damageDealt;
        this.damageTakenDealthRatio = damageDealt.compareTo(BigDecimal.ZERO) <= 0 ? 0 : damageTaken.divide(damageDealt).doubleValue();
        this.distanceReached = distanceReached;
        this.averageDistanceReached = gamesPlayed == 0 ? 0 : distanceReached.divide(BigDecimal.valueOf(gamesPlayed)).doubleValue();
        this.checkpointsReached = checkpointsReached;
        this.chestsLooted = chestsLooted;
        this.parkourFails = parkourFails;
    }

    public GlobalStats add(RoundStats round) {
        if (!round.getOwner().equals(owner)) {
            return null;
        }
        return new GlobalStats(owner, points.add(BigInteger.valueOf(round.getPoints())), gamesPlayed + 1,
            gamesWon + round.hasWonDeathmatchAsInt(), gamesParkourWon + round.hasWonParkourAsInt(), kills + round.getKills(),
            deaths + round.getDeaths(), damageTaken.add(BigDecimal.valueOf(round.getDamageTaken())),
            damageDealt.add(BigDecimal.valueOf(round.getDamageDealt())),
            distanceReached.add(BigDecimal.valueOf(round.getDistanceReached())), checkpointsReached + round.getCheckpoints(),
            chestsLooted + round.getChests(), parkourFails + round.getFails());
    }

    /*
     * Getter
     */

    public UUID getOwner() {
        return owner;
    }

    public BigInteger getPoints() {
        return points;
    }

    public long getGamesPlayed() {
        return gamesPlayed;
    }

    public long getGamesWon() {
        return gamesWon;
    }

    public long getGamesLost() {
        return gamesLost;
    }

    public double getGamesWonLostRatio() {
        return gamesWonLostRatio;
    }

    public long getGamesParkourWon() {
        return gamesParkourWon;
    }

    public long getGamesParkourLost() {
        return gamesParkourLost;
    }

    public double getGamesParkourWonLostRatio() {
        return gamesParkourWonLostRatio;
    }

    public long getKills() {
        return kills;
    }

    public long getDeaths() {
        return deaths;
    }

    public double getKillDeathRatio() {
        return killDeathRatio;
    }

    public BigDecimal getDamageTaken() {
        return damageTaken;
    }

    public BigDecimal getDamageDealt() {
        return damageDealt;
    }

    public double getDamageTakenDealthRatio() {
        return damageTakenDealthRatio;
    }

    public long getCheckpointsReached() {
        return checkpointsReached;
    }

    public long getChestsLooted() {
        return chestsLooted;
    }

    public long getParkourFails() {
        return parkourFails;
    }

    public BigDecimal getDistanceReached() {
        return distanceReached;
    }

    public double getAverageDistanceReached() {
        return averageDistanceReached;
    }

}

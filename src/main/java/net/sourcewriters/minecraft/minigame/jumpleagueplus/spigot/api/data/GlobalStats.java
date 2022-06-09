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
    private final long gamesAborted;
    private final double gamesWonLostRatio;
    private final long gamesParkourEndReached;
    private final long gamesParkourWon;
    private final long gamesParkourLost;
    private final double gamesParkourWonLostRatio;

    private final long kills;
    private final long deaths;
    private final double killDeathRatio;

    private final BigDecimal damageTaken;
    private final BigDecimal damageDealt;
    private final double damageTakenDealthRatio;
    private final long chestsLooted;
    private final long parkourFails;

    private final long checkpointsReached;
    private final double averageCheckpointsReached;

    public GlobalStats(UUID owner) {
        this(owner, BigInteger.ZERO, 0, 0, 0, 0, 0, 0, 0, BigDecimal.ZERO, BigDecimal.ZERO, 0, 0, 0);
    }

    public GlobalStats(UUID owner, BigInteger points, long gamesPlayed, long gamesWon, long gamesAborted, long gamesParkourEndReached,
        long gamesParkourWon, long kills, long deaths, BigDecimal damageTaken, BigDecimal damageDealt, long checkpointsReached,
        long chestsLooted, long parkourFails) {
        this.owner = Objects.requireNonNull(owner);
        this.points = points;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesAborted = gamesAborted;
        this.gamesLost = gamesPlayed - gamesAborted - gamesWon;
        this.gamesWonLostRatio = gamesWon / Math.max(1D, gamesLost);
        this.gamesParkourEndReached = gamesParkourEndReached;
        this.gamesParkourWon = gamesParkourWon;
        this.gamesParkourLost = gamesPlayed - gamesParkourWon;
        this.gamesParkourWonLostRatio = gamesParkourWon / Math.max(1D, gamesParkourLost);
        this.kills = kills;
        this.deaths = deaths;
        this.killDeathRatio = kills / Math.max(1D, deaths);
        this.damageTaken = damageTaken;
        this.damageDealt = damageDealt;
        this.damageTakenDealthRatio = damageDealt.compareTo(BigDecimal.ZERO) <= 0 ? 0 : damageTaken.divide(damageDealt).doubleValue();
        this.checkpointsReached = checkpointsReached;
        this.averageCheckpointsReached = gamesPlayed == 0 ? 0 : checkpointsReached / (double) gamesPlayed;
        this.chestsLooted = chestsLooted;
        this.parkourFails = parkourFails;
    }

    public GlobalStats add(RoundStats round) {
        if (!round.getOwner().equals(owner)) {
            return null;
        }
        return new GlobalStats(owner, points.add(BigInteger.valueOf(round.getPoints())), gamesPlayed + 1,
            gamesWon + round.hasWonDeathmatchAsInt(), gamesAborted + round.isDisqualifiedAsInt(),
            gamesParkourEndReached + round.hasReachedParkourEndAsInt(), gamesParkourWon + round.hasWonParkourAsInt(),
            kills + round.getKills(), deaths + round.getDeaths(), damageTaken.add(BigDecimal.valueOf(round.getDamageTaken())),
            damageDealt.add(BigDecimal.valueOf(round.getDamageDealt())), checkpointsReached + round.getCheckpoints(),
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

    public long getGamesAborted() {
        return gamesAborted;
    }

    public double getGamesWonLostRatio() {
        return gamesWonLostRatio;
    }
    
    public long getGamesParkourEndReached() {
        return gamesParkourEndReached;
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

    public double getAverageCheckpointsReached() {
        return averageCheckpointsReached;
    }

    public long getChestsLooted() {
        return chestsLooted;
    }

    public long getParkourFails() {
        return parkourFails;
    }

}

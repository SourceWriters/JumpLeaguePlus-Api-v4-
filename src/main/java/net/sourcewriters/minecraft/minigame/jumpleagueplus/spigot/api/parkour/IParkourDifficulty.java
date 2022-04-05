package net.sourcewriters.minecraft.minigame.jumpleagueplus.spigot.api.parkour;

import java.util.Comparator;

public interface IParkourDifficulty {
    
    public static final Comparator<IParkourDifficulty> COMPARATOR = (o1, o2) -> Integer.compare(o1.getDifficultyScore(), o2.getDifficultyScore());

    int getDifficultyScore();

    int getAwardedPoints();

    String getName();
    
    String getId();

}

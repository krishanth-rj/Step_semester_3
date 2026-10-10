package arrays.assigment_problems;

import java.util.Arrays;

public class Player implements Comparable<Player> {
    // Assumed rules because the Week 5 assignment PDF was unavailable:
    // 10+ matches is established; 5-9 matches requires the player to be fit.
    private static final int ESTABLISHED_MATCHES = 10;
    private static final int MINIMUM_LESS_EXPERIENCED_MATCHES = 5;

    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;
    private final boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= ESTABLISHED_MATCHES;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        if (isDraftable(matchesPlayed)) return true;
        return matchesPlayed >= MINIMUM_LESS_EXPERIENCED_MATCHES && !injured;
    }

    @Override
    public int compareTo(Player other) {
        int byAverage = Double.compare(other.battingAverage, battingAverage);
        return byAverage != 0 ? byAverage : name.compareTo(other.name);
    }

    public static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;
        for (Player player : players) {
            if (isDraftable(player.matchesPlayed, player.injured)) draftable[count++] = player;
        }
        draftable = Arrays.copyOf(draftable, count);
        Arrays.sort(draftable);
        if (draftable.length == 0) return "No draftable players";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) result.append(" | ");
            result.append(i + 1).append(". ").append(draftable[i].name);
        }
        return result.toString();
    }
}

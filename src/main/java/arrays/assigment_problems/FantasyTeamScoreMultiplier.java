package arrays.assigment_problems;

public class FantasyTeamScoreMultiplier {
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }
}

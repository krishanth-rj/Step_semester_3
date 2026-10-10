package arrays.class_problems;

public class DuplicateTeamNameFinder {
    public static String findDuplicateTeam(String[] teamNames) {
        for (int first = 0; first < teamNames.length; first++) {
            for (int second = first + 1; second < teamNames.length; second++) {
                if (teamNames[first].equals(teamNames[second])) {
                    return "Duplicate Found: " + teamNames[first];
                }
            }
        }
        return "No Duplicates Found";
    }
}

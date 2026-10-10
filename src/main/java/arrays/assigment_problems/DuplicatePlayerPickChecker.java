package arrays.assigment_problems;

public class DuplicatePlayerPickChecker {
    public static String findDuplicatePick(String[] playerNames) {
        for (int first = 0; first < playerNames.length; first++) {
            for (int second = first + 1; second < playerNames.length; second++) {
                if (playerNames[first].equals(playerNames[second])) {
                    return "Duplicate Found: " + playerNames[first];
                }
            }
        }
        return "No Duplicates Found";
    }
}

package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {

        // if the list is null invalid
        if (bpms == null) {
            return "Invalid, List is null";
        }

        // if nothing is contained within the list
        if (bpms.size() == 0) {
            return "Invalid Size, List must contain at least one item";
        }

        int sum = 0;
        // summing bpms
        for (int i = 0; i < bpms.size(); i++) {
            sum += i;
        }
        // calculating average
        int average = sum / bpms.size();

        // classifying average
        if (average >= 140) {
            return "HIGH";

        } else if (average >= 100 && average <= 139) {
            return "MEDIUM";

        } else {
            return "LOW";

        }
    }

    public static boolean isValidTrackTitle(String title) {
        // if the title is null, less than 1 char, or greater than 30 chars in length
        // it is an invalid title
        if (title == null || title.length() < 1 || title.length() > 30) {
            return false;
        }

        // for each character in the string if it is not a letter or a space,
        // it is not valid, and the track title is not valid as well
        for (int i = 0; i < title.length(); i++) {

            char curr = title.charAt(i);

            if (!Character.isLetter(curr) || curr != ' ') {
                return false;
            }
        }
        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        // Clamp volume into range 0–100
        if (volumeDb > 100) {
            return 100;
        } else if (volumeDb < 0) {
            return 0;
        } else {
            return volumeDb;
        }
    }
}

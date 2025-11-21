package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {

        // if nothing is contained within the list
        if (bpms.size() == 0) {
            return "Invalid Size, List must contain at least one item";
        }
        // if the list is null invalid
        if (bpms == null) {
            return "Invalid, List is null";
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

    //Checks for alphabetic characters + spaces, 1–30 chars
    //Reject null or special characters   
    public static boolean isValidTrackTitle(String title) {
        // if the title it less than 1 char or greater than 30, invalid string
        if(title.length() < 1 || title.length() > 30) {
            return false;
        }
        
        return title.matches("[a-zA-Z]");
    }

    public static int normalizeVolume(int volumeDb) {
        if(volumeDb > 100){
            return 100;
        }else if(volumeDb < 0){
            return 0;
        }else{
            return volumeDb;
        }
    }
}

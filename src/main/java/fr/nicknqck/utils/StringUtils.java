package fr.nicknqck.utils;

public class StringUtils {

    public static String secondsTowardsBeautifulinScoreboard(int seconds){
        int days = seconds / 86400; // 86400 seconds in a day
        int remainingSecondsAfterDays = seconds % 86400;

        int hours = remainingSecondsAfterDays / 3600;
        int remainingSecondsAfterHours = remainingSecondsAfterDays % 3600;

        int minutes = remainingSecondsAfterHours / 60;
        int sec = remainingSecondsAfterHours % 60;

        StringBuilder timeString = new StringBuilder();

        if (days > 0) {
            timeString.append(days).append("d");
        }
        if (hours > 0) {
            timeString.append(hours).append("h");
        }
        if (minutes > 0) {
            timeString.append(minutes).append("m");
        }
        if (sec > 0) {
            timeString.append(sec).append("s");
        }

        return timeString.toString().trim();
    }
}

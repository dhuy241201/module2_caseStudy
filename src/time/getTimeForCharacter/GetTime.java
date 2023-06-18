package time.getTimeForCharacter;

import entity.MultiWorld.World;

import java.text.SimpleDateFormat;
import java.util.Date;


public class GetTime {
    public static String formatTime(long time) {
        long minutes = time / 1000 / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        long seconds = time/1000 - (minutes * 60);
        String result = "";

        if (days > 0) {
            if (days == 1) {
                result += days + " day, ";
            } else {
                result += days + " days, ";
            }
            hours %= 24;
        }

        if (hours > 0) {
            if (hours == 1) {
                result += hours + " hour, ";
            } else {
                result += hours + " hours, ";
            }
            minutes %= 60;
        }

        if (minutes > 0) {
            if (minutes == 1) {
                result += minutes + " minute, ";
            } else {
                result += minutes + " minutes, ";
            }
        }
        if (seconds > 0) {
            if (seconds == 1) {
                result += seconds + " second";
            } else {
                result += seconds + " seconds";
            }
        }
        return result;
    }

    public static String getWorldLifeTime(World currentWorld) {
        long timeStart = currentWorld.getDateCreated();
        long timeNow = System.currentTimeMillis();
        long worldLifeTime = timeNow - timeStart;
        String time = formatTime(worldLifeTime);
        return time;
    }

    public static String getWorlDateCreatedAfterFormat(World currentWorld) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEEEEEE, dd / MMMMMMMMM / yyyy |  hh : mm : ss");
        return dateFormat.format(new Date(currentWorld.getDateCreated()));
    }
}

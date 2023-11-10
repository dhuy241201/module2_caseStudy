package time.getTimeForCharacter;

import CRUD.CRUD_Character;
import CRUD.CRUD_World;
import design.DesignText;
import entity.MultiWorld.World;
import service.MenuService;
import ulti.Input;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;


public class GetTime {
    static Scanner scanner = new Scanner(System.in);
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

    private static int countForTimeTask = 0;
    public static void getWorldLifeTime(World currentWorld) {
        long timeStart = currentWorld.getDateCreated();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                long timeNow = System.currentTimeMillis();
                long worldLifeTime = timeNow - timeStart;
                String time = formatTime(worldLifeTime);
                System.out.printf("    🌌World lifetime: " + time + "\r");
                countForTimeTask++;
                if (countForTimeTask == 11){
                    timer.cancel();
                    countDownLatch.countDown();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,1000);
        try {
            countDownLatch.await();
        }catch (Exception e){
            System.out.println(DesignText.TEXT_RED + "Error!!!" + DesignText.TEXT_RESET);
        }

        boolean isChoiceValid = false;
        do {
            System.out.printf(DesignText.TEXT_PURPLE + "\n\nDo you want to countinue see world life time ?" + DesignText.TEXT_RESET);
            String choice = Input.prompt("Enter your choice (Y/N): ");
            System.out.println();
            if (choice.equalsIgnoreCase("y")){
                countForTimeTask = 0;
                System.out.println();
                System.out.println(DesignText.TEXT_YELLOW + "                   ☀ YOUR FANTASY WORLD ☀                   " + DesignText.TEXT_RESET);
                System.out.println();
                CRUD_World.showWorldInformation(currentWorld);
                isChoiceValid = true;
            } else if (choice.equalsIgnoreCase("n")) {
                System.out.printf("\n⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻\n\n");
                MenuService.menuCRUD_WorldForWibu(CRUD_Character.getCurrentWibuForWorld(currentWorld));
                isChoiceValid = true;
                countForTimeTask = 0;
                break;
            }else{
                System.out.printf("Choice is not valid");
            }
        }while (!isChoiceValid);

    }

    public static String getWorlDateCreatedAfterFormat(World currentWorld) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEEEEEE, dd / MMMMMMMMM / yyyy |  hh : mm : ss");
        return dateFormat.format(new Date(currentWorld.getDateCreated()));
    }
}

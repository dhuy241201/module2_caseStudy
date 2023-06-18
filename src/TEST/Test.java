package TEST;

import CRUD.CRUD_World;
import entity.MultiWorld.World;
import time.getTimeForCharacter.GetTime;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

    static String getWorldtimeLine111111(World currentWorld){
        long timeStart = currentWorld.getDateCreated();
        long timeNow = System.currentTimeMillis();
        long worldLifeTime = timeNow - timeStart;
        String time = GetTime.formatTime(worldLifeTime);
        return time;
    }
    public static void main(String[] args) {
        String time1 = "1687053385044";
        World newWorld = new World("Test", "Only test", "Test",time1);
        Timer time = new Timer();
        System.out.printf("\n   📅Creation date: " + GetTime.getWorlDateCreatedAfterFormat(newWorld) + "\n\n");
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                System.out.printf("   🌌\033[1mWorld lifetime:\033[0m " + getWorldtimeLine111111(newWorld) + "\r");
            }
        };
        time.scheduleAtFixedRate(timerTask,1000, 1000);
//        System.out.printf("Nhập q để thoát: ");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println();
//        String input = scanner.nextLine();
//        if (input.equalsIgnoreCase("Q")) { // nếu input là Q hoặc q
//            time.cancel(); // dừng bộ lên lịch
//            System.out.println("\n   Chương trình đã thoát"); // in ra thông báo
        }

    }


package SubCase_FindLOLChampion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        long date = System.currentTimeMillis();
        System.out.println(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEEEEEE, dd / MMMMMMMMM / yyyy |  hh : mm : ss");
        String dateForShow = dateFormat.format(new Date(date));
        System.out.printf(dateForShow);
    }
}


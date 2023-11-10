package SubCase_FindLOLChampion;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
    static final List<String> LIST_CHAMPION_NAME = new ArrayList<>();
    public static void main(String[] args) {
        try {
            FileReader read = new FileReader("\\src\\TEST\\characterlist.csv");
            BufferedReader bufferedReader = new BufferedReader(read);
            while (bufferedReader.readLine() != null){
                LIST_CHAMPION_NAME.add(bufferedReader.readLine());
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }


    }
}

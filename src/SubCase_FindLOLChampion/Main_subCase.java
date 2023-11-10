package SubCase_FindLOLChampion;


import design.DesignText;
import ulti.Input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main_subCase {
    static final List<String> LIST_CHAMPION_NAME = new ArrayList<>();

    public static void main(String[] args) {
        try {
            FileReader read = new FileReader("src\\SubCase_FindLOLChampion\\characterlist.csv");
            BufferedReader bufferedReader = new BufferedReader(read);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                LIST_CHAMPION_NAME.add(line);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        String nameInputFromPlayer;
        do {
            nameInputFromPlayer = Input.prompt("Enter champion's name: ");
            if (nameInputFromPlayer.equalsIgnoreCase("stop")) {
                System.out.printf("\n" + DesignText.TEXT_CYAN + "Program has stopped" + DesignText.TEXT_RESET + "\n");
                System.exit(0);
            } else {
                List<String> listChampionNameAfterFind = new ArrayList<>();
                System.out.println();
                for (String championName : LIST_CHAMPION_NAME) {
                    ;
                    String[] wordsOfChampionName = championName.split("");
                    if (nameInputFromPlayer.length() == 1) {
                        for (int i = 0; i <= (championName.length() - nameInputFromPlayer.length()); i++) {
                            int indexOfWord = i;
                            String keywordFromNameOfChampion = "";
                            for (int j = 0; j < nameInputFromPlayer.length(); j++) {
                                keywordFromNameOfChampion += wordsOfChampionName[indexOfWord];
                                indexOfWord++;
                            }
                            if (keywordFromNameOfChampion.equalsIgnoreCase(nameInputFromPlayer)) {
                                listChampionNameAfterFind.add(championName);
                                break;
                            }
                        }
                    } else {
                        for (int i = 0; i < (championName.length() - nameInputFromPlayer.length()); i++) {
                            int indexOfWord = i;
                            String keywordFromNameOfChampion = "";
                            for (int j = 0; j < nameInputFromPlayer.length(); j++) {
                                keywordFromNameOfChampion += wordsOfChampionName[indexOfWord];
                                indexOfWord++;
                            }
                            if (keywordFromNameOfChampion.equalsIgnoreCase(nameInputFromPlayer)) {
                                listChampionNameAfterFind.add(championName);
                                break;
                            }
                        }
                    }
                }
                int serial = 1;
                if (listChampionNameAfterFind.size() == 0){
                    System.out.printf(DesignText.TEXT_RED + "There is no matching champion's name" + DesignText.TEXT_RESET + "\n");
                }else {
                    System.out.printf(DesignText.TEXT_CYAN + "List name of Champion: " + DesignText.TEXT_RESET);
                    for (String championName : listChampionNameAfterFind) {
                        if (listChampionNameAfterFind.indexOf(championName) == 0) {
                            System.out.println("  " + serial + ". " + championName);
                            serial++;
                        } else {
                            System.out.printf("                         " + serial + ". " + championName + "\n");
                            serial++;
                        }
                    }
                }
            }
        }while (true);
    }
}

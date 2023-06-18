package ulti;

import entity.MultiWorld.World;
import entity.MultiWorld.Character;
import entity.Users.Wibu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFileUlti {
    public static List<String> readFile(String path) {
        List<String> objectList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!= null){
                objectList.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return objectList;
    }

    public static List<Wibu> readFileWibu() {
        List<String> wibuPropertiesList = readFile("src\\file\\wibu.csv");
        List<Wibu> wibuList = new ArrayList<>();
        final int USER_INDEX = 1;
        final int PASSWORD_INDEX = 2;
        final int NAME_INDEX = 3;
        final int EMAIL_INDEX = 4;
        for (String propertiesOfWibu: wibuPropertiesList){
            if (propertiesOfWibu.equals(wibuPropertiesList.get(0))){
                continue;
            }
            String[] properties = propertiesOfWibu.split(";");
            wibuList.add(new Wibu(
                                    properties[USER_INDEX],
                                    properties[PASSWORD_INDEX],
                                    properties[NAME_INDEX],
                                    properties[EMAIL_INDEX]
                    )
            );
        }
        return wibuList;
    }
    public static List<World> readFileWorlds() {
        List<String> worldPropertiesList = readFile("src\\file\\worlds.csv");
        List<World> worldList = new ArrayList<>();
        final int NAME_INDEX = 1;
        final int FANTASY_INDEX = 2;
        final int AUTHOR_INDEX = 3;
        final int DATE_CREATED_INDEX = 4;
        for (String propertiesOfWorld: worldPropertiesList){
            if (propertiesOfWorld.equals(worldPropertiesList.get(0))){
                continue;
            }
            String[] properties = propertiesOfWorld.split(";");
            worldList.add(new World(
                            properties[NAME_INDEX],
                            properties[FANTASY_INDEX],
                            properties[AUTHOR_INDEX],
                            properties[DATE_CREATED_INDEX]
                    )
            );
        }
        return worldList;
    }
    public static List<Character> readFileCharacters() {
        List<String> characterPropertiesList = readFile("src\\file\\characters.csv");
        List<Character> characterList = new ArrayList<>();
        final int NAME_INDEX = 1;
        final int AGE_INDEX = 2;
        final int GENDER_INDEX = 3;
        final int ROLE_INDEX = 4;
        final int ABILITY_INDEX = 5;
        final int WORLD_ID_INDEX = 6;
        final int STORY_INDEX = 7;
        for (String propertiesOfCharacter: characterPropertiesList){
            if (propertiesOfCharacter.equals(characterPropertiesList.get(0))){
                continue;
            }
            String[] properties = propertiesOfCharacter.split(";");
            characterList.add(new Character(
                            properties[NAME_INDEX],
                            properties[AGE_INDEX],
                            properties[GENDER_INDEX],
                            properties[ROLE_INDEX],
                            properties[ABILITY_INDEX],
                            properties[WORLD_ID_INDEX],
                            properties[STORY_INDEX]
                    )
            );
        }
        return characterList;
    }

}

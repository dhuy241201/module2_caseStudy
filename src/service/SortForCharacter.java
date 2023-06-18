package service;

import CRUD.CRUD_Character;
import entity.MultiWorld.Character;
import entity.MultiWorld.World;
import sort.sortCharacter.SortByAge;
import sort.sortCharacter.SortByGender;
import sort.sortCharacter.SortByName;
import ulti.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static service.UserService.CHARACTER_LIST;
import static ulti.Choice.*;
import static ulti.Choice.CHOICE_4;

public class SortForCharacter {
    public static List<Character> getAllCharacterFromWorld(World currentWorld){
        List<Character> listCharacterOfWorld = new ArrayList<>();
        for (Character character : CHARACTER_LIST){
            if (character.getWorldID() == currentWorld.getWorldID()){
                listCharacterOfWorld.add(character);
            }
        }
        return listCharacterOfWorld;
    }
    public static void sortChacracterByName(World currentWorld){
        List<Character> charactersList = getAllCharacterFromWorld(currentWorld);
        Collections.sort(charactersList, new SortByName());
        showAllCharacterAfterSort(charactersList,currentWorld);
    }

    public static void sortCharacterByAge(World currentWorld){
        List<Character> charactersList = getAllCharacterFromWorld(currentWorld);
        Collections.sort(charactersList, new SortByAge());
        showAllCharacterAfterSort(charactersList,currentWorld);
    }

    public static void sortCharacterByGender(World currentWorld){
        List<Character> charactersList = getAllCharacterFromWorld(currentWorld);
        Collections.sort(charactersList, new SortByGender());
        showAllCharacterAfterSort(charactersList,currentWorld);
    }

    public static void showAllCharacterAfterSort(List<Character> characterList, World currentWorld){
        System.out.println("ALL CHARACTER OF WORLD " + currentWorld.getName().toUpperCase());
        System.out.println();
        System.out.printf("Name\t\t\t\t" + "\t\t" + "Age" + "\t\t" + "Gender" + "\t\t" + "Role" + "\t\t" + "Ability");
        for (Character character : characterList){
            CRUD_Character.showCharacterInfomationForAll(character);
        }
    }
    public static void choiceSortForCharacter(World currentWorld){
        System.out.printf("\n\n");
        System.out.printf("SORT LIST CHARACTER\n\n");
        System.out.println("  (1) Sort by name");
        System.out.println("  (2) Sort by age");
        System.out.println("  (3) Sort by gender");
        System.out.println("  (4) Back to previous page");

        boolean isChoiceValid = false;
        do {
            int choice = Integer.parseInt(Input.prompt("Enter your choice: "));
            System.out.println();
            switch (choice){
                case CHOICE_1:
                    SortForCharacter.sortChacracterByName(currentWorld);
                    choiceSortForCharacter(currentWorld);
                    isChoiceValid = true;
                    break;
                case CHOICE_2:
                    SortForCharacter.sortCharacterByAge(currentWorld);
                    choiceSortForCharacter(currentWorld);
                    isChoiceValid = true;
                    break;
                case CHOICE_3:
                    SortForCharacter.sortCharacterByGender(currentWorld);
                    choiceSortForCharacter(currentWorld);
                    isChoiceValid = true;
                    break;
                case CHOICE_4:
                    MenuService.menuCRUD_ChacracterForWibu(currentWorld);
                    break;
                default:
                    System.out.println("Choice is not valid. Try again!!!");
            }
            System.out.println();
        }while (!isChoiceValid);
    }
}

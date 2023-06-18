package CRUD;

import entity.MultiWorld.Character;
import entity.MultiWorld.World;
import entity.Users.Wibu;
import service.MenuService;
import service.SortForCharacter;
import ulti.Choice;
import ulti.Input;
import ulti.WriteFileUlti;

import java.awt.*;
import java.util.List;

import static service.UserService.CHARACTER_LIST;
import static service.UserService.WIBU_LIST;
import static ulti.Choice.CHOICE_1;
import static ulti.Choice.CHOICE_2;
import static ulti.Choice.CHOICE_3;
import static ulti.Choice.CHOICE_4;
import static ulti.Choice.CHOICE_5;
import static ulti.Choice.CHOICE_6;

public class CRUD_Character {
    public static Wibu getCurrentWibuForWorld(World currrentWorld){
        Wibu currentWibu = null;
        for (Wibu wibu : WIBU_LIST){
            if (wibu.getName().equals(currrentWorld.getAuthor())){
                currentWibu = wibu;
                break;
            }
        }
        return currentWibu;
    }
    public static void createCharacter(World currentWorld) {
        String name = Input.inputCharacterName();
        int age = Input.inputCharacterAge();
        String gender = Input.inputCharacterGender();
        String role = Input.inputCharacterRole();
        String ability = Input.inputCharacterAbility();
        String story = Input.inputCharacterStory();
        Character newCharacter = new Character(name, age, gender, role, ability, currentWorld, story);
        WriteFileUlti.writeFileCharacter(newCharacter);
        CHARACTER_LIST.add(newCharacter);
        System.out.println("Your wonderful world has just welcomed a wonderful character");
    }
    public static void showCharacter(World currentWorld){
        Character currentCharacter = checkCharacterExisted(currentWorld);
        showCharacterInfomation(currentCharacter);
    }


    public static void showAllCharacter(World currentWorld){
        System.out.println("ALL CHARACTER OF WORLD " + currentWorld.getName().toUpperCase());
        System.out.println();
        System.out.printf("Name\t\t\t\t\t\t\t" + "\t\t" + "Age" + "\t\t" + "Gender" + "\t\t" + "Role" + "\t\t" + "Ability");
        for (Character character : CHARACTER_LIST){
            if (character.getWorldID() == currentWorld.getWorldID()){
                showCharacterInfomationForAll(character);
            }
        }
        SortForCharacter.choiceSortForCharacter(currentWorld);
    }


    public static void updateCharacter(World currentWorld){
        Character currentCharacter = checkCharacterExisted(currentWorld);
        Choice.selectChoiceForUpdateChacracter(currentCharacter);

        boolean isAnotherChoiceValid = false;
        do {
            String anotherChoice = Input.prompt("Do you want to change another properties ?\n" +
                    "Input Y(Yes) or N(No): ");
            if (anotherChoice.equalsIgnoreCase("y")){
                CRUD_Character.updateCharacter(currentWorld);
                isAnotherChoiceValid = true;
            }else if(anotherChoice.equalsIgnoreCase("n")){
                isAnotherChoiceValid = false;
            }else {
                System.out.println("Invalid input. Please enter Y or N");
            }
        }while (!isAnotherChoiceValid);
        WriteFileUlti.writeNewFileCharacter();
    }


    public static void exterminateCharacter(World currentWorld){
        Character currentChacter = checkCharacterExisted(currentWorld);
        CHARACTER_LIST.remove(currentChacter);
        WriteFileUlti.writeNewFileCharacter();
    }
    public static void exterminateAllCharacter(World currentWorld){
        for (Character character : CHARACTER_LIST){
            if (character.getWorldID() == currentWorld.getWorldID()){
                CHARACTER_LIST.remove(character);
            }
        }
        WriteFileUlti.writeNewFileCharacter();
    }


    public static Character checkCharacterExisted(World currentWorld){
        boolean isChacracterExisted;
        Character currentCharacter = null;
        String name;
        do{
            isChacracterExisted = false;
            name = Input.prompt("Enter character's name:");
            for (Character character : CHARACTER_LIST){
                if ((character.getWorldID())==(currentWorld.getWorldID())){
                    if (character.getName().equals(name)){
                        currentCharacter = character;
                        isChacracterExisted = true;
                        break;
                    }
                }
            }
            if (!isChacracterExisted){
                System.out.println("Character doesn't existed. Try another name!!!");
            }
        }while (!isChacracterExisted);
        return currentCharacter;
    }


    public static void showCharacterInfomation(Character currentCharacter){
        System.out.printf("CHARACTER INFORMATION\n");
        System.out.printf("\nName: " + currentCharacter.getName());
        System.out.printf("\nAge: " + currentCharacter.getAge());
        System.out.printf("\nGender: " + currentCharacter.getGender());
        System.out.printf("\nRole: " + currentCharacter.getGender());
        System.out.printf("\nAbility: " + currentCharacter.getAbility());
        System.out.println("\nStory: " + currentCharacter.getStory());
    }
    public static void showCharacterInfomationForAll(Character currentCharacter){
        System.out.printf("%-32s",currentCharacter.getName() + "\t\t" + currentCharacter.getAge() + "\t\t" + currentCharacter.getGender() + "\t\t" + currentCharacter.getRole() + "\t\t" + currentCharacter.getAbility());
    }
}

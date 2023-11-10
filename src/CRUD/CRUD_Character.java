package CRUD;

import design.DesignText;
import entity.MultiWorld.Character;
import entity.MultiWorld.World;
import entity.Users.Wibu;
import service.MenuService;
import service.SortForCharacter;
import ulti.Choice;
import ulti.Input;
import ulti.WriteFileUlti;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static service.UserService.CHARACTER_LIST;
import static service.UserService.WIBU_LIST;
import static ulti.Choice.*;

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
        System.out.printf(DesignText.TEXT_CYAN + "\nYour wonderful world has just welcomed a wonderful character\n\n" + DesignText.TEXT_RESET);
    }
    public static void showCharacter(World currentWorld){
        findCharacter(currentWorld);
        Character currentCharacter = checkCharacterExisted(currentWorld);
        System.out.println();
        showCharacterInfomation(currentCharacter);
    }



    public static void showAllCharacter(World currentWorld){
        System.out.println(DesignText.TEXT_YELLOW + "                                   ALL CHARACTER OF WORLD " + currentWorld.getName().toUpperCase()+"                                                                                                         "+ DesignText.TEXT_RESET);
        System.out.println();
        System.out.printf(DesignText.TEXT_GREEN+"%-15s\t\t%-10s\t\t%-10s\t\t%-15s\t\t%-20s\t\t%s\n","NAME","AGE","GENDER","ROLE","ABILITY","STORY"+DesignText.TEXT_RESET);
        System.out.printf("\n⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻\n\n");
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
            String anotherChoice = Input.prompt(DesignText.TEXT_RED + "Do you want to change another properties ?\n" + DesignText.TEXT_RESET +
                    "Input Y(Yes) or N(No): ");
            if (anotherChoice.equalsIgnoreCase("y")){
                Choice.selectChoiceForUpdateChacracter(currentCharacter);
                isAnotherChoiceValid = true;
            }else if(anotherChoice.equalsIgnoreCase("n")){
                isAnotherChoiceValid = true;
                System.out.println();
            }else {
                System.out.println(DesignText.TEXT_RED + "Invalid input. Please enter Y or N" + DesignText.TEXT_RESET);
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
            name = Input.prompt("Enter character's name: ");
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
                System.out.println(DesignText.TEXT_RED + "Character doesn't existed. Try another name!!!" + DesignText.TEXT_RESET);
            }
        }while (!isChacracterExisted);
        return currentCharacter;
    }

    public static void findCharacter (World currentWorld) {
        String inputNameOfChacracterFromWibu = Input.prompt("Enter character's name: ");
        System.out.println();
        List<String> listNameOfCharacterAfterSearch = getCharacterNameListForFindCharacter(inputNameOfChacracterFromWibu, currentWorld);
        showCharacterNameFromList(listNameOfCharacterAfterSearch);
        if (listNameOfCharacterAfterSearch.get(0).equals(DesignText.TEXT_RED + "There's no matching name" + DesignText.TEXT_RESET)){
            selectChoiceAfterNoMatchingName(currentWorld);
        }else {
            String choice = Input.prompt("(1) I have seen chacracter's name\n" +
                    "(2) I haven't seen character's name. Try again!!!\n" +
                    "(3) Back to previous page\n\n" +
                    "Input your choice: ");
            switch (Integer.parseInt(choice)){
                case CHOICE_1:
                    System.out.println();
                    break;
                case CHOICE_2:
                    findCharacter(currentWorld);
                    break;
                case CHOICE_3:
                    MenuService.menuCRUD_ChacracterForWibu(currentWorld);
                    break;
            }
        }
    }

    public static List<Character> getCharacterListFromWorld(World currentWorld){
        List<Character> characterList = new ArrayList<>();
        for (Character character : CHARACTER_LIST){
            if (character.getWorldID() == currentWorld.getWorldID()){
                characterList.add(character);
            }
        }
        return characterList;
    }

    public static List<String> getCharacterNameListForFindCharacter(String inputNameOfChacracterFromWibu, World currentWord){
        List<String> listNameOfCharacterAfterSearch = new ArrayList<>();
        List<Character> characterList = getCharacterListFromWorld(currentWord);
        if (inputNameOfChacracterFromWibu.length()==1){
            for (Character character : characterList) {
                String[] wordOfCharacterName = character.getName().split("");
                for (int i = 0; i <= (wordOfCharacterName.length - inputNameOfChacracterFromWibu.length()); i++) {
                    String nameAfterConcatenate = "";
                    int indexOfNameWord = i;
                    for (int j = 0; j < inputNameOfChacracterFromWibu.length(); j++) {
                        nameAfterConcatenate += wordOfCharacterName[indexOfNameWord];
                        indexOfNameWord++;
                    }
                    if (nameAfterConcatenate.equalsIgnoreCase(inputNameOfChacracterFromWibu)) {
                        listNameOfCharacterAfterSearch.add(character.getName());
                        break;
                    }
                }
            }
        }else {
            for (Character character : characterList) {
                String[] wordOfCharacterName = character.getName().split("");
                for (int i = 0; i < (wordOfCharacterName.length - inputNameOfChacracterFromWibu.length()); i++) {
                    String nameAfterConcatenate = "";
                    int indexOfNameWord = i;
                    for (int j = 0; j < inputNameOfChacracterFromWibu.length(); j++) {
                        nameAfterConcatenate += wordOfCharacterName[indexOfNameWord];
                        indexOfNameWord++;
                    }
                    if (nameAfterConcatenate.equalsIgnoreCase(inputNameOfChacracterFromWibu)) {
                        listNameOfCharacterAfterSearch.add(character.getName());
                        break;
                    }
                }
            }
        }
        if (listNameOfCharacterAfterSearch.size() == 0) {
            listNameOfCharacterAfterSearch.add(DesignText.TEXT_RED + "There's no matching name" + DesignText.TEXT_RESET);
        }
        return listNameOfCharacterAfterSearch;
    }

    public static void showCharacterNameFromList(List<String> listNameOfCharacterAfterSearch){
        System.out.printf(DesignText.TEXT_CYAN + "Suggested list: " + DesignText.TEXT_RESET);
        for (String nameOfChacracter : listNameOfCharacterAfterSearch) {
            if (listNameOfCharacterAfterSearch.indexOf(nameOfChacracter) == 0) {
                System.out.println(nameOfChacracter);
            } else {
                System.out.println("                " + nameOfChacracter);
            }
        }
    }

    public static void selectChoiceAfterNoMatchingName(World currentWorld){
        System.out.println();
        System.out.println(DesignText.TEXT_RED + "Do you want to try again ?" + DesignText.TEXT_RESET);
        boolean isChoiceAfterNoMatchingNameValid = false;
        do {
            String choiceAfterNoMatchingName = Input.prompt("Input your choice Y(Yes) or N(No): ");
            if (choiceAfterNoMatchingName.equalsIgnoreCase("y")) {
                findCharacter(currentWorld);
                break;
            } else if (choiceAfterNoMatchingName.equalsIgnoreCase("n")) {
                System.out.printf("\n");
                MenuService.menuCRUD_ChacracterForWibu(currentWorld);
                break;
            } else {
                System.out.println();
                System.out.println("Choice is not valid");
            }
        } while (!isChoiceAfterNoMatchingNameValid);
    }

    public static void showCharacterInfomation(Character currentCharacter){
        System.out.printf(DesignText.TEXT_YELLOW + "          CHARACTER INFORMATION          \n" + DesignText.TEXT_RESET);
        System.out.printf("\nName: " + currentCharacter.getName());
        System.out.printf("\nAge: " + currentCharacter.getAge());
        System.out.printf("\nGender: " + currentCharacter.getGender());
        System.out.printf("\nRole: " + currentCharacter.getRole());
        System.out.printf("\nAbility: " + currentCharacter.getAbility());
        System.out.printf("\nStory: " + currentCharacter.getStory() + "\n\n");
    }
    public static void showCharacterInfomationForAll(Character currentCharacter){
        System.out.printf("%-15s\t\t%-10s\t\t%-10s\t\t%-15s\t\t%-20s\t\t%s\n",currentCharacter.getName(),currentCharacter.getAge(),currentCharacter.getGender(),currentCharacter.getRole(),currentCharacter.getAbility(),currentCharacter.getStory());
    }
}

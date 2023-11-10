package CRUD;

import design.DesignText;
import entity.MultiWorld.World;
import entity.Users.Wibu;
import service.MenuService;
import time.getTimeForCharacter.GetTime;
import ulti.Choice;
import ulti.Input;
import ulti.WriteFileUlti;

import java.util.Date;

import static service.UserService.WORLD_LIST;

public class CRUD_World {
    public static World getcurrentWorldForWibu(Wibu wibu){
        World currentWorld = null;
        for (World world : WORLD_LIST){
            if (world.getAuthor().equals(wibu.getName())){
                currentWorld = world;
                break;
            }
        }
        return currentWorld;
    }
    public static void createWorld(Wibu wibu) {
        boolean isWibuHaveWorld = false;
        for (World world : WORLD_LIST){
            if (world.getAuthor().equals(wibu.getName())){
                System.out.printf(DesignText.TEXT_RED + "You only get to create one world\n\n" + DesignText.TEXT_RESET);
                isWibuHaveWorld = true;
                break;
            }
        }
        if (isWibuHaveWorld){
            return;
        }


        boolean isWorldExisted;
        String name;
        do {
            isWorldExisted = false;
            name = Input.prompt("* WORLD'S NAME\n\n" + "Enter the World's name: ");
            for (World world : WORLD_LIST){
                if (name.equals(world.getName())){
                    System.out.println(DesignText.TEXT_RED + "This world existed. Try again!!!" + DesignText.TEXT_RESET);
                    isWorldExisted = true;
                    break;
                }
            }

        }while (isWorldExisted);
        String fantasy = Input.prompt("* WORLD'S FANTASY\n" + "   - Write the fantasy about your world\n" + "   - The fantasy should be be at least 100 word\n\n" + "Fantasy get start: ");
        World newWorld = new World(name, fantasy, wibu);
        WriteFileUlti.writeFileWorld(newWorld);
        WORLD_LIST.add(newWorld);
        System.out.println();
        System.out.println(DesignText.TEXT_CYAN + " ✨WORLD HAS BEEN CREATED✨");
        System.out.println("             -              ");
        System.out.printf("Let’s make it more wonderful\n\n" + DesignText.TEXT_RESET);
    }

    public static void showWorld(Wibu wibu) {
        boolean isWorldExisted = false;
        for (World world : WORLD_LIST) {
            if (wibu.getName().equals(world.getAuthor())) {
                System.out.println(DesignText.TEXT_YELLOW + "                   ☀ YOUR FANTASY WORLD ☀                   " + DesignText.TEXT_RESET);
                System.out.println();
                showWorldInformation(world);
                isWorldExisted = true;
                break;
            }
        }
        if (!isWorldExisted) {
            System.out.print(DesignText.TEXT_RED + "Your world has not been created\n" + "Let make a wonderful world right now!!!\n\n" + DesignText.TEXT_RESET);
        }
    }

    public static void showAllWorld(){
        System.out.println(DesignText.TEXT_YELLOW + "                                    ☀ ALL FANTASY WORLD ☀                                                       " + DesignText.TEXT_RESET);
        System.out.println();
        System.out.printf(DesignText.TEXT_GREEN + "%-30s\t\t%-25s\t\t%s","NAME","AUTHOR","DATE CREATED" + DesignText.TEXT_RESET);
        System.out.printf("\n⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻\n\n");
        for (World world : WORLD_LIST){
            showWorldInformationForAll(world);
        }
    }
    public static void showWorldInformationForAll(World world){
        System.out.printf("%-30s\t\t%-25s\t\t%s\n",world.getName(),world.getAuthor(),GetTime.getWorlDateCreatedAfterFormat(world));
    }

    public static void updateWorld(Wibu wibu) {
        boolean isWorldExisted = false;
        for (World world : WORLD_LIST) {
            if (wibu.getName().equals(world.getAuthor())) {
                isWorldExisted = true;
                Choice.selectChoiceForUpdateWorld(world);
                WriteFileUlti.writeNewFileWorld();
            }
        }
        if (!isWorldExisted) {
            System.out.print(DesignText.TEXT_RED + "Your world has not been created\n" + "Let make a wonderful world right now!!!\n" + DesignText.TEXT_RESET);
        }
    }

    public static void exterminateWorld(Wibu wibu) {
        boolean isWorldExisted = false;
        for (World world : WORLD_LIST) {
            if (wibu.getName().equals(world.getAuthor())) {
                isWorldExisted = true;
                WORLD_LIST.remove(world);
                WriteFileUlti.writeNewFileWorld();
                CRUD_Character.exterminateAllCharacter(getcurrentWorldForWibu(wibu));
                System.out.printf(DesignText.TEXT_CYAN + "The world had been exterminated\n" +
                                  "Let’s start a new era right now\n\n" + DesignText.TEXT_RESET);
                break;
            }
        }
        if (!isWorldExisted) {
            System.out.print(DesignText.TEXT_RED + "Your world has not been created\n" + "Let make a wonderful world right now!!!\n" + DesignText.TEXT_RESET);
        }
    }
    public static void showWorldInformation(World world){
        System.out.printf(" 🔴Name: " + world.getName() + "\n");
        System.out.printf(" 📖Fantasy: " + " " + world.getFantasy() + "\n\n");
        System.out.printf("    💎Author: " + world.getAuthor() + "\n");
        System.out.printf("    📅Creation date: " + GetTime.getWorlDateCreatedAfterFormat(world) + "\n");
        GetTime.getWorldLifeTime(world);
    }

}

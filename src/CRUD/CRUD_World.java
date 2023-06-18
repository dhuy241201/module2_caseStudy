package CRUD;

import entity.MultiWorld.World;
import entity.Users.Wibu;
import service.MenuService;
import time.getTimeForCharacter.GetTime;
import ulti.Choice;
import ulti.Input;
import ulti.WriteFileUlti;

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
                System.out.printf("You only get to create one world\n\n");
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
                    System.out.println("This world existed. Try again!!!");
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
        System.out.println(" ✨WORLD HAS BEEN CREATED✨");
        System.out.printf("Let’s make it more wonderful\n\n");
    }

    public static void showWorld(Wibu wibu) {
        boolean isWorldExisted = false;
        for (World world : WORLD_LIST) {
            if (wibu.getName().equals(world.getAuthor())) {
                System.out.println("☀ YOUR FANTASY WORLD ☀");
                showWorldInformation(world);
                isWorldExisted = true;
                break;
            }
        }
        if (!isWorldExisted) {
            System.out.print("Your world has not been created\n" + "Let make a wonderful world right now!!!\n\n");
        }
    }

    public static void showAllWorld(){
        System.out.println("☀ ALL FANTASY WORLD ☀");
        System.out.println();
        for (World world : WORLD_LIST){
            showWorldInformation(world);
        }
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
            System.out.print("Your world has not been created\n" + "Let make a wonderful world right now!!!\n");
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
                System.out.printf("The world had been exterminated\n" +
                                  "Let’s start a new era right now\n\n");
                break;
            }
        }
        if (!isWorldExisted) {
            System.out.print("Your world has not been created\n" + "Let make a wonderful world right now!!!\n");
        }
    }
    public static void showWorldInformation(World world){
        System.out.printf(" Name: " + world.getName() + "\n");
        System.out.printf(" Fantasy: " + " " + world.getFantasy() + "\n\n");
        System.out.printf("   💎Author: " + world.getAuthor() + "\n");
        System.out.printf("   📅Creation date: " + GetTime.getWorlDateCreatedAfterFormat(world) + "\n");
        System.out.printf("   🌌World lifetime: " + GetTime.getWorldLifeTime(world) + "\n");
        System.out.printf("\n--------------------------------------------------------------------------------\n");
        System.out.println();
    }
}

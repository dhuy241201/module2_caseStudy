package service;

import CRUD.CRUD_Character;
import CRUD.CRUD_World;
import entity.MultiWorld.World;
import entity.Users.User;
import entity.Users.Wibu;
import ulti.Input;
import design.DesignText;

import static ulti.Choice.*;

public class MenuService {
    public static void menuForStart() {
        User currentUser;
        boolean isChoiceValid = false;
        do {
            try {
                System.out.println(DesignText.TEXT_YELLOW + "🌟WELCOME TO MULTIFANTASYWORLD🌟" + DesignText.TEXT_RESET);
                System.out.println();
                System.out.println(DesignText.TEXT_BLUE + "Choose one feature to begin");
                System.out.println(" (1) Register");
                System.out.println(" (2) Login");
                System.out.println(" (3) Logout");
                System.out.println(" (4) Exit" + DesignText.TEXT_RESET);
                int choice = Integer.parseInt(Input.prompt("Enter your choice: "));
                switch (choice) {
                    case CHOICE_1:
                        UserService.register();
                        isChoiceValid = true;
                        MenuService.menuForStart();
                        break;
                    case CHOICE_2:
                        currentUser = UserService.login();
                        isChoiceValid = true;
                        menuAfterLogin((Wibu) currentUser);
                        break;
                    case CHOICE_3:
                        currentUser = null;
                        isChoiceValid = true;
                        System.out.printf(DesignText.TEXT_CYAN + "\nLogout successful\n\n" + DesignText.TEXT_RESET);
                        MenuService.menuForStart();
                        break;
                    case CHOICE_4:
                        System.out.println("See you soon!!!");
                        System.exit(0);
                    default:
                        System.out.println();
                        System.out.println(DesignText.TEXT_RED + "Your choice is not valid" + DesignText.TEXT_RESET);
                        System.out.println();
                }
            }catch (Exception exception){
                System.out.printf(DesignText.TEXT_RED + "\nYour choice is not valid\n" + DesignText.TEXT_RESET);
                System.out.println();
            }
        } while (!isChoiceValid);
    }

    public static void menuAfterLogin(Wibu currentUser){
        boolean isNewChoiceValid = false;
        do {
            System.out.println("Choose one feature");
            System.out.println();
            System.out.println("  (1) Open menu for world");
            System.out.println("  (2) Open menu for chacracter");
            System.out.println("  (3) Logout");
            int newChoice = Integer.parseInt(Input.prompt("Enter your choice: "));
            System.out.println();
            switch (newChoice) {
                case CHOICE_1:
                    menuCRUD_WorldForWibu((Wibu) currentUser);
                    isNewChoiceValid = true;
                    break;
                case CHOICE_2:
                    if (CRUD_World.getcurrentWorldForWibu((Wibu) currentUser) != null) {
                        menuCRUD_ChacracterForWibu(CRUD_World.getcurrentWorldForWibu((Wibu) currentUser));
                        isNewChoiceValid = true;
                        break;
                    } else {
                        System.out.println(DesignText.TEXT_RED + "You haven't create a world. Let's create wonderful one right now!!!" + DesignText.TEXT_RESET);
                        System.out.println();
                        menuCRUD_WorldForWibu((Wibu) currentUser);
                        isNewChoiceValid = true;
                        break;
                    }
                case CHOICE_3:
                    System.out.printf(DesignText.TEXT_CYAN + "Log out successful!!!\n\n" + DesignText.TEXT_RESET);
                    menuForStart();
                    break;
                default:
                    System.out.println(DesignText.TEXT_RED + "Your choice is not valid. Try again!!!" + DesignText.TEXT_RESET);
            }
        } while (!isNewChoiceValid);
    }


    public static void menuCRUD_WorldForWibu(Wibu currentWibu) {
        boolean isChoiceValid = false;
        do {
            System.out.println(DesignText.TEXT_YELLOW + "🌟BEING A WIBU IS WONDERFUL🌟" + DesignText.TEXT_RESET);
            System.out.print("\nChoose one feature\n");
            System.out.println("  (1) Create new wonderful world");
            System.out.println("  (2) Show current world");
            System.out.println("  (3) Change information of world");
            System.out.println("  (4) Exterminate current world");
            System.out.println("  (5) Show all realms of multiworld");
            System.out.println("  (6) Back to previous page");
            int choice = Integer.parseInt(Input.prompt("Enter your choice: "));
            System.out.println();
            switch (choice) {
                case CHOICE_1:
                    CRUD_World.createWorld(currentWibu);
                    menuCRUD_WorldForWibu(currentWibu);
                    isChoiceValid = true;
                    break;
                case CHOICE_2:
                    CRUD_World.showWorld(currentWibu);
                    isChoiceValid = true;
                    break;
                case CHOICE_3:
                    CRUD_World.updateWorld(currentWibu);
                    menuCRUD_WorldForWibu(currentWibu);
                    isChoiceValid = true;
                    break;
                case CHOICE_4:
                    CRUD_World.exterminateWorld(currentWibu);
                    menuCRUD_WorldForWibu(currentWibu);
                    isChoiceValid = true;
                    break;
                case CHOICE_5:
                    CRUD_World.showAllWorld();
                    System.out.println();
                    menuCRUD_WorldForWibu(currentWibu);
                    isChoiceValid = true;
                    break;
                case CHOICE_6:
                    try {
                        menuAfterLogin(CRUD_Character.getCurrentWibuForWorld(CRUD_World.getcurrentWorldForWibu(currentWibu)));
                    }catch (Exception e){
                        System.out.printf(DesignText.TEXT_RED + "You must create world to use this figure\n\n");
                        menuCRUD_WorldForWibu(currentWibu);
                    }
                    isChoiceValid = true;
                    break;
                default:
                    System.out.println(DesignText.TEXT_RED + "Your choice is not valid" + DesignText.TEXT_RESET);
                    System.out.println();
            }
        } while (!isChoiceValid);
    }

    public static void menuCRUD_ChacracterForWibu(World currentWorld) {
        boolean isChoiceValid = false;
        do {
            System.out.println(DesignText.TEXT_YELLOW + "✨CHARACTER IS THE MOST IMPORTANT IN A WONDERFUL WORLD✨" + DesignText.TEXT_RESET);
            System.out.print("\nChoose one feature\n");
            System.out.println("  (1) Create new character");
            System.out.println("  (2) Show a chacracter");
            System.out.println("  (3) Change information of a character");
            System.out.println("  (4) Exterminate a chacracter");
            System.out.println("  (5) Show all chacracter");
            System.out.println("  (6) Exterminate all chacracter");
            System.out.println("  (7) Back to previous page");
            int choice = Integer.parseInt(Input.prompt("Enter your choice: "));
            System.out.println();
            switch (choice) {
                case CHOICE_1:
                    CRUD_Character.createCharacter(currentWorld);
                    menuCRUD_ChacracterForWibu(currentWorld);
                    isChoiceValid = true;
                    break;
                case CHOICE_2:
                    CRUD_Character.showCharacter(currentWorld);
                    menuCRUD_ChacracterForWibu(currentWorld);
                    isChoiceValid = true;
                    break;
                case CHOICE_3:
                    CRUD_Character.updateCharacter(currentWorld);
                    menuCRUD_ChacracterForWibu(currentWorld);
                    isChoiceValid = true;
                    break;
                case CHOICE_4:
                    CRUD_Character.exterminateCharacter(currentWorld);
                    menuCRUD_ChacracterForWibu(currentWorld);
                    isChoiceValid = true;
                    break;
                case CHOICE_5:
                    CRUD_Character.showAllCharacter(currentWorld);
                    isChoiceValid = true;
                    break;
                case CHOICE_6:
                    CRUD_Character.exterminateAllCharacter(currentWorld);
                    System.out.printf(DesignText.TEXT_BLUE + "      All character has been exterminated      \n" +
                                      "The world has returned to its original beauty\n\n" + DesignText.TEXT_RESET);
                    menuCRUD_ChacracterForWibu(currentWorld);
                    isChoiceValid = true;
                    break;
                case CHOICE_7:
                    menuAfterLogin(CRUD_Character.getCurrentWibuForWorld(currentWorld));
                    isChoiceValid = true;
                    break;
                default:
                    System.out.println(DesignText.TEXT_RED + "Your choice is not valid" + DesignText.TEXT_RESET);
                    System.out.println();
            }
        } while (!isChoiceValid);
    }

}

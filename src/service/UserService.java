package service;

import design.DesignText;
import entity.MultiWorld.World;
import entity.MultiWorld.Character;
import entity.UserFactory;
import entity.Users.User;
import entity.Users.Wibu;
import ulti.Input;
import ulti.ReaderFileUlti;
import ulti.WriteFileUlti;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    //    private static final List<User> USER_LIST = new ArrayList<>();
    public static final List<Wibu> WIBU_LIST = new ArrayList<>();
    public static final List<World> WORLD_LIST = new ArrayList<>();
    public static final List<Character> CHARACTER_LIST = new ArrayList<>();

    static {
        WIBU_LIST.addAll(ReaderFileUlti.readFileWibu());
        WORLD_LIST.addAll(ReaderFileUlti.readFileWorlds());
        CHARACTER_LIST.addAll(ReaderFileUlti.readFileCharacters());
    }

    public static void register() {
        String user = Input.inputUserInLogin();
        String password = Input.inputPasswordInLogin();
        String name = Input.inputNameInLogin();
        String email = Input.inputEmailInLogin();
        User newUser = UserFactory.createUser("WIBU", user, password, email, name);
        WIBU_LIST.add((Wibu) newUser);
        WriteFileUlti.writeFileWibu((Wibu) newUser);
        System.out.println();
        System.out.println(DesignText.TEXT_CYAN + "Welcome to join MULTIWORLD!!!");
        System.out.println(" ===Let create your WORLD=== " + DesignText.TEXT_RESET);
        System.out.println();
        MenuService.menuForStart();
    }

    public static Wibu login() {
        do {
            try {
                String user = Input.prompt("Enter user: ");
                String password = Input.prompt("Enter password: ");
                String confirm = Input.prompt("Confirm your request(Y/N): ");
                if (confirm.equalsIgnoreCase("y")) {
                    for (Wibu wibu : WIBU_LIST) {
                        if (user.equals(wibu.getUser())) {
                            if (password.equals(wibu.getPassword())) {
                                System.out.println();
                                System.out.println(DesignText.TEXT_CYAN + "Welcome back CREATOR " + wibu.getName() + DesignText.TEXT_RESET);
                                System.out.println();
                                return wibu;
                            }
                        }
                    }
                    throw new RuntimeException(DesignText.TEXT_RED + "User or Password is incorrect" + DesignText.TEXT_RESET);
                } else {
                    System.out.println();
                    MenuService.menuForStart();
                }
            } catch (Exception exception) {
                System.out.println();
                System.out.println(DesignText.TEXT_RED + exception.getMessage() + DesignText.TEXT_RESET);
            }
        } while (true);
    }
}

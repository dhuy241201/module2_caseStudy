package ulti;

import entity.Users.Wibu;

import java.util.Scanner;

import static service.UserService.WIBU_LIST;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    public static String prompt(String message) {
        System.out.printf("\n"+message);
        return scanner.nextLine();
    }

    public static String inputOfUser(String message, String regexPattern) {
        String text;
        do {
            text = prompt(message);
            if (ValidateForUser.validate(text, regexPattern)) {
                System.out.println("Invalid input!!! Try again");
            }
        } while (ValidateForUser.validate(text, regexPattern));
        return text;
    }

    public static String inputUserInLogin(){
        boolean isUserExisted;
        String user;
        do {
            isUserExisted = false;
            user = Input.inputOfUser("USER\n" +
                    "* Valid user:\n" +
                    "   - Lowercase characters\n" +
                    "   - Numbers\n\n" +
                    "Enter user: ", "USER");
            for (Wibu wibu : WIBU_LIST) {
                if (user.equals(wibu.getUser())) {
                    isUserExisted = true;
                    System.out.printf("\n\uD83D\uDCA5THIS USER HAS BEEN EXISTED\uD83D\uDCA5\n");
                }
            }
        } while (isUserExisted);
        return user;
    }
    public static String inputPasswordInLogin(){
        return inputOfUser("PASSWORD\n" +
                "* Valid password must have at least:\n" +
                "   - One number\n" +
                "   - One upercase character\n" +
                "   - One symbol\n\n" +
                "Enter password: ", "PASSWORD");
    }
    public static String inputNameInLogin(){
        boolean isNameExisted;
        String name;
        do {
            isNameExisted = false;
            name = inputOfUser("NAME\n" +
                    "* Valid name contains:\n" +
                    "   - Numbers\n" +
                    "   - Uppercase characters\n" +
                    "   - Symbol: - and .\n\n" +
                    "Enter you name: ", "NAME");
            for (Wibu wibu : WIBU_LIST) {
                if (name.equals(wibu.getName())) {
                    isNameExisted = true;
                    System.out.printf("\n\uD83D\uDCA5THIS NAME HAS BEEN EXISTED\uD83D\uDCA5\n");
                }
            }
        }while (isNameExisted);
        return name;
    }
    public static String inputEmailInLogin(){
        return inputOfUser("EMAIL\n" +
                "Enter email: ", "EMAIL");
    }
    public static String inputCharacterName(){
        String name;
        do {
            name = Input.prompt("NAME\n" +
                    "* Valid name:\n" +
                    "   - Only contains letters\n" +
                    "   - Capitalize the first letter of each word\n\n" +
                    "Enter character's name:\n");
            if(ValidateForCharacter.validate(name,"NAME")){
                System.out.println("Character's name is invalid");
            };
        }while (ValidateForCharacter.validate(name,"NAME"));
        return name;
    }
    public static int inputCharacterAge(){
        return Integer.parseInt(Input.prompt("AGE\n\n" +
                "Enter character's age: "));
    }
    public static String inputCharacterGender(){
        return Input.prompt("GENDER\n\n" +
                "Enter your character's gender: ");
    }
    public static String inputCharacterRole(){
        return Input.prompt("ROLE\n\n" +
                "Enter chracter's role: ");
    }
    public static String inputCharacterAbility(){
        return Input.prompt("ABILITY\n" +
                "If character doesn't have ability. Enter: none\n\n" +
                "Enter character's ability: ");
    }
    public static String inputCharacterStory(){
        return Input.prompt("Enter character's story\n" +
                "If you haven't figured it out yet. Enter: n\n\n" +
                "Character's story: ");
    }
}

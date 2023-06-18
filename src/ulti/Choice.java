package ulti;

import entity.MultiWorld.Character;
import entity.MultiWorld.World;

public class Choice {
    public static final int CHOICE_1 = 1;
    public static final int CHOICE_2 = 2;
    public static final int CHOICE_3 = 3;
    public static final int CHOICE_4 = 4;
    public static final int CHOICE_5 = 5;
    public static final int CHOICE_6 = 6;
    public static final int CHOICE_7 = 7;

    public static void selectChoiceForUpdateWorld(World world) {
        String choice = Input.prompt("Choose one factor you want to change:\n" + "(1) Change name\n" + "(2) Change fantasy\n\n" + "Your choice:");
        switch (Integer.parseInt(choice)) {
            case Choice.CHOICE_1:
                String newNameOfWorld = Input.prompt("Enter new world name: ");
                world.setName(newNameOfWorld);
                System.out.println("World's name changed");
                break;
            case Choice.CHOICE_2:
                String newfantasyOfWorld = Input.prompt("Write new fantasy of world: ");
                world.setFantasy(newfantasyOfWorld);
                System.out.println("History of the world had been rewrited");
                break;
        }
    }
    public static void selectChoiceForUpdateChacracter(Character currentCharacter){
        boolean isChoiceValid = false;
        do {
            try {
                int choice = Integer.parseInt(Input.prompt("Choose propertie you want to changes\n" +
                        "  (1) Name\n" +
                        "  (2) Age\n" +
                        "  (3) Gender\n" +
                        "  (4) Role\n" +
                        "  (5) Ability\n" +
                        "  (6) Story\n\n" +
                        "Your choice: "));
                switch (choice) {
                    case CHOICE_1:
                        currentCharacter.setName(Input.inputCharacterName());
                        isChoiceValid = true;
                        break;
                    case CHOICE_2:
                        currentCharacter.setAge(Input.inputCharacterAge());
                        isChoiceValid = true;
                        break;
                    case CHOICE_3:
                        currentCharacter.setGender(Input.inputCharacterGender());
                        isChoiceValid = true;
                        break;
                    case CHOICE_4:
                        currentCharacter.setRole(Input.inputCharacterRole());
                        isChoiceValid = true;
                        break;
                    case CHOICE_5:
                        currentCharacter.setAbility(Input.inputCharacterAbility());
                        isChoiceValid = true;
                        break;
                    case CHOICE_6:
                        currentCharacter.setStory(Input.inputCharacterStory());
                        isChoiceValid = true;
                        break;
                    default:
                        System.out.println("You input isn't valid. Try again!!!");
                }
            }catch (Exception exception){
                System.out.println("You input isn't valid. You must input a number!!!");
            }
        }while (!isChoiceValid);
        System.out.println("Your character's propertie has been updated");
    }

    public static void SelectChoiceForMenuCRUD_ChacracterForWibu(World currentWorld){

    }
}
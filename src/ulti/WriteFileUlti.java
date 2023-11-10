package ulti;

import entity.MultiWorld.Character;
import entity.MultiWorld.World;
import entity.Users.Wibu;

import java.io.BufferedWriter;
import java.io.FileWriter;

import static service.UserService.CHARACTER_LIST;
import static service.UserService.WORLD_LIST;

public class WriteFileUlti {
    public static void writeFileWibu(Wibu wibu) {
        try {
            FileWriter fileWriter = new FileWriter("src\\file\\wibu.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(wibu.getWibuID() + ";" + wibu.getUser() + ";" + wibu.getPassword() + ";" + wibu.getEmail() + ";" + wibu.getName() + "\n");
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFileWorld(World world) {
        try {
            FileWriter fileWriter = new FileWriter("src\\file\\worlds.csv",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(world.getWorldID() + ";" + world.getName() + ";" + world.getFantasy() + ";" + world.getAuthor() + ";" + world.getDateCreated() + "\n");
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeNewFileWorld() {
        try {
            FileWriter fileWriter = new FileWriter("src\\file\\worlds.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("WORLD_ID;NAME;FANTASY;AUTHOR;DATE_CREATE\n");
            for (World world : WORLD_LIST) {
                bufferedWriter.write(world.getWorldID() + ";" + world.getName() + ";" + world.getFantasy() + ";" + world.getAuthor() + ";" + world.getDateCreated() + "\n");
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeFileCharacter(Character character) {
        try {
            FileWriter fileWriter = new FileWriter("src\\file\\characters.csv",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(character.getCharacterID() + ";" + character.getName() + ";" + character.getAge() + ";" + character.getGender() + ";" + character.getRole() + ";" + character.getAbility() + ";" + character.getWorldID() + ";" + character.getStory() + "\n");
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeNewFileCharacter() {
        try {
            FileWriter fileWriter = new FileWriter("src\\file\\characters.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("CHARACTER_ID;NAME;AGE;GENDER;ROLE;ABILITY;WORLD_ID;STORY\n");
            for (Character character : CHARACTER_LIST) {
                bufferedWriter.write(character.getCharacterID() + ";" + character.getName() + ";" + character.getAge() + ";" + character.getGender() + ";" + character.getRole() + ";" + character.getAbility() + ";" + character.getWorldID() + ";" + character.getStory() + "\n");
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

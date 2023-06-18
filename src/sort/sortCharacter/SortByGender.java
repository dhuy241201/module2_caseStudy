package sort.sortCharacter;

import java.util.Comparator;
import entity.MultiWorld.Character;

public class SortByGender implements Comparator<Character> {

    @Override
    public int compare(Character character1, Character character2) {
        return character1.getGender().compareTo(character2.getGender());
    }
}

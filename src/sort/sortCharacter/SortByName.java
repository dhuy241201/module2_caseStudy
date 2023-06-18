package sort.sortCharacter;

import java.util.Comparator;
import entity.MultiWorld.Character;

public class SortByName implements Comparator<Character> {

    @Override
    public int compare(Character character1, Character character2) {
        return character1.getName().compareTo(character2.getName());
    }
}

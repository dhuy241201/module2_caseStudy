package entity.MultiWorld;

public class Character {
    private static int count = 0;
    private int characterID;
    private String name;
    private int age;
    private String gender;
    private String role;
    private String ability;
    private String story;
    private int worldID;

    public Character() {
    }

    public Character(String name, int age, String gender, String role, String ability, World world, String story) {
        characterID = ++count;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.ability = ability;
        this.worldID = world.getWorldID();
        this.story = story;
    }
    public Character(String name, String age, String gender, String role, String ability, String world_ID, String story) {
        characterID = ++count;
        this.name = name;
        this.age = Integer.parseInt(age);
        this.gender = gender;
        this.role = role;
        this.ability = ability;
        this.worldID = Integer.parseInt(world_ID);
        this.story = story;
    }

    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getStory() {
        if (this.story.equalsIgnoreCase("n")){
            return "Unknown";
        } else {
            return story;
        }
    }

    public void setStory(String story) {
        this.story = story;
    }

    public int getWorldID() {
        return worldID;
    }
}


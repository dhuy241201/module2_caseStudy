package entity.MultiWorld;

import entity.Users.Wibu;

public class World extends MultiWorld {
    private static int count = 0;
    private int worldID;
    private String name;
    private String fantasy;
    private String author;
    private final long dateCreated;
    public World() {   //Biến final phải được gán giá trị khi tạo đối tượng nếu không sẽ gây ra lỗi

        dateCreated = System.currentTimeMillis();
    }
    public World(Wibu wibu) {

        dateCreated = System.currentTimeMillis();
        this.author = wibu.getName();
    }
    public World(String name, String fantasy, Wibu wibu) {
        worldID = ++count;
        this.name = name;
        this.fantasy = fantasy;
        this.author = wibu.getName();
        dateCreated = System.currentTimeMillis();
    }
    public World(String name, String fantasy, String author, String dateCreated) {
        worldID = ++count;
        this.name = name;
        this.fantasy = fantasy;
        this.author = author;
        this.dateCreated = Long.parseLong(dateCreated);
    }

    public int getWorldID() {
        return worldID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFantasy() {
        return fantasy;
    }

    public void setFantasy(String fantasy) {
        this.fantasy = fantasy;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "World{" +
                "worldID=" + worldID +
                ", name='" + name + '\'' +
                ", story='" + fantasy + '\'' +
                ", author=" + author +
                ", dateCreated=" + dateCreated +
                '}';
    }

}

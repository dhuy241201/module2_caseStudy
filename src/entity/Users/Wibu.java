package entity.Users;

public class Wibu extends User {
    private static int count = 0;
    private int wibuID;
    private String name;
    private String email;
    public Wibu(String user, String password, String name, String email) {
        super(user, password);
        this.name = name;
        this.email = email;
        wibuID = ++count;
    }


    public int getWibuID() {
        return wibuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Wibu{" +"id="+ wibuID +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

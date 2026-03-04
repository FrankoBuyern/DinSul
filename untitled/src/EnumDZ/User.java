package EnumDZ;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private UserRole role;

    public User(int id, String name, UserRole role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {return "User{id=" + id + ", name='" + name + "', role=" + role + "}";}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id;
    }
    @Override
    public int hashCode() {return Objects.hash(id);}
}

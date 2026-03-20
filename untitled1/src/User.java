import java.util.Objects;

public class User {
    private String name;
    private AccessLevel accessLevel;

    public User(String name, AccessLevel accessLevel) {
        this.name = name; this.accessLevel = accessLevel;}

    @Override
    public String toString() {
        return "User{name='" + name + "', accessLevel=" + accessLevel + "}";}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && accessLevel == user.accessLevel;}

    @Override
    public int hashCode() {return Objects.hash(name, accessLevel);}
    public AccessLevel getAccessLevel() {return accessLevel;}}
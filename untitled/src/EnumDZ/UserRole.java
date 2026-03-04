package EnumDZ;

public enum UserRole {

    ADMIN(5),
    MODERATOR(4),
    MANAGER(3),
    SELLER(2),
    USER(1),
    GUEST(0),
    BLOCKED(-1);

    private int accessLevel;

    UserRole(int accessLevel) {this.accessLevel = accessLevel;}
    public int getAccessLevel() {return accessLevel;}
    public boolean canDeleteUsers() {return accessLevel >= 4;}
}
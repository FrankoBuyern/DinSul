public enum AccessLevel {
    GUEST(1),
    USER(2),
    MODERATOR(3),
    ADMIN(4),
    SUPER_ADMIN(5),
    OWNER(6),
    ROOT(7);

    private final int level;

    AccessLevel(int level) {this.level = level;}

    public boolean canEdit() {return level >= 3;}

    public int getLevel() {return level;}}
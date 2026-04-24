public class Entity<T> implements Pourable {
    T value;
    boolean is_poured = false;

    public Entity(T value) {
        this.value = value;
    }

    @Override
    public void pour() {
        is_poured = true;
    }

    public String toString() {
        return "Entity = {\n" +
                "\tvalue: " + value + "\n" +
                "\tis_poured: " + is_poured + "\n" +
                "}";
    }
}
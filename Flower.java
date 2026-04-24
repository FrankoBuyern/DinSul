public class Flower {
    FLOWER_TYPE type;

    public Flower(FLOWER_TYPE type) {
        this.type = type;
    }

    public String toString() {
        return "Flower = {\n" +
                "\ttype: " + type + "\n" +
                "}";
    }
}
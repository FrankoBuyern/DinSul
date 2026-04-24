import java.util.*;

public class Test {

    public static void testEntityPour() {
        Entity<String> entity = new Entity<>("test");

        System.out.println("Before pour:");
        System.out.println(entity);

        entity.pour();

        System.out.println("After pour:");
        System.out.println(entity);
    }

    public static void testBedAddFlower() {
        Bed bed = new Bed();
        Flower flower = new Flower(FLOWER_TYPE.STANDART);

        System.out.println("Before:");
        System.out.println(bed);

        bed.add(flower);

        System.out.println("After:");
        System.out.println(bed);
    }

    public static void main(String[] args) {
        testEntityPour();
        testBedAddFlower();
    }
}
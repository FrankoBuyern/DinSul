public class Main {
    public static void main(String[] args) {
        Pallet<StandardBox> palletA = new Pallet<>(10000, 20);

        for (int i = 0; i < 5; i++) {
            palletA.addBox(new StandardBox());
        }

        System.out.println("Остаточный объем: " + palletA.getRemainingVolume());
    }

}
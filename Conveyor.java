import java.util.Random;

class Conveyor {
    private Pallet<Box> longPallet = new Pallet<>(10000, 20);
    private Pallet<Box> narrowPallet = new Pallet<>(5000, 10);

    private int shippedLong = 0;
    private int shippedNarrow = 0;
    private int totalBoxes = 0;

    private Random random = new Random();

    public void start() {
        while (shippedLong < 5 || shippedNarrow < 5) {
            Box box = generateBox();
            totalBoxes++;

            boolean placed = placeBox(box);

            if (!placed) {
                replacePallets();
            }
        }

        System.out.println("Всего обраотано коробок: " + totalBoxes);
    }

    private Box generateBox() {return random.nextBoolean() ? new StandardBox() : new FragileBox();}

    private boolean placeBox(Box box) {
        if (box instanceof FragileBox) {
            if (narrowPallet.addBox(box)) return true;
            if (longPallet.addBox(box)) return true;
        } else {
            if (longPallet.addBox(box)) return true;
            if (narrowPallet.addBox(box)) return true;
        }
        return false;
    }

    private void replacePallets() {
        if (longPallet.isFull()) {
            System.out.println("Паллет " + longPallet.getId() + " заполнен, отправлен на склад");
            shippedLong++;
            longPallet = new Pallet<>(10000, 20);
        }

        if (narrowPallet.isFull()) {
            System.out.println("Паллет " + narrowPallet.getId() + " заполнен, отправлен на склад");
            shippedNarrow++;
            narrowPallet = new Pallet<>(5000, 10);
        }
    }
}
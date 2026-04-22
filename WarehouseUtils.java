import java.util.List;

public class WarehouseUtils {

    // 2 printPalletInfo
    public static void printPalletInfo(Pallet<? extends Box> pallet) {
        List<? extends Box> boxes = pallet.getBoxes();

        for (Box box : boxes) {
            System.out.println(
                    "Тип: " + box.getClass().getSimpleName() +
                            ", объем: " + box.getVolume()
            );
        }
    }

    // 3 loadFragileBoxes
    public static void loadFragileBoxes(Pallet<? super FragileBox> pallet, FragileBox[] boxes) {
        for (FragileBox box : boxes) {
            pallet.addBox(box);
        }
    }

    // 4 calculateTotalVolume
    public static int calculateTotalVolume(Pallet<? extends Box> pallet) {
        int total = 0;

        for (Box box : pallet.getBoxes()) {
            total += box.getVolume();
        }

        return total;
    }

    // 5 transferBoxes
    public static <T extends Box> void transferBoxes(
            Pallet<T> from,
            Pallet<? super T> to
    ) {
        for (T box : from.getBoxes()) {
            to.addBox(box);
        }
    }

    // 6 findFirst
    public static <T extends Box> T findFirst(
            Pallet<? extends Box> pallet,
            Class<T> clazz
    ) {
        for (Box box : pallet.getBoxes()) {
            if (clazz.isInstance(box)) {
                return clazz.cast(box);
            }
        }
        return null;
    }
}
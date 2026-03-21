
public class WarehouseUtils {

    public static void printPalletInfo(Pallet<? extends Box> pallet){
        if(pallet.getStorage() == null) return;

        if(pallet.getCountBox() == 0){
            System.out.println("Паллет пуст");
            return;}

        for(int i = 0; i < pallet.getCountBox(); i++){
            System.out.println("Объем: " + pallet.getStorage()[i].getValume());
            System.out.println("Класс: " + pallet.getStorage()[i].getClass());}}

    public static void loadFragelBox(Pallet<? super FragileBox> pallet, FragileBox[] boxes){

        int index = pallet.getCountBox();
        int added = 0;

        for(FragileBox box : boxes){
            if(box == null) break;

            if(pallet.spaceLeft() >= box.getValume()){
                pallet.getStorage()[index++] = box;
                pallet.setCurrentValume(pallet.getCurrentValume() + box.getValume());
                added++;
            } else {
                System.out.println("Не все коробки влезли");
                break;}}
        pallet.setCountBox(pallet.getCountBox() + added);}

    public static void calculateTotalValume(Pallet<? extends Box> pallet){
        int sum = 0;

        for(int i = 0; i < pallet.getCountBox(); i++){
            sum += pallet.getStorage()[i].getValume();}

        pallet.setCurrentValume(sum);
        System.out.println("Общий объем: " + sum);}

    public static void transferBoxes(Pallet<? extends Box> pallet1, Pallet<? super Box> pallet2){

        if(pallet1.getCurrentValume() > pallet2.spaceLeft()){
            System.out.println("Недостаточно места");
            return;}

        int index = pallet2.getCountBox();

        for(int i = 0; i < pallet1.getCountBox(); i++){
            pallet2.getStorage()[index++] = pallet1.getStorage()[i];
            pallet1.getStorage()[i] = null;}

        pallet2.setCountBox(pallet2.getCountBox() + pallet1.getCountBox());
        pallet1.setCountBox(0);

        pallet2.setCurrentValume(pallet2.getCurrentValume() + pallet1.getCurrentValume());
        pallet1.setCurrentValume(0);}

    public static Box findFirst(Pallet<? extends Box> pallet, Box box){

        for(int i = 0; i < pallet.getCountBox(); i++){
            if(pallet.getStorage()[i].getClass() == box.getClass()){
                return pallet.getStorage()[i];}}
        return null;}}
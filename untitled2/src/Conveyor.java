public class Conveyor {

    private int totalSentBoxes;
    private int sentStandard = 0;
    private int sentFragile = 0;
    private int removedCount = 0;

    private static final int MAX_REMOVED = 200;
    Box[] removed = new Box[MAX_REMOVED];

    public Box createRandomBox(){
        int rnd = (int)(Math.random() * 10);
        if(rnd % 2 == 0){
            return new StandartBox(50,
                    (int)(Math.random() * 10) + 1,
                    (int)(Math.random() * 10) + 1,
                    100);
        } else {
            return new FragileBox(10,
                    (int)(Math.random() * 10) + 1,
                    10,
                    FragilityLevel.LOW);}}

    public void onConveyor(Pallet<Box>[] palletA, Pallet<Box>[] palletB){

        int indexA = 0;
        int indexB = 0;

        while ((palletA.length + palletB.length) > (sentStandard + sentFragile)) {
            Box box = createRandomBox();
            if (box instanceof StandartBox) {
                if (sentStandard < palletA.length) {
                    boolean added = palletA[indexA].add(box);
                    if (!palletA[indexA].isFull() && !added && removedCount < removed.length) {
                        removed[removedCount++] = box;}
                    for (Box b : removed) {
                        if (b == null) break;
                        if (b instanceof StandartBox) {
                            palletA[indexA].add(b);}}
                    if (palletA[indexA].isFull()) {
                        palletA[indexA].print();
                        System.out.println(palletA[indexA].getCurrentValume());
                        System.out.println("Паллет Id: " + palletA[indexA].getId() + " отправлен");
                        totalSentBoxes += palletA[indexA].getCountBox();
                        indexA++;
                        sentStandard++;}}
            } else {
                if (sentFragile < palletB.length) {
                    boolean added = palletB[indexB].add(box);
                    if (!palletB[indexB].isFull() && !added && removedCount < removed.length) {
                        removed[removedCount++] = box;}
                    for (Box b : removed) {
                        if (b == null) break;
                        if (b instanceof FragileBox) {
                            palletB[indexB].add(b);}}
                    if (palletB[indexB].isFull()) {
                        palletB[indexB].print();
                        System.out.println(palletB[indexB].getCurrentValume());
                        System.out.println("Паллет ID: " + palletB[indexB].getId() + " отправлен");
                        totalSentBoxes += palletB[indexB].getCountBox();
                        indexB++;
                        sentFragile++;}}}}
        System.out.println("Конвейер завршил работу. Отправлено коробок: " + totalSentBoxes);}}
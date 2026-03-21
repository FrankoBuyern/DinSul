
public class Pallet<T extends Box> {

    private static int counter = 0;

    private int id;
    private TypePallet palletType;

    private int maxVolume;
    private int currentVolume;
    private int boxCount;

    private boolean fullFlag = false;

    private T[] storage;

    public Pallet(T[] arr, TypePallet type){
        this.storage = arr;
        this.palletType = type;

        this.id = ++counter;

        if(type == TypePallet.A){
            maxVolume = 15000;
        } else {
            maxVolume = 5000;}

        for (T t : arr) {
            if (t == null) break;
            boxCount++;}}

    public boolean isFull(){return fullFlag;}

    public int getCurrentValume(){return currentVolume;}

    public int spaceLeft(){return maxVolume - currentVolume;}

    public boolean add(T box){
        if (fullFlag) return false;

        if (currentVolume + box.getValume() > maxVolume) return false;

        if (boxCount >= storage.length) {
            fullFlag = true;
            return false;}

        storage[boxCount++] = box;
        currentVolume += box.getValume();

        if (currentVolume >= maxVolume * 0.9) {
            fullFlag = true;}
        return true;}

    public void print(){
        for (T b : storage) {
            System.out.println(b);}}

    public int getId(){return id;}

    public T[] getStorage(){return storage;}

    public int getCountBox(){return boxCount;}

    public void setCountBox(int count){this.boxCount = count;}

    public void setCurrentValume(int volume){this.currentVolume = volume;}}
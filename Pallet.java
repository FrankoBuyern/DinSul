import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Pallet<T extends Box> {
    private String id;
    private List<T> boxes = new ArrayList<>();
    private int maxVolume;
    private int maxCount;

    public Pallet(int maxVolume, int maxCount) {
        this.id = UUID.randomUUID().toString();
        this.maxVolume = maxVolume;
        this.maxCount = maxCount;
    }

    public boolean addBox(T box) {
        if (isFull()) return false;

        int currentVolume = getCurrentVolume();
        if (currentVolume + box.getVolume() <= maxVolume) {
            boxes.add(box);
            return true;
        }
        return false;
    }

    public boolean isFull() {return getCurrentVolume() >= maxVolume || boxes.size() >= maxCount;}

    public int getCurrentVolume() {return boxes.stream().mapToInt(Box::getVolume).sum();}

    public int getRemainingVolume() {return maxVolume - getCurrentVolume();}

    public String getId() {return id;}

    public List<T> getBoxes() {return boxes;}
}
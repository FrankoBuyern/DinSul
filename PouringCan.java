import java.util.Queue;

public class PouringCan {
    public static void pour(Queue<? extends Pourable> queue) {
        for (Pourable item : queue) {
            item.pour();
        }
    }
}
package Conveyor;

public class CommonBox extends Box{
    private int weight;

    public CommonBox(int length, int height, int width, int weight){
        super(length,height,width);
        this.weight=weight;
    }
}

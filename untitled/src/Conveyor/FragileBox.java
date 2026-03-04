package Conveyor;

public class FragileBox extends Box{
    public  String fragilitylevel;

    public FragileBox(int length, int height, int width, FragilityLevel level){
        super(length, height, width);
        this.fragilitylevel= level.name();
    }
}

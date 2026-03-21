
public class StandartBox extends Box {

    private int weight;

    public StandartBox(int l, int h, int w, int weight){
        super(l, h, w);
        this.weight = weight;
        setTypeBox(ClassBoxes.STANDARTBOX);}}
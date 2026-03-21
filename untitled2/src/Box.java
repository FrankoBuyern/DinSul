abstract class Box {
    private int length;
    private int height;
    private int width;
    private ClassBoxes boxType;

    public Box(int l, int h, int w){
        this.length = l; this.height = h; this.width = w;}

    public int getValume(){return length * height * width;}

    public void setTypeBox(ClassBoxes type){this.boxType = type;}

    public ClassBoxes getTypeBox(){return boxType;}}
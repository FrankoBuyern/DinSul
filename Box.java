abstract class Box {
    protected int length;
    protected int width;
    protected int height;

    public Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getVolume() {return length * width * height;}
}
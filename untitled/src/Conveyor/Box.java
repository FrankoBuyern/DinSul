package Conveyor;

abstract class Box {
    private int length;
    private int height;
    private int width;

    public Box(int length, int height, int width){
        this.length=length;
        this.height=height;
        this.width=width;
    }
    public int getValume(){
        return length*width*height;
    }
}

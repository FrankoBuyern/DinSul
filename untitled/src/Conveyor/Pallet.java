package Conveyor;

public class Pallet <X extends Box>{
    private int maxValume;
    private int id;
    private X [] storage;
    public Pallet(int value, int id){
        this.maxValume=value;
        this.id=id;
    }
    public void plusBox(Box box){

    }

}

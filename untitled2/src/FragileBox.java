public class FragileBox extends Box {

    private String level;

    private static final int MAX_VOLUME = 1000;

    public FragileBox(int l, int h, int w, FragilityLevel lvl){
        super(l, h, w);

        this.level = lvl.name();
        setTypeBox(ClassBoxes.FRAGILEBOX);

        if (getValume() > MAX_VOLUME) {throw new IllegalArgumentException("Слишком большой объем для хрупкой коробки");}}}
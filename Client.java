import java.util.ArrayList;

public class Client {
    String name;
    ArrayList<UniqueBed> beds;

    public Client(String name) {
        this.name = name;
        this.beds = new ArrayList<>();
    }

    public boolean addBed(UniqueBed bed) {
        return beds.add(bed);
    }

    public boolean removeBed(UniqueBed bed) {
        return beds.remove(bed);
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Client = {\n");
        result.append("\tname: ").append(name).append("\n");
        result.append("\tbeds: [\n");
        for (UniqueBed bed : beds) {
            result.append(PrettyPrinter.indent(bed.toString(), 2)).append("\n");
        }
        result.append("\t]\n}");
        return result.toString();
    }
}
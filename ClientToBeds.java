import java.util.HashMap;
import java.util.LinkedList;

public class ClientToBeds extends HashMap<Client, LinkedList<UniqueBed>> {

    public String toString() {
        StringBuilder result = new StringBuilder("ClientToBeds = {\n");

        for (Client client : this.keySet()) {
            result.append("\t").append(client.name).append(": [\n");
            for (UniqueBed bed : this.get(client)) {
                result.append(PrettyPrinter.indent(bed.toString(), 2)).append("\n");
            }
            result.append("\t]\n");
        }

        result.append("}");
        return result.toString();
    }

    public void showAll() {
        System.out.println(this);
    }
}
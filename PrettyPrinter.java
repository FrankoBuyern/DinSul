public class PrettyPrinter {
    public static String indent(String text, int level) {
        String prefix = "\t".repeat(level);
        return prefix + text.replace("\n", "\n" + prefix);
    }
}
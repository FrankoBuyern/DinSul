import java.util.HashSet;

public class Bed extends HashSet<Entity<?>> implements Pourable {
    private final static int MAX_ENTITY = 10;

    @Override
    public void pour() {
        for (Entity<?> entity : this) {
            entity.pour();
        }
    }

    @Override
    public boolean add(Entity<?> entity) {
        if (this.size() + 1 > MAX_ENTITY) {
            throw new IllegalArgumentException("Bed is full");
        }
        return super.add(entity);
    }

    public boolean add(Flower flower) {
        Entity<?> empty = null;

        for (Entity<?> e : this) {
            if (e.value == null) {
                empty = e;
                break;
            }
        }

        if (empty == null) {
            try {
                return this.add(new Entity<>(flower));
            } catch (IllegalArgumentException e) {
                return false;
            }
        } else {
            empty.value = flower;
            return true;
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Bed = {\n");
        for (Entity<?> entity : this) {
            result.append(PrettyPrinter.indent(entity.toString(), 1)).append("\n");
        }
        result.append("}");
        return result.toString();
    }
}
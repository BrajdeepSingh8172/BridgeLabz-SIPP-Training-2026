import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private List<T> storage = new ArrayList<>();

    public void add(T entity) {
        storage.add(entity);
    }

    public T get(int index) {
        if (index >= 0 && index < storage.size()) {
            return storage.get(index);
        }
        return null;
    }

    public List<T> getAll() {
        return new ArrayList<>(storage);
    }

    public boolean remove(T entity) {
        return storage.remove(entity);
    }
}
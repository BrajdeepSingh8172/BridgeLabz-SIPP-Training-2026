class DataHolder<T> {
    private T value;

    public DataHolder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

public class CompositionContainer<T> {
    private DataHolder<T> dataHolder;
    private String identifier;

    public CompositionContainer(String identifier, T initialValue) {
        this.identifier = identifier;
        this.dataHolder = new DataHolder<>(initialValue);
    }

    public String getIdentifier() {
        return identifier;
    }

    public T getContent() {
        return dataHolder.getValue();
    }

    public void updateContent(T newValue) {
        dataHolder.setValue(newValue);
    }

    public static void main(String[] args) {
        CompositionContainer<String> config = new CompositionContainer<>("DB_URL", "jdbc:mysql://localhost:3306/db");
        System.out.println("Config ID: " + config.getIdentifier());
        System.out.println("Config Value: " + config.getContent());
    }
}
public class KeyValueNode<K, V> {
    private K key;
    private V value;

    public KeyValueNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void displayNodeDetails() {
        System.out.println("Node Key Class: " + key.getClass().getSimpleName());
        System.out.println("Node Value Class: " + value.getClass().getSimpleName());
        System.out.println("Payload -> [" + key + " : " + value + "]");
    }

    public static void main(String[] args) {
        KeyValueNode<Integer, String> statusNode = new KeyValueNode<>(200, "Success");
        statusNode.displayNodeDetails();
    }
}
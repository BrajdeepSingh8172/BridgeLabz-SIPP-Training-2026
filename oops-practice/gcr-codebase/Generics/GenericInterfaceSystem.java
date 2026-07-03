import java.util.HashMap;
import java.util.Map;

interface MappableRepository<K, V> {
    void save(K key, V value);
    V find(K key);
    void delete(K key);
}

class InMemoryCache<K, V> implements MappableRepository<K, V> {
    private Map<K, V> cacheMap = new HashMap<>();

    @Override
    public void save(K key, V value) {
        cacheMap.put(key, value);
    }

    @Override
    public V find(K key) {
        return cacheMap.get(key);
    }

    @Override
    public void delete(K key) {
        cacheMap.remove(key);
    }
}

public class GenericInterfaceSystem {
    public static void main(String[] args) {
        InMemoryCache<String, UserSession> sessionCache = new InMemoryCache<>();
        
        sessionCache.save("Session_001", new UserSession("Alice", "Admin"));
        UserSession activeSession = sessionCache.find("Session_001");
        System.out.println("Retrieved Session User: " + activeSession.username);
        
        sessionCache.delete("Session_001");
    }
}

class UserSession {
    String username;
    String role;

    UserSession(String username, String role) {
        this.username = username;
        this.role = role;
    }
}
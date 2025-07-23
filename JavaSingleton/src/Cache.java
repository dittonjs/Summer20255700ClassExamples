import java.util.HashMap;

public class Cache {
    private static Cache instance = null;
    private HashMap<String, Object> data = new HashMap<>();

    public synchronized void writeData() {
//        data ///
    }

    public synchronized void readData() {

    }

    private Cache() {}

    public static synchronized Cache getInstance() {
        if (instance == null) {
            instance = new Cache();
        }
        return instance;
    }
}

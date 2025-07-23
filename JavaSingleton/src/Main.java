public class Main {
    public static void main(String[] args) {

        new Thread(() -> {
            Cache cache  = Cache.getInstance();
//            do something
        }).start();
        new Thread(() -> {
            // do something
            Cache cache  = Cache.getInstance();
        }).start();
    }
}

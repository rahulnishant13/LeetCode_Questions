import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapDemo {

//    static HashMap<String, Integer> hashMap =  new HashMap<>();
    static ConcurrentHashMap<String, Integer> hashMap =  new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 4; i++) {
            executorService.execute(insertDataToMap());
        }

        executorService.shutdown();

        if(!executorService.isTerminated()){
            Thread.sleep(1000);
        }

        System.out.println("map size : "+ hashMap.size());
    }

    public static Runnable insertDataToMap(){
        return () -> {
            for (int i = 0; i < 500; i++) {
                hashMap.put(i + Thread.currentThread().getName(), i);
            }
        };
    }
}

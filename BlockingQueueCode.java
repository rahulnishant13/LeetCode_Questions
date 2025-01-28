import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueCode {
    public static void main(String[] args) {
//        implementationUsingSynchronizedBlock();
        implementationUsingBlockingQueue();
    }

    private static void implementationUsingSynchronizedBlock(){
        Queue<Integer> buffer = new LinkedList<>();
        int max = 5;

        Thread producerThread = new Thread(() -> {
            synchronized (buffer){
                for (int i = 0; i < 10; i++) {
                    if(buffer.size() > max) {
                        try {
                            System.out.println("buffer is full waiting...");
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    buffer.add(i);
                    System.out.println("produced : " + i);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    buffer.notifyAll();
                }
            }
        }, "Producer");

        Thread consumerthread =  new Thread(() -> {
            synchronized (buffer){
                for (int i = 0; i < 10; i++){
                    if(buffer.isEmpty()) {
                        try {
                            System.out.println("buffer is empty waiting...");
                            buffer.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("consumed : " + buffer.remove());
                    buffer.notify();
                }
            }
        }, "Consumer");

        producerThread.start();
        consumerthread.start();
    }

    private static void implementationUsingBlockingQueue(){
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.put(i);
                    System.out.println("blocking queue produced : " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer");

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("blocking queue consumed : " + queue.take());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer");

        producerThread.start();
        consumerThread.start();
    }
}

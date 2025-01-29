import java.util.concurrent.*;

public class BlockingQueueMultiProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i=0; i<2; i++){
            executorService.execute(new Producer(queue, i*100));
        }
        for (int i=0; i<2; i++){
            executorService.execute(new Consumer(queue, i*100));
        }

        executorService.shutdown();
    }

}

class Producer implements Runnable {
    BlockingQueue<Integer> queue;
    int producerId;

    Producer(BlockingQueue<Integer> qu, int id) {
        queue = qu;
        producerId = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                queue.put(i);
                System.out.println("Producer : "+ producerId+ " produced : " +i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Consumer implements Runnable {
    BlockingQueue<Integer> queue;
    int consumerId;

    Consumer(BlockingQueue<Integer> qu, int id){
        queue = qu;
        consumerId = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("ConsumerId : "+ consumerId + " Consumed : "+ queue.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

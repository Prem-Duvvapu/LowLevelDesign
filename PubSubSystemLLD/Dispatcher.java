package PubSubSystemLLD;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dispatcher {
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void dispatch(Subscriber subscriber, Message message) {
        executor.submit(() -> {
            try {
                subscriber.consume(message);;
            } catch (Exception e) {
                System.out.println("Error dispatching: "+e.getMessage());
            }
        });
    }

    public static void shutdown() {
        executor.shutdown();
    }
}

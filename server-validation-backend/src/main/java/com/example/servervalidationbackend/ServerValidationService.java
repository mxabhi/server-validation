package com.example.servervalidationbackend;

import com.example.model.Server;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;

import java.util.ArrayList;

@Service
public class ServerValidationService {

    public void validateServersInParallel(List<Server> servers) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<?>> futures = new ArrayList<>();

        for (Server server : servers) {
            Future<?> future = executorService.submit(() -> validateServer(server));
            futures.add(future);
        }

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (ExecutionException e) {
                // handle exception
            }
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
    public void validateServers(List<Server> servers) {
        for (Server server : servers) {
            // Simulate validation by sleeping for a random duration (1 to 3 seconds)
            try {
                Thread.sleep((long) ( 2000 ));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Set the validation result (randomly)
            server.setValid(Math.random() < 0.8); // 80% chance of being valid
        }
    }

    private void validateServer(Server server) {
        // Simulate validation by sleeping for a random duration (1 to 3 seconds)
        try {
            Thread.sleep((long) (Math.random() * 2000 + 1000));
         } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Set the validation result (randomly)
        server.setValid(Math.random() < 0.8); // 80% chance of being valid
    }
}

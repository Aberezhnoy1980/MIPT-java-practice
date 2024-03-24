package ru.aberezhnoy.presenter;

import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.model.persist.Operation;

import java.util.LinkedList;
import java.util.Queue;

public class AsyncInputOperationService {
    private final Queue<Operation> operationQueue;
    private final OperationService operationService;


    public AsyncInputOperationService(OperationService operationService) {
        this.operationQueue = new LinkedList<>();
        this.operationService = operationService;
    }

    public boolean offerOperation(Operation operation) {
        return operationQueue.offer(operation);
    }

    private void processQueue() {
        while (true) {
            Operation operation = operationQueue.poll();
            if (operation == null) {
                try {
                    System.out.println("Waiting for next operation in queue");
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Processing operation: " + operation);
                operationService.save(operation);
            }
        }
    }

    public void startAsyncOperationProcessing() {
        Thread t = new Thread() {
            @Override
            public void run() {
                processQueue();
            }
        };
        t.start();
    }
}

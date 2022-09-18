package com.example.taskfactorystarter.service;

import com.example.taskfactorystarter.model.Task;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class TaskManager {

    public BlockingQueue<Task> taskQueue;

    public TaskManager(){
        taskQueue = new LinkedBlockingQueue<>();
    }

    @Scheduled(fixedRate = 1000L)
    public void run() throws InterruptedException {

        // run tasks until queue is empty
        while (!taskQueue.isEmpty()){

            Task task = taskQueue.poll();
            task.run();

            Thread.sleep(100);
            task.report();

        }
    }

}

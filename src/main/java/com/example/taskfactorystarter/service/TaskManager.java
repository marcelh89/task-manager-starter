package com.example.taskfactorystarter.service;

import com.example.taskfactorystarter.model.Journal;
import com.example.taskfactorystarter.model.Task;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class TaskManager {

    public BlockingQueue<Task> taskQueue;
    public Map<Task, Journal> taskJournal;

    public TaskManager(){
        taskQueue = new LinkedBlockingQueue<>();
        taskJournal = new HashMap<>();
    }

    @Scheduled(fixedRate = 1000L)
    public void run() throws InterruptedException {

        // run tasks until queue is empty
        while (!taskQueue.isEmpty()){

            Long start = System.currentTimeMillis();
            Task task = taskQueue.poll();
            task.run();
            task.report();
            Long end = System.currentTimeMillis();
            taskJournal.put(task, new Journal(start, end, end - start));

            Thread.sleep(100);
        }
    }

}

package com.example.taskfactorystarter.model;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public abstract class Task {
    public String id;
    public String name;
    public TaskState state; // RUNNING, DONE, FAILED
    public List<Runnable> logs = new ArrayList();

    public void run() throws InterruptedException {
        log.info(String.format("started %s with id %s", name, id));
        logs.add(() -> log.info("----"));
        logs.add(() -> log.info(String.format("ran %s with id %s at %s", name, id, new Date().getTime())));
        Thread.sleep(2000);

        //log.info(String.format("done %s with id %s",name, id));
        logs.add(() -> log.info(String.format("done %s with id %s at %s", name, id, new Date().getTime())));
        logs.add(() -> log.info("----\n"));
        this.state = TaskState.DONE;
    };

    public void report(){
        logs.forEach(f -> f.run());
    }
}

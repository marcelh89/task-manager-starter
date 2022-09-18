package com.example.taskfactorystarter.tasks;

import com.example.taskfactorystarter.model.Task;
import com.example.taskfactorystarter.model.TaskState;
import com.example.taskfactorystarter.service.TaskManager;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@NoArgsConstructor
@Service
public class ThisTask extends Task {

    TaskManager taskManager;

    public ThisTask(String uuid){
        this.id = uuid;
        this.name = "ThisTask";
        this.state = TaskState.RUNNING;
    }

    @Autowired
    public ThisTask(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Scheduled(fixedRate = 1000L)
    public void createSitemapTask() {
        String uuid = UUID.randomUUID().toString();
        taskManager.taskQueue.add(new ThisTask(uuid));
    }

}

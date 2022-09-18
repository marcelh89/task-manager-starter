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
public class ThatTask extends Task {

    TaskManager taskManager;

    public ThatTask(String uuid){
        this.id = uuid;
        this.name = "ThatTask";
        this.state = TaskState.RUNNING;
    }

    @Autowired
    public ThatTask(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Scheduled(fixedRate = 3000L)
    public void createAnotherTask() {
        String uuid = UUID.randomUUID().toString();
        taskManager.taskQueue.add(new ThatTask(uuid));
    }

}

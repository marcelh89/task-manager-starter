package com.example.taskfactorystarter.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableAsync
//@ConditionalOnProperty(name="scheduler.enabled", matchIfMissing = true)
public class SchedulerConfig {


}

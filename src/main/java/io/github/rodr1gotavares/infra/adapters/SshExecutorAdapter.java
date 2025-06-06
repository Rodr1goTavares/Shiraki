package io.github.rodr1gotavares.infra.adapters;

import io.github.rodr1gotavares.core.entities.Task;
import io.github.rodr1gotavares.core.entities.TaskResult;
import io.github.rodr1gotavares.core.ports.RemoteExecutor;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public class SshExecutorAdapter implements RemoteExecutor<Task> {

    @Override
    public CompletableFuture<TaskResult> executeTaskAsync(Task task) {
        return CompletableFuture.supplyAsync(() -> new TaskResult(
                task.getName(),
                task.getHost(),
                LocalDateTime.now(),
                "Task successfully executed. (test)"
        ));
    }

}

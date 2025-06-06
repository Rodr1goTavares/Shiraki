package io.github.rodr1gotavares.core.usecases;

import io.github.rodr1gotavares.core.entities.Task;
import io.github.rodr1gotavares.core.entities.TaskResult;
import io.github.rodr1gotavares.core.ports.LogSaver;
import io.github.rodr1gotavares.core.ports.RemoteExecutor;

import java.util.List;


/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public class ExecuteTasksUseCase {

    private final RemoteExecutor<Task> remoteExecutor;

    private final LogSaver logSaver;

    public ExecuteTasksUseCase(RemoteExecutor<Task> remoteExecutor, LogSaver logSaver) {
        this.remoteExecutor = remoteExecutor;
        this.logSaver = logSaver;
    }

    public void start(List<Task> tasks) {
        for (Task task : tasks) {
            if (!task.isActive()) continue;

            remoteExecutor.executeTaskAsync(task).thenAccept(result -> {
                if (task.isSaveLogs()) {
                    logSaver.saveAsync(result);
                }
            });
        }
    }

}

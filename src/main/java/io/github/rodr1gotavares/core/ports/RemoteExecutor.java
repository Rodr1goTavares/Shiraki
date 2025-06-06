package io.github.rodr1gotavares.core.ports;

import io.github.rodr1gotavares.core.entities.Task;
import io.github.rodr1gotavares.core.entities.TaskResult;

import java.util.concurrent.CompletableFuture;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public interface RemoteExecutor<T extends Task> {

    CompletableFuture<TaskResult> executeTaskAsync(T task);

}

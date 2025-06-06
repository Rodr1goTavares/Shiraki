package io.github.rodr1gotavares.core.ports;

import io.github.rodr1gotavares.core.entities.TaskResult;

import java.util.concurrent.CompletableFuture;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public interface LogSaver {

    CompletableFuture<Void> saveAsync(TaskResult taskResult);

}

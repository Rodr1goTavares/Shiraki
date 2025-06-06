package io.github.rodr1gotavares.infra.adapters;

import io.github.rodr1gotavares.core.entities.TaskResult;
import io.github.rodr1gotavares.core.ports.LogSaver;

import java.util.concurrent.CompletableFuture;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public class LocalLogSaver implements LogSaver {

    @Override
    public CompletableFuture<Void> saveAsync(TaskResult taskResult) {
        return CompletableFuture.runAsync(() -> {

        });
    }

}

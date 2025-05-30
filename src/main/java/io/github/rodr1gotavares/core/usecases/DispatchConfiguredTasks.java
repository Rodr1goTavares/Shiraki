package io.github.rodr1gotavares.core.usecases;

import io.github.rodr1gotavares.core.entities.Task;

import java.util.List;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public class DispatchConfiguredTasks {

    private final List<Task> tasks;

    public DispatchConfiguredTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void init() {

    }

}

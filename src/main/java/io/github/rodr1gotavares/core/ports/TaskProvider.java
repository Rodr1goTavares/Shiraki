package io.github.rodr1gotavares.core.ports;

import io.github.rodr1gotavares.core.entities.Task;

import java.util.List;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public interface TaskProvider {

    List<Task> getTasks();

}

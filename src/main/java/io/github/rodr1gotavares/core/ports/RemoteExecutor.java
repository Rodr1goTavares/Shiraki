package io.github.rodr1gotavares.core.ports;

import io.github.rodr1gotavares.core.entities.Task;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public interface RemoteExecutor<T extends Task> {

    void executeTask(T sshTask);

}

package io.github.rodr1gotavares.infra.adapters;

import io.github.rodr1gotavares.core.entities.Task;
import io.github.rodr1gotavares.core.ports.TaskDeserializer;

import java.util.List;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public class JsonTaskDeserializer implements TaskDeserializer {

    @Override
    public List<Task> deserialize(byte[] bytes) {
        return List.of();
    }

}

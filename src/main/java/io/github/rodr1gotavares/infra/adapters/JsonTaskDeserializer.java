package io.github.rodr1gotavares.infra.adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.rodr1gotavares.core.entities.Task;
import io.github.rodr1gotavares.core.ports.TaskDeserializer;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public class JsonTaskDeserializer implements TaskDeserializer {

    @Override
    public List<Task> deserialize(byte[] bytes) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Task>>() {}.getType();
        return gson.fromJson(new String(bytes), listType);
    }

}

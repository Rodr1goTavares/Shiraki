package io.github.rodr1gotavares.infra.adapters;


import io.github.rodr1gotavares.core.ports.FileProvider;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public class LocalTaskFileProvider implements FileProvider {

    @Override
    public byte[] getBytes(String path) {
        Path p = Paths.get(path);
        try (InputStream inputStream = Files.newInputStream(p)) {
            return inputStream.readAllBytes();
        }
        catch (IOException e) {

        }
        return null;
    }

}

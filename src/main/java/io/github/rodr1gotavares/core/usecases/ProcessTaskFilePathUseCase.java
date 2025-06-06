package io.github.rodr1gotavares.core.usecases;

import io.github.rodr1gotavares.core.ports.FileProvider;
import io.github.rodr1gotavares.core.ports.SystemPathProvider;


/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public class ProcessTaskFilePathUseCase {

    private final FileProvider fileProvider;

    private final SystemPathProvider systemPathProvider;


    public ProcessTaskFilePathUseCase(
            FileProvider fileProvider,
            SystemPathProvider systemPathProvider
    ) {
        this.fileProvider = fileProvider;
        this.systemPathProvider = systemPathProvider;
    }

    public byte[] getDefaultFileByteArray() {
        String defaultTaskFilePath = this.systemPathProvider.getDefaultTaskPath();
        return this.fileProvider.getBytes(defaultTaskFilePath);
    }

    public byte[] toByteArray(String customPath) {
        return fileProvider.getBytes(customPath);
    }

}

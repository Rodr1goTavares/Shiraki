package io.github.rodr1gotavares.core.usecases;

import io.github.rodr1gotavares.core.ports.FileProvider;
import io.github.rodr1gotavares.core.ports.PathProvider;


/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public class ProcessTaskFilePathUseCase {

    private final FileProvider fileProvider;

    private final PathProvider pathProvider;


    public ProcessTaskFilePathUseCase(
            FileProvider fileProvider,
            PathProvider pathProvider
    ) {
        this.fileProvider = fileProvider;
        this.pathProvider = pathProvider;
    }

    public byte[] getDefaultFileBytes() {
        String defaultTaskFilePath = this.pathProvider.getDefaultTaskPath();
        return this.fileProvider.getBytes(defaultTaskFilePath);
    }

    public byte[] toByteArray(String customPath) {
        return fileProvider.getBytes(customPath);
    }

}

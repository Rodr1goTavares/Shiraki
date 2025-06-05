package io.github.rodr1gotavares.infra.cli;

import io.github.rodr1gotavares.core.entities.Task;
import io.github.rodr1gotavares.core.ports.TaskDeserializer;
import io.github.rodr1gotavares.core.usecases.ProcessTaskFilePathUseCase;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.util.List;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
@Command(
        name = "run",
        description = "Exec default or customized task files."
)
public class RunCommand implements Runnable {

    private final ProcessTaskFilePathUseCase processTaskPathUseCase;

    private final TaskDeserializer taskDeserializer;

    public RunCommand(ProcessTaskFilePathUseCase processTaskPathUseCase, TaskDeserializer taskDeserializer) {
        this.processTaskPathUseCase = processTaskPathUseCase;
        this.taskDeserializer = taskDeserializer;
    }

    @Option(names = {"-f", "--file"}, description = "Path of custom tasks file")
    private File customTaskFilePath;

    @Override
    public void run() {
        byte[] taskFileBytes = customTaskFilePath.isFile() ?
                this.processTaskPathUseCase.toByteArray(customTaskFilePath.getPath()) :
                this.processTaskPathUseCase.getDefaultFileBytes();

        List<Task> tasks = this.taskDeserializer.deserialize(taskFileBytes);
    }

}

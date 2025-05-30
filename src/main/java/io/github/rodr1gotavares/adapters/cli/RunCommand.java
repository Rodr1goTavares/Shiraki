package io.github.rodr1gotavares.adapters.cli;

import io.github.rodr1gotavares.core.usecases.DispatchConfiguredTasks;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
@Command(
        name = "run",
        description = "Exec default or customized task files."
)
public class RunCommand implements Runnable {

    private final DispatchConfiguredTasks dispatchConfiguredTasks;

    public RunCommand(DispatchConfiguredTasks dispatchConfiguredTasks) {
        this.dispatchConfiguredTasks = dispatchConfiguredTasks;
    }

    @Option(names = {"-f", "--file"}, description = "Path of custom tasks file")
    private File scriptFile;

    @Override
    public void run() {
        System.out.println("\nProcessing tasks...");
        this.dispatchConfiguredTasks.init();
    }

}

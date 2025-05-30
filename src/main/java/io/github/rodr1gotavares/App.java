package io.github.rodr1gotavares;

import io.github.rodr1gotavares.adapters.cli.RunCommand;
import io.github.rodr1gotavares.core.entities.Task;
import io.github.rodr1gotavares.core.usecases.DispatchConfiguredTasks;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
@Command(
        name = "shiraki",
        mixinStandardHelpOptions = true
)
public class App implements Runnable {

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();

        DispatchConfiguredTasks dispatchConfiguredTasks = new DispatchConfiguredTasks(tasks);

        Runnable runCommand = new RunCommand(dispatchConfiguredTasks);

        CommandLine cmd = new CommandLine(new App())
                .addSubcommand(runCommand);

        int exitCode = cmd.execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        String ascii = """
                 ____  _     _           _    _\s
                / ___|| |__ (_)_ __ __ _| | _(_)
                \\___ \\| '_ \\| | '__/ _` | |/ / |
                 ___) | | | | | | | (_| |   <| |
                |____/|_| |_|_|_|  \\__,_|_|\\_\\_|
            """;
        System.out.println(ascii + "\n\nWelcome to Shiraki. Type --help to see commands.");
    }

}

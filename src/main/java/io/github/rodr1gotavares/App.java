package io.github.rodr1gotavares;

import io.github.rodr1gotavares.core.ports.FileProvider;
import io.github.rodr1gotavares.core.ports.TaskDeserializer;
import io.github.rodr1gotavares.core.usecases.ProcessTaskFilePathUseCase;
import io.github.rodr1gotavares.infra.adapters.JsonTaskDeserializer;
import io.github.rodr1gotavares.infra.adapters.LocalTaskFileProvider;
import io.github.rodr1gotavares.infra.cli.RunCommand;
import io.github.rodr1gotavares.core.ports.PathProvider;
import io.github.rodr1gotavares.infra.adapters.SystemPathProvider;
import picocli.CommandLine;
import picocli.CommandLine.Command;


/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
@Command(
        name = "shiraki",
        mixinStandardHelpOptions = true
)
public class App implements Runnable {

    public static void main(String[] args) {
        FileProvider fileProvider = new LocalTaskFileProvider();

        PathProvider pathProvider = new SystemPathProvider();

        TaskDeserializer taskDeserializer = new JsonTaskDeserializer();

        ProcessTaskFilePathUseCase filePathUseCase = new ProcessTaskFilePathUseCase(
                fileProvider,
                pathProvider
        );


        Runnable runCommand = new RunCommand(filePathUseCase, taskDeserializer);

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

package io.github.rodr1gotavares.infra.adapters;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public class SystemSystemPathProvider implements io.github.rodr1gotavares.core.ports.SystemPathProvider {

    @Override
    public String getHomePath() {
        String home = System.getenv("HOME");
        if (home == null) home = System.getenv("USERPROFILE");
        if (home == null) throw new IllegalStateException("HOME path not found");
        return home;
    }

    @Override
    public String getDefaultTaskPath() {
        return getHomePath() + "/.config/shiraki/tasks.json";
    }
}

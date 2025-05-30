package io.github.rodr1gotavares.core.entities;

import java.util.*;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public abstract class Task {
    private String name;
    private String description;
    private String host;
    private int port;
    private String remoteWorkDir;
    private Map<String, String> remoteEnv;
    private String remoteCommand;
    private List<String> filesToSend;
    private boolean saveLogs;
    private String logsFolder;
    private boolean active;

    public Task() {}

    public Task(String name, String description, String host, int port, String remoteWorkDir,
                Map<String, String> remoteEnv, String remoteCommand, List<String> filesToSend,
                boolean saveLogs, String logsFolder, boolean active) {
        this.name = name;
        this.description = description;
        this.host = host;
        this.port = port;
        this.remoteWorkDir = remoteWorkDir;
        this.remoteEnv = remoteEnv;
        this.remoteCommand = remoteCommand;
        this.filesToSend = filesToSend;
        this.saveLogs = saveLogs;
        this.logsFolder = logsFolder;
        this.active = active;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getHost() { return host; }
    public int getPort() { return port; }
    public String getRemoteWorkDir() { return remoteWorkDir; }
    public Map<String, String> getRemoteEnv() { return remoteEnv; }
    public String getRemoteCommand() { return remoteCommand; }
    public List<String> getFilesToSend() { return filesToSend; }
    public boolean isSaveLogs() { return saveLogs; }
    public String getLogsFolder() { return logsFolder; }
    public boolean isActive() { return active; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setHost(String host) { this.host = host; }
    public void setPort(int port) { this.port = port; }
    public void setRemoteWorkDir(String remoteWorkDir) { this.remoteWorkDir = remoteWorkDir; }
    public void setRemoteEnv(Map<String, String> remoteEnv) { this.remoteEnv = remoteEnv; }
    public void setRemoteCommand(String remoteCommand) { this.remoteCommand = remoteCommand; }
    public void setFilesToSend(List<String> filesToSend) { this.filesToSend = filesToSend; }
    public void setSaveLogs(boolean saveLogs) { this.saveLogs = saveLogs; }
    public void setLogsFolder(String logsFolder) { this.logsFolder = logsFolder; }
    public void setActive(boolean active) { this.active = active; }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", remoteWorkDir='" + remoteWorkDir + '\'' +
                ", remoteEnv=" + remoteEnv +
                ", remoteCommand='" + remoteCommand + '\'' +
                ", filesToSend=" + filesToSend +
                ", saveLogs=" + saveLogs +
                ", logsFolder='" + logsFolder + '\'' +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return port == task.port &&
                saveLogs == task.saveLogs &&
                active == task.active &&
                Objects.equals(name, task.name) &&
                Objects.equals(description, task.description) &&
                Objects.equals(host, task.host) &&
                Objects.equals(remoteWorkDir, task.remoteWorkDir) &&
                Objects.equals(remoteEnv, task.remoteEnv) &&
                Objects.equals(remoteCommand, task.remoteCommand) &&
                Objects.equals(filesToSend, task.filesToSend) &&
                Objects.equals(logsFolder, task.logsFolder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, host, port, remoteWorkDir, remoteEnv,
                remoteCommand, filesToSend, saveLogs, logsFolder, active);
    }

    public static class Builder {
        private String name;
        private String description;
        private String host;
        private int port = 22;
        private String remoteWorkDir;
        private Map<String, String> remoteEnv = new HashMap<>();
        private String remoteCommand;
        private List<String> filesToSend = new ArrayList<>();
        private boolean saveLogs;
        private String logsFolder;
        private boolean active = true;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder remoteWorkDir(String remoteWorkDir) {
            this.remoteWorkDir = remoteWorkDir;
            return this;
        }

        public Builder remoteEnv(Map<String, String> remoteEnv) {
            this.remoteEnv = remoteEnv;
            return this;
        }

        public Builder remoteCommand(String remoteCommand) {
            this.remoteCommand = remoteCommand;
            return this;
        }

        public Builder filesToSend(List<String> filesToSend) {
            this.filesToSend = filesToSend;
            return this;
        }

        public Builder saveLogs(boolean saveLogs) {
            this.saveLogs = saveLogs;
            return this;
        }

        public Builder logsFolder(String logsFolder) {
            this.logsFolder = logsFolder;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public Task build() {
            return new Task(name, description, host, port, remoteWorkDir,
                    remoteEnv, remoteCommand, filesToSend, saveLogs, logsFolder, active) {
            };
        }
    }
}

# 🚀 Shiraki

A powerful CLI tool to automate SSH tasks across multiple remote servers. Execute shell commands or scripts securely and in parallel, with flexible configuration and optional log persistence.

---

## ✅ Features

* Run commands or scripts on multiple SSH hosts
* Parallel execution with per-host logging
* Upload local scripts and execute them remotely
* Authenticate using SSH key, password, or `ssh-agent`
* Load configuration from JSON or YAML files
* Enable/disable tasks with execution toggles
* Store logs per task or globally by default

---

## ⚙️ Configuration Format

By default, `Shiraki` loads tasks from `~/.shiraki/pipes.json` (or `.yaml`). Each entry defines a task with the following fields:

```json
[
  {
    "name": "List Logs",
    "description": "Retrieves logs from /var/log",
    "host": "user@host1.com",
    "port": 22,
    "remoteWorkDir": "/home/user",
    "remoteEnv": {
      "ENV": "production"
    },
    "remoteCommand": "ls /var/log",
    "filesToSend": ["./local/script.sh"],
    "saveLogs": true,
    "logsFolder": "/tmp/sshtask/logs",
    "active": true
  }
]
```

### 🔍 Task Field Descriptions

| Field           | Type                  | Description                                                       |
| --------------- | --------------------- | ----------------------------------------------------------------- |
| `name`          | `String`              | Logical identifier for the task                                   |
| `description`   | `String`              | Short description of what the task does                           |
| `host`          | `String`              | Target SSH destination in `user@host` format                      |
| `port`          | `int`                 | SSH port number (defaults to 22 if omitted)                       |
| `remoteWorkDir` | `String`              | Working directory on the remote host                              |
| `remoteEnv`     | `Map<String, String>` | Environment variables to be set remotely before execution         |
| `remoteCommand` | `String`              | Bash command to be executed on the remote server                  |
| `filesToSend`   | `List<String>`        | Paths to local files/scripts to upload before running the command |
| `saveLogs`      | `boolean`             | Whether to store logs of the execution                            |
| `logsFolder`    | `String`              | Custom folder to store execution logs (overrides default)         |
| `active`        | `boolean`             | Toggle to enable or disable the task                              |

---

## 🚀 Usage Examples

```bash
# Run command directly (run all active tasks in ~/.shiraki/tasks.json)
sshtask run

# Run with a command and profiles
sshtask run --task dev,prod --cmd "uptime"

# Run a script remotely on multiple servers
sshtask run --script ./deploy.sh --task server1,server2

# Load tasks from a custom task file
sshtask run --file ~/.shiraki/custom-tasks.json
```

---

## 📁 Logs

Execution logs are stored by default in `~/.sshtask/logs/<host>/<timestamp>.log`.
You can customize this per task using the `logsFolder` field.

---

## 🔐 Security

* Fully integrates with your system's `ssh-agent`
* Supports both key-based and password-based authentication
* No credentials are stored locally

---

## 🌐 Roadmap

* TUI-based interactive interface
* Remote execution of multiple files with sequencing
* Environment grouping and conditional execution
* Git hooks integration for auto-deploy
* Notification and webhook support

---

## 📙 License

MIT License © Rodr1goTavares

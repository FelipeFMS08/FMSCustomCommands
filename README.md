# CustomCommands Plugin

![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21%2B-green.svg)
![License](https://img.shields.io/badge/License-MIT-blue.svg)

A simple and lightweight Minecraft plugin that adds two customizable commands to the server: `/greet` and `/timecheck`.

This project was developed as an example of a modern plugin, using Paper's Adventure API for text formatting.

---

## Features

-   Adds the `/greet` and `/timecheck` commands.
-   All messages are 100% customizable in the `messages.yml` file.
-   Tab-completion for the `/greet` command, suggesting online player names.

---

## Requirements

-   **Server**: PaperMC (or compatible) 1.21 or newer.
-   **Java**: Java 21 or newer.

---

## 💾 Installation

1.  Download the latest `.jar` file from this repository.
2.  Place the `.jar` file into your server's `/plugins` folder.
3.  Start or restart your server. A `messages.yml` file will be automatically created in the `/plugins/CustomCommands/` folder.

---

## 🎮 Usage

### Commands

| Command           | Description                                |
| ----------------- | ------------------------------------------ |
| `/greet <player>` | Sends a custom greeting to another player. |
| `/timecheck`      | Shows the current in-game server time.     |

### Configuration

All plugin messages can be edited in the `messages.yml` file. The plugin uses the **MiniMessage** format for text, which allows for colors, bold, etc.

**Example `messages.yml`:**
```yaml
# General plugin message prefix
prefix: "<gray>[<gold>Commands</gold>]</gray> "

# /greet command messages
greet:
  received: "<gold><sender></gold> <gray>says hello to</gray> <aqua><target></aqua><gray>!</gray>"

# /timecheck command messages
timecheck:
  success: "<prefix><aqua>The current server time is: <yellow><bold><time></bold></yellow></aqua>"

  To learn more about the MiniMessage format, check the official documentation.
```

## 🛠️ Building from Source

If you wish to compile the plugin from the source code:

1.  Have **JDK 21** and **Maven** installed.
2.  Clone this repository:
    ```sh
    git clone [https://github.com/FelipeFMS08/FMSCustomCommands.git](https://github.com/FelipeFMS08/FMSCustomCommands.git)
    ```
3.  Navigate to the project directory:
    ```sh
    cd FMSCustomCommands
    ```
4.  Run the Maven build command:
    ```sh
    mvn clean package
    ```
5.  The final `.jar` file will be in the `target/` directory.


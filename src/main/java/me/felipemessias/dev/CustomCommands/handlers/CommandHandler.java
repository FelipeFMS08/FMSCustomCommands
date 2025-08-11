package me.felipemessias.dev.CustomCommands.handlers;

import me.felipemessias.dev.CustomCommands.FMSCustomCommands;
import me.felipemessias.dev.CustomCommands.commands.GreetCommand;
import me.felipemessias.dev.CustomCommands.commands.TimecheckCommand;

import java.util.Objects;

public class CommandHandler {

    private final FMSCustomCommands plugin;
    private final MessageHandler messageHandler;

    public CommandHandler(FMSCustomCommands plugin, MessageHandler messageHandler) {
        this.plugin = plugin;
        this.messageHandler = messageHandler;
    }

    public void registerCommands() {
        GreetCommand greetCommand = new GreetCommand(plugin, messageHandler);
        Objects.requireNonNull(plugin.getCommand("greet"))
                .setExecutor(new GreetCommand(plugin, messageHandler));
        Objects.requireNonNull(plugin.getCommand("greet"))
                        .setTabCompleter(greetCommand);

        Objects.requireNonNull(plugin.getCommand("timecheck"))
                .setExecutor(new TimecheckCommand(plugin, messageHandler));
    }
}

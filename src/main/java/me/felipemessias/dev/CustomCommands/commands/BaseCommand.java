package me.felipemessias.dev.CustomCommands.commands;

import me.felipemessias.dev.CustomCommands.FMSCustomCommands;
import me.felipemessias.dev.CustomCommands.handlers.MessageHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public abstract class BaseCommand implements CommandExecutor, TabCompleter {

    protected final FMSCustomCommands plugin;
    protected  final MessageHandler messageHandler;

    public BaseCommand(FMSCustomCommands plugin, MessageHandler messageHandler) {
        this.plugin = plugin;
        this.messageHandler = messageHandler;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
       try {
           execute(sender, args);
       } catch (Exception exception) {
           plugin.getLogger().severe("An error occurred while executing command " + command.getName());
           plugin.getLogger().severe("Exception: " + exception.getMessage());
       }
        return true;
    }

    /**
     * The core logic of the command.
     * @param sender The entity who executed the command.
     * @param args The arguments provided the command.
     */

    public abstract  void execute(CommandSender sender, String[] args);

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return Collections.emptyList();
    }
}

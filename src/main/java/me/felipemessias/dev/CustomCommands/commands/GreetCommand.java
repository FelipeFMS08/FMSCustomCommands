package me.felipemessias.dev.CustomCommands.commands;

import me.felipemessias.dev.CustomCommands.FMSCustomCommands;
import me.felipemessias.dev.CustomCommands.handlers.MessageHandler;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GreetCommand extends BaseCommand {

    public GreetCommand(FMSCustomCommands plugin, MessageHandler messageHandler) {
        super(plugin, messageHandler);
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player playerSender)) {
            messageHandler.sendMessage(sender, "errors.player_only");
            return;
        }

        if (args.length < 1) {
            messageHandler.sendMessage(sender, "errors.invalid_usage",
                    Placeholder.parsed("usage", "/greet <player>"));
            return;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);
        if (targetPlayer == null) {
            messageHandler.sendMessage(sender, "errors.player_not_found",
                    Placeholder.parsed("player", args[0]));
            return;
        }

        // Placeholders for the messages
        var senderPlaceholder = Placeholder.component("sender", playerSender.displayName());
        var targetPlaceholder = Placeholder.component("target", targetPlayer.displayName());

        // Send confirmation to sender
        messageHandler.sendMessage(sender, "greet.success_sent", targetPlaceholder);

        // Send greetint to target
        messageHandler.sendMessage(targetPlayer, "greet.received", senderPlaceholder, targetPlaceholder);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            String currentArg = args[0].toLowerCase();
            return Bukkit.getOnlinePlayers().stream()
                    .map(Player::getName)
                    .filter(name -> name.toLowerCase().startsWith(currentArg))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}

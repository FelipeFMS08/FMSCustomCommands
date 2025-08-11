package me.felipemessias.dev.CustomCommands.commands;

import me.felipemessias.dev.CustomCommands.FMSCustomCommands;
import me.felipemessias.dev.CustomCommands.handlers.MessageHandler;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimecheckCommand extends BaseCommand {

    public TimecheckCommand(FMSCustomCommands plugin, MessageHandler messageHandler) {
        super(plugin, messageHandler);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player player)) {
            messageHandler.sendMessage(sender, "errors.player_only");
            return;
        }

        long timeInTicks = player.getWorld().getTime();
        long hours = (timeInTicks / 1000 + 6 ) % 24;
        long minutes = (timeInTicks % 1000) * 60 / 1000;
        String formattedTime = String.format("%02d:%02d", hours, minutes);

        messageHandler.sendMessage(sender, "timecheck.success",
                Placeholder.parsed("time", formattedTime));
    }
}

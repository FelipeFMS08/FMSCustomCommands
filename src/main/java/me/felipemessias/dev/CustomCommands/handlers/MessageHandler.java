package me.felipemessias.dev.CustomCommands.handlers;

import me.felipemessias.dev.CustomCommands.managers.ConfigurationManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.bukkit.command.CommandSender;

public class MessageHandler {

    private final ConfigurationManager configurationManager;
    private final MiniMessage miniMessage;
    private final TagResolver prefixResolver;

    public MessageHandler(ConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
        this.miniMessage = MiniMessage.miniMessage();

        // Pre-build the prefix resolver
        String prefix = configurationManager.getMessagesConfig().getString("prefix", "");
        this.prefixResolver = Placeholder.parsed("prefix", prefix);
    }

    public void sendMessage(CommandSender sender, String key, TagResolver... resolvers) {
        Component message = getMessage(key, resolvers);
        if (message != Component.empty()) {
            sender.sendMessage(message);
        }
    }

    public Component getMessage(String key, TagResolver... resolvers) {
        String messageFormat = configurationManager.getMessagesConfig().getString(key);
        if (messageFormat == null || messageFormat.isEmpty()) return Component.empty();

        // Combine the global prefix resolver with any specific resolvers for this message
        TagResolver allResolvers = TagResolver.resolver(prefixResolver, TagResolver.resolver(resolvers));
        return miniMessage.deserialize(messageFormat, allResolvers);

    }
}

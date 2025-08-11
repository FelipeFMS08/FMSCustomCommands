package me.felipemessias.dev.CustomCommands;

import me.felipemessias.dev.CustomCommands.handlers.CommandHandler;
import me.felipemessias.dev.CustomCommands.handlers.MessageHandler;
import me.felipemessias.dev.CustomCommands.managers.ConfigurationManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class FMSCustomCommands extends JavaPlugin {

    private ConfigurationManager configurationManager;
    private MessageHandler messageHandler;

    @Override
    public void onEnable() {
        // Initialize managers and handlers
        this.configurationManager = new ConfigurationManager(this);
        this.messageHandler = new MessageHandler(configurationManager);
        CommandHandler commandHandler = new CommandHandler(this, messageHandler);

        commandHandler.registerCommands();

        getLogger().info("CustomCommands plugin enabled successfully!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomCommands Plugin disabled.");
    }

    public ConfigurationManager getConfigurationManager() {
        return configurationManager;
    }

    public MessageHandler getMessageHandler() {
        return messageHandler;
    }
}

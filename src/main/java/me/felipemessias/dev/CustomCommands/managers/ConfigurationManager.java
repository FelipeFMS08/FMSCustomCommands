package me.felipemessias.dev.CustomCommands.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.InputStream;

public class ConfigurationManager {

    private final JavaPlugin plugin;
    private FileConfiguration messagesConfig = null;
    private File messagesFile = null;

    public ConfigurationManager(JavaPlugin plugin) {
        // Instances the ConfigurationManager class with a reference to the plugin
        this.plugin = plugin;
        // Save and load the default config.yml
        plugin.saveDefaultConfig();
        // load the custom messages.yml
        saveDefaultMessages();
    }

    // Save the default messages.yml and reload config
    public void reloadConfig() {
        plugin.reloadConfig();

        if (messagesFile == null) {
            messagesFile = new File(plugin.getDataFolder(), "messages.yml");
        }

        messagesConfig = YamlConfiguration.loadConfiguration(messagesFile);

        // Look for defaults in the jar
        InputStream defaultMessagesStream = plugin.getResource("messages.yml");
        if (defaultMessagesStream != null) {
            YamlConfiguration defaultMessages = YamlConfiguration.loadConfiguration(messagesFile);
            messagesConfig.setDefaults(defaultMessages);
        }
    }

    // Get the messages config
    public FileConfiguration getMessagesConfig() {
        if (messagesConfig == null) {
            reloadConfig();
        }
        return messagesConfig;
    }

    // Save the default messages.yml
    public void saveDefaultMessages(){
        if (messagesFile == null) {
            messagesFile = new File(plugin.getDataFolder(), "messages.yml");
        }

        if (!messagesFile.exists()) {
            plugin.saveResource("messages.yml", false);
        }

        reloadConfig();
    }
}

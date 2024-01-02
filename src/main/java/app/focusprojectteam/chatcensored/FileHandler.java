package app.focusprojectteam.chatcensored;

// FileHandler.java

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileHandler {

    private final Main plugin;

    public FileHandler(Main plugin) {
        this.plugin = plugin;
    }

    public void setupConfig() {
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            plugin.saveResource("config.yml", false);
        }
    }

    public FileConfiguration getConfig() {
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        return YamlConfiguration.loadConfiguration(configFile);
    }
}



package hu.jgj52.libCats.Types;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public abstract class Configuration {
    private final File file;
    private FileConfiguration config;
    public Configuration() {
        file = new File(getPlugin().getDataFolder(), getName() + ".yml");
        reloadConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void saveConfig() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(file);
    }

    public abstract JavaPlugin getPlugin();
    public abstract String getName();
}

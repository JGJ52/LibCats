package hu.jgj52.libCats.Types;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class Configuration {
    private final File file;
    private FileConfiguration config;
    public Configuration() {
        file = new File(getPlugin().getDataFolder(), getName() + ".yml");
        reloadConfig();
        InputStream stream = getPlugin().getResource(getName() + ".yml");
        if (stream != null) {
            YamlConfiguration defaults = YamlConfiguration.loadConfiguration(new InputStreamReader(stream));
            YamlConfiguration already = YamlConfiguration.loadConfiguration(file);
            remove(defaults, already);
            getConfig().setDefaults(defaults);
        }
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    private void remove(ConfigurationSection defaults, ConfigurationSection already) {
        for (String key : already.getKeys(false)) {
            if (!already.isConfigurationSection(key)) {
                defaults.set(key, null);
            } else {
                ConfigurationSection defaultSection = defaults.getConfigurationSection(key);
                ConfigurationSection alreadySection = already.getConfigurationSection(key);
                if (defaultSection != null && alreadySection != null) {
                    remove(defaultSection, alreadySection);
                }
            }
        }
    }

    public final FileConfiguration getConfig() {
        return config;
    }

    public final void saveConfig() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(file);
    }

    public abstract JavaPlugin getPlugin();
    public abstract String getName();
}

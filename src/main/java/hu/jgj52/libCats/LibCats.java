package hu.jgj52.libCats;

import hu.jgj52.libCats.Listeners.ChatListener;
import hu.jgj52.libCats.Listeners.GUIListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class LibCats extends JavaPlugin {
    public static LibCats plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getPluginManager().registerEvents(new GUIListener(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

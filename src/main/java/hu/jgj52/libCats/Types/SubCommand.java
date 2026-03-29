package hu.jgj52.libCats.Types;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class SubCommand {
    public abstract String getName();
    public abstract boolean execute(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args, @Nullable Player player);
    public abstract List<String> complete(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args);
    public abstract boolean firstComplete(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args);

    public String getMsg(String msg) {
        return getPlugin().getConfig().getString("messages." + msg);
    }
    public abstract JavaPlugin getPlugin();
}

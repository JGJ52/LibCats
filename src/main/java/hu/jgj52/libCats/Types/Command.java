package hu.jgj52.libCats.Types;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class Command implements CommandExecutor, TabCompleter {
    @Override
    public final boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (noPermission() != null && !sender.hasPermission(getPermission())) {
            noPermission().accept(sender);
            return true;
        }
        if (notPlayer() != null && !(sender instanceof Player)) {
            notPlayer().accept(sender);
            return true;
        }

        if (args.length > 0) {
            for (SubCommand subCommand : getSubCommands()) {
                if (subCommand.getName().equals(args[0])) {
                    if (sender.hasPermission(getPermission() + "." + subCommand.getName())) {
                        return subCommand.execute(sender, command, s, args, notPlayer() != null ? (Player) sender : null);
                    }
                }
            }
        } else {
            return execute(sender, command, s, args, notPlayer() != null ? (Player) sender : null);
        }
        return true;
    }

    @Override
    public final @NonNull List<String> onTabComplete(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (noPermission() != null && !sender.hasPermission(getPermission())) {
            return List.of();
        }
        if (notPlayer() != null && !(sender instanceof Player)) {
            return List.of();
        }

        if (args.length == 1) {
            List<String> complete = new ArrayList<>();
            for (SubCommand subCommand : getSubCommands()) {
                complete.add(subCommand.getName());
            }
            return complete;
        } else if (args.length > 1) {
            for (SubCommand subCommand : getSubCommands()) {
                if (subCommand.getName().equals(args[0])) {
                    if (sender.hasPermission(getPermission() + "." + subCommand.getName())) {
                        return subCommand.complete(sender, command, s, args);
                    }
                }
            }
        }
        return List.of();
    }

    public abstract JavaPlugin getPlugin();
    public abstract String getName();
    public abstract List<SubCommand> getSubCommands();
    public void register() {
        PluginCommand command = getPlugin().getCommand(getName());
        if (command != null) {
            command.setExecutor(this);
            command.setTabCompleter(this);
        }
    }

    public Consumer<CommandSender> notPlayer() { return null; }

    public String getPermission() {
        return getPlugin().getName().toLowerCase() + ".command." + getName();
    }
    public Consumer<CommandSender> noPermission() { return null; }

    public abstract boolean execute(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args, @Nullable Player player);
}

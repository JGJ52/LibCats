package hu.jgj52.libCats.Types;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class SubCommand {
    public abstract String getName();
    public abstract boolean execute(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args, @Nullable Player player);
    public abstract List<String> complete(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args);
    public abstract boolean firstComplete(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args);

    public String getMsg(String msg) {
        return getPlugin().getConfig().getString("messages." + msg);
    }

    public Component getComp(String msg) {
        return MiniMessage.miniMessage().deserialize(getMsg(msg));
    }

    public Component getComp(String msg, boolean notItalic) {
        Component component = getComp(msg);
        if (!component.hasDecoration(TextDecoration.ITALIC) && notItalic) {
            return component.decoration(TextDecoration.ITALIC, false);
        }
        return component;
    }

    public List<String> getMsgList(String msg) {
        return getPlugin().getConfig().getStringList("messages." + msg);
    }

    public List<Component> getCompList(String msg) {
        List<Component> list = new ArrayList<>();
        for (String str : getMsgList(msg)) {
            list.add(MiniMessage.miniMessage().deserialize(str));
        }
        return list;
    }

    public List<Component> getCompList(String msg, boolean notItalic) {
        List<Component> components = getCompList(msg);
        int i = 0;
        for (Component component : components) {
            if (!component.hasDecoration(TextDecoration.ITALIC) && notItalic) {
                components.set(i, component.decoration(TextDecoration.ITALIC, false));
            }
            i++;
        }
        return components;
    }
    public abstract JavaPlugin getPlugin();
}

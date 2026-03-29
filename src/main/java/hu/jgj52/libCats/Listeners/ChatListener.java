package hu.jgj52.libCats.Listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import static hu.jgj52.libCats.LibCats.plugin;

public class ChatListener implements Listener {
    private record Context(Consumer<Component> consumer, String keyword) {}
    private static final Map<UUID, List<Context>> thingies = new ConcurrentHashMap<>();
    public static void add(Player player, Consumer<Component> consumer) {
        thingies.computeIfAbsent(player.getUniqueId(), uuid -> new ArrayList<>())
                .add(new Context(consumer, null));
    }

    public static void add(Player player, String keyword, Consumer<Component> consumer) {
        thingies.computeIfAbsent(player.getUniqueId(), uuid -> new ArrayList<>())
                .add(new Context(consumer, keyword));
    }
    @EventHandler
    public void onChat(AsyncChatEvent event) {
        if (thingies.containsKey(event.getPlayer().getUniqueId())) {
            String message = PlainTextComponentSerializer.plainText().serialize(event.originalMessage());
            List<Context> list = thingies.get(event.getPlayer().getUniqueId());
            List<Context> toRemove = new ArrayList<>();
            for (Context context : list) {
                String keyword = context.keyword();
                Consumer<Component> run = context.consumer();
                if (keyword == null) {
                    event.setCancelled(true);
                    Bukkit.getScheduler().runTask(plugin, () -> run.accept(event.originalMessage()));
                    toRemove.add(context);
                } else if (keyword.equals(message)) {
                    event.setCancelled(true);
                    Bukkit.getScheduler().runTask(plugin, () -> run.accept(event.originalMessage()));
                    toRemove.add(context);
                }
            }
            for (Context context : toRemove) {
                list.remove(context);
            }
        }
    }
}


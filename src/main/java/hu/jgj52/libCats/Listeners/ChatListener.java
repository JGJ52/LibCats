package hu.jgj52.libCats.Listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static hu.jgj52.libCats.LibCats.plugin;

public class ChatListener implements Listener {
    private record Context(Runnable runnable, String keyword) {}
    private static final Map<UUID, List<Context>> thingies = new ConcurrentHashMap<>();
    public static void add(Player player, Runnable runnable) {
        thingies.computeIfAbsent(player.getUniqueId(), uuid -> new ArrayList<>())
                .add(new Context(runnable, null));
    }

    public static void add(Player player, String keyword, Runnable runnable) {
        thingies.computeIfAbsent(player.getUniqueId(), uuid -> new ArrayList<>())
                .add(new Context(runnable, keyword));
    }
    @EventHandler
    public void onChat(AsyncChatEvent event) {
        if (thingies.containsKey(event.getPlayer().getUniqueId())) {
            String message = PlainTextComponentSerializer.plainText().serialize(event.originalMessage());
            List<Context> list = thingies.get(event.getPlayer().getUniqueId());
            for (Context context : list) {
                String keyword = context.keyword();
                Runnable run = context.runnable();
                if (keyword == null) {
                    event.setCancelled(true);
                    Bukkit.getScheduler().runTask(plugin, run);
                    list.remove(context);
                } else if (keyword.equals(message)) {
                    event.setCancelled(true);
                    Bukkit.getScheduler().runTask(plugin, run);
                    list.remove(context);
                }
            }
        }
    }
}


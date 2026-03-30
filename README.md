# LibCats
![Time](https://hackatime-badge.hackclub.com/U0922GMGGTU/LibCats?label=Time+I+spent+on+this)

### Short description
You can make GUIs, Commands (+ subcommands), and YAML files other than config.yml easier with this plugin.\
Also you can get these Paper Registry things easier\
You can also listen to the next message the player is sending in case you wanna get an input from them

### Build this yourself
```shell
git clone https://github.com/JGJ52/LibCats.git
cd LibCats
./gradlew build
```

### Include this in your project
```xml
<repositories>
    <repository>
        <id>jgj52-repo</id>
        <url>https://maven.jgj52.hu/repository/maven-releases/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>hu.jgj52</groupId>
        <artifactId>LibCats</artifactId>
        <version>1.3.4</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

### GUIs
```java
import hu.jgj52.libCats.Types.GUI;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

class YourGUI extends GUI {
    @Override
    public void init(Player player) {
        // when gui opens, this runs. set your items here
        // you can set them by
        gui.setItem(0, new ItemStack(Material.APPLE));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        // this gets called when player clicks on inventory
    }

    @Override
    public int getSize() {
        return 27; // size of the gui
    }

    @Override
    public JavaPlugin getPlugin() {
        return YourPlugin.getInstance();
    }

    // above this there were methods you NEED to override, or it won't work
    // these are optional

    @Override
    public @NotNull Inventory getInventory() {
        return super.getInventory(); // this is the bukkit inventory implementation override thing.
        // i don't know how to call it.
        // if you don't know what this is, or what this is for, you can ignore this and not override it.
    }

    @Override
    public String getMessage(String msg) {
        return super.getMessage(msg); // basically does
        getPlugin().getConfig().getString("guis." + getClass().getSimpleName() /* in this case YourGUI */ + "." + msg);
        // if you don't want to retrieve messages from there you can override this
        // if you are hardcoding every message you can ignore this
    }

    @Override
    public Component getComponent(String msg) {
        return super.getComponent(msg);
        // basically getMessage(msg) but this deserializes it with MiniMessage and makes it a component
        // if you changed where getMessage gets messages from this changes too
    }

    @Override
    public Component getComponent(String msg, boolean notItalic) {
        return super.getComponent(msg, notItalic); // this calls getComponent(msg) but if notItalic is true, puts on a decoration that says: its not italic
        // useful for getting names from items
    }

    @Override
    public List<String> getMessageList(String msg) {
        return super.getMessageList(msg); // same as getMessage but this gets a string list from config and not just a string. changing getMessage won't change where this gets messages from
    }

    @Override
    public List<Component> getComponentList(String msg) {
        return super.getComponentList(msg); // same as getComponent but with getMessageList
    }

    @Override
    public List<Component> getComponentList(String msg, boolean notItalic) {
        return super.getComponentList(msg, notItalic); // same again but list
    }

    @Override
    public String getMsg(String msg) {
        return super.getMsg(msg); // this gets it from
        getPlugin().getConfig().get("messages." + msg);
        // but same getMessage
    }

    @Override
    public Component getComp(String msg) {
        return super.getComp(msg); // same as getComponent but uses getMsg
    }

    @Override
    public Component getComp(String msg, boolean notItalic) {
        return super.getComp(msg, notItalic); // same again
    }

    @Override
    public List<String> getMsgList(String msg) {
        return super.getMsgList(msg); // same
    }

    @Override
    public List<Component> getCompList(String msg) {
        return super.getCompList(msg); // same
    }

    @Override
    public List<Component> getCompList(String msg, boolean notItalic) {
        return super.getCompList(msg, notItalic); // same
    }

    @Override
    public boolean defaultInit() {
        return super.defaultInit(); // puts black glass pane on the sides and gray glass pane elsewhere when true. true by default
    }

    @Override
    public void firstInit(Player player) {
        super.firstInit(player); // this only runs when the first init() runs
    }

    @Override
    public void onBottomClick(InventoryClickEvent event) {
        // same as onClick but now player clicked its inventory instead of the gui
    }

    @Override
    public void onClose(InventoryCloseEvent event) {
        // when the gui gets closed
    }

    @Override
    public void onDrop(PlayerDropItemEvent event) {
        // when player drops something while in the gui
    }

    @Override
    public void onMove(PlayerMoveEvent event) {
        // when player moves while in the gui
    }

    @Override
    public void onInteract(PlayerInteractEvent event) {
        // when player left/right clicks to a block for example while the gui is open
    }

    @Override
    public void onDrag(InventoryDragEvent event) {
        // when player drags something
        // similar to onClick but not the same
    }

    @Override
    public void onBottomDrag(InventoryDragEvent event) {
        // same as onBottomClick but onDrag
    }

    @Override
    public Component getName() {
        return super.getName(); // by default getComponent("name");
    }
    
    public void voidd() {
        // you can open this using 
        new YourGUI().open(player);
    }
}
```
### Commands
```java
import hu.jgj52.libCats.Types.Command;
import hu.jgj52.libCats.Types.SubCommand;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

class YourCommand extends Command {
    // im gonna assume your already read GUI
    @Override
    public JavaPlugin getPlugin() {
        return YourPlugin.getInstance();
    }

    @Override
    public String getName() {
        return "myCommand"; // your gonna use /myCommand for this one in-game
    }

    @Override
    public List<SubCommand> getSubCommands() {
        return List.of(
                new YourSubCommand()
        );
    }

    @Override
    public Consumer<CommandSender> notPlayer() {
        return sender -> {
            // if set, they cant run this command if they're not a player, and this gets run when they try to
            // you can send them "hi you need to be a player to run this" here
        };
    }

    // these 6 are the same as in GUI
    @Override
    public String getMsg(String msg) {
        return super.getMsg(msg);
    }

    @Override
    public List<Component> getCompList(String msg, boolean notItalic) {
        return super.getCompList(msg, notItalic);
    }

    @Override
    public List<Component> getCompList(String msg) {
        return super.getCompList(msg);
    }

    @Override
    public List<String> getMsgList(String msg) {
        return super.getMsgList(msg);
    }

    @Override
    public Component getComp(String msg, boolean notItalic) {
        return super.getComp(msg, notItalic);
    }

    @Override
    public Component getComp(String msg) {
        return super.getComp(msg);
    }

    @Override
    public String getPermission() {
        // the permission required to run this command
        // by default its
        return getPlugin().getName().toLowerCase() + ".command." + getName();
    }

    @Override
    public Consumer<CommandSender> noPermission() {
        return sender -> {
            // if set, they cant run the command without having the permission in getPermission, and if they try to
            // then this code gets run
        };
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args, @Nullable Player player) {
        // when they run the command without args this gets run.
        // if you set notPlayer(), then player isn't null
        // you must override this
        return true;
    }
}
```

```java
import hu.jgj52.libCats.Types.SubCommand;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

class YourSubCommand extends SubCommand {
    @Override
    public String getName() {
        return "hello"; // with the previous command, this becomes /myCommand hello
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args, @Nullable Player player) {
        // when "/myCommand hello" gets run this runs also
        // if its "/myCommand hello otherArg" this gets run too and otherArg is args[1]
        return true;
    }

    @Override
    public List<String> complete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        return List.of(); // "/myCommand hello <from here gets listed>"
    }

    @Override
    public boolean firstComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        // should you be able to tab it from /myCommand <fromHere> (true) or no (false)
        return true;
    }

    // this six again
    @Override
    public List<Component> getCompList(String msg, boolean notItalic) {
        return super.getCompList(msg, notItalic);
    }

    @Override
    public List<Component> getCompList(String msg) {
        return super.getCompList(msg);
    }

    @Override
    public List<String> getMsgList(String msg) {
        return super.getMsgList(msg);
    }

    @Override
    public Component getComp(String msg, boolean notItalic) {
        return super.getComp(msg, notItalic);
    }

    @Override
    public Component getComp(String msg) {
        return super.getComp(msg);
    }

    @Override
    public String getMsg(String msg) {
        return super.getMsg(msg);
    }

    @Override
    public JavaPlugin getPlugin() {
        return YourPlugin.getInstance();
    }
}
```

### Configurations
```java
import hu.jgj52.libCats.Types.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

class YourConfiguration extends Configuration {
    @Override
    public JavaPlugin getPlugin() {
        return YourPlugin.getInstance();
    }

    @Override
    public String getName() {
        return "messages"; // the name of the yml
    }
}
```

### RegistryFromName
```java
import hu.jgj52.libCats.Utils.RegistryFromName;
import org.bukkit.enchantments.Enchantment;

class YourClass {
    public void run() {
        Enchantment sharpness = RegistryFromName.ENCHANTMENT("sharpness");
        List<Enchantment> all = RegistryFromName.ENCHANTMENT();
    }
}
```

### Chat
```java
import hu.jgj52.libCats.Listeners.ChatListener;

class YourClass {
    public void run() {
        // when any value is good
        ChatListener.add(player, message -> {
            // print it
            System.out.println(message);
            // send it back for fun
            player.sendMessage(message);
        });
        // when you wait for a specific value
        // for example "done"
        ChatListener.add(player, "done", message -> {
            System.out.println(player.getName() + " said done!");
        });
    }
}
```
package srbigos.main;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import srbigos.main.events.Entrada;

public final class Main extends JavaPlugin {
    ConsoleCommandSender mycmd = Bukkit.getConsoleSender();
    public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        mycmd.sendMessage("§9BIG-HubCore§8: §9Cargando los eventos...");
        getServer().getPluginManager().registerEvents(new Entrada(this), this);
        mycmd.sendMessage("§aEl §9BIG-HubCore §ase ha cargado correctamente");

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        mycmd.sendMessage("§cEl §9BIG-HubCore §cse ha apagado correctamente");
    }
}

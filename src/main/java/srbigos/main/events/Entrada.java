package srbigos.main.events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import srbigos.main.Main;

import java.util.Objects;

public class Entrada implements Listener {
    public Main main;
    public Entrada(Main main) {
        this.main = main;
    }
    @EventHandler
    public void Entrada(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        FileConfiguration config = main.getConfig();
        if (Objects.equals(config.getString("CustomJoinMessage.enable"), "true") ) {
            if(p.hasPermission(config.getString("CustomJoinMessage.custom1.permission"))){
                e.setJoinMessage("§a"+config.getString("CustomJoinMessage.custom1.message"));

            } else {
                e.setJoinMessage("§8"+config.getString("CustomJoinMessage.default.message"));
            }
        }
    }
}

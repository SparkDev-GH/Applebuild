package eu.apple.applebuild.listeners;

import eu.apple.applebuild.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Main.getInstance().loadPlayerData();

    }
}

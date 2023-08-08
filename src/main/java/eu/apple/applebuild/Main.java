package eu.apple.applebuild;

import eu.apple.applebuild.config.Config;
import eu.apple.applebuild.commands.ConfigTestCMDExecutor;
import eu.apple.applebuild.config.interfaces.PlayerConfig;
import eu.apple.applebuild.listeners.BlockBreakListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Main extends JavaPlugin {

    static private Main instance;

    public static Main getInstance() {
        return instance;
    }

    public Config getConfiguration() {
        return config;
    }

    private Config config;

    private Map<String, PlayerConfig> playerData;

    public void loadPlayerData() {
        saveData();

        playerData = new HashMap<>();

        ArrayList<Player> onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());

        for (Player p : onlinePlayers) {

            PlayerConfig data = new PlayerConfig();

            data.name = p.getName();
            if (config.getConfig().contains("playerData."+data.name)) {
                data.rankName = config.getConfig().getString("playerData." + data.name + ".rankName");
                data.rankID = config.getConfig().getInt("playerData." + data.name + ".rankID");
            } else {
                config.getConfig().set("playerData."+data.name+".name", data.name);
                config.getConfig().set("playerData."+data.name+".rankName", "player");
                config.getConfig().set("playerData."+data.name+".rankID", 0);
            }
            playerData.put(p.getName(), data);
        }

    }
    public void loadPlayerData(String player) {
        saveData();

        if (Bukkit.getPlayer(player) == null) {
            return;
        }

        playerData = new HashMap<>();

        PlayerConfig data = new PlayerConfig();

        data.name = player;
        if (config.getConfig().contains("playerData."+data.name)) {
            data.rankName = config.getConfig().getString("playerData." + data.name + ".rankName");
            data.rankID = config.getConfig().getInt("playerData." + data.name + ".rankID");
        } else {
            config.getConfig().set("playerData."+data.name+".name", data.name);
            config.getConfig().set("playerData."+data.name+".rankName", "player");
            config.getConfig().set("playerData."+data.name+".rankID", 0);
        }
        playerData.put(player, data);
    }

    @Override
    public void onLoad() {
        // Plugin loading logic

        instance = this;
        config = new Config();

    }

    @Override
    public void onEnable() {

        PluginManager manager = Bukkit.getPluginManager();

        manager.registerEvents(new BlockBreakListener(), this);

        Objects.requireNonNull(getCommand("ConfigTest")).setExecutor(new ConfigTestCMDExecutor());

        // Plugin startup logic
        for (Player p: Bukkit.getOnlinePlayers()) {
            p.sendMessage("der server wurde erfolgreich neugestartet.");
        }

        // loadPlayerData();

        new BukkitRunnable() {
            @Override
            public void run() {
                saveData();
            }
        }.runTaskTimer(this, 6000, 6000);
    }

    public void saveData() {

        // debug
        Objects.requireNonNull(Bukkit.getPlayer("SparkDev")).sendMessage("Saving data..");
        playerData.forEach((k, v) -> {
            config.getConfig().set("playerData."+v.name+".name", v.name);
            config.getConfig().set("playerData."+v.name+".rankName", v.rankName);
            config.getConfig().set("playerData."+v.name+".rankID", v.rankID);
        });
        config.save();
    }
    @Override
    public void onDisable() {
        saveData();
    }
}

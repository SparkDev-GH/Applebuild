package eu.apple.applebuild.gungame;

import org.bukkit.entity.Player;

import java.util.Map;

public class GunGame {
    private static GunGame instance;

    int player_count;

    public int getPlayer_count() {
        return player_count;
    }

    public void setPlayer_count(int player_count) {
        this.player_count = player_count;
    }

    public GunGame getInstance() {
        return instance;
    }

    public Map<String, Player> getPlayerMap() {
        return playerMap;
    }

    public Map<String, GunGamePlayerData> getPlayerDataMap() {
        return playerDataMap;
    }

    Map<String, Player> playerMap;
    Map<String, GunGamePlayerData> playerDataMap;

    public GunGame() {
        instance = this;
        player_count = 0;
    }

}















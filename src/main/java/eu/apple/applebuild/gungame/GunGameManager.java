package eu.apple.applebuild.gungame;

import org.bukkit.entity.Player;

public class GunGameManager {

    GunGame gungame;

    public GunGameManager(GunGame gg) {
        this.gungame = gg;
    }


    public boolean join(Player p) {

        if (gungame.getPlayerMap().containsKey(p.getName())) return false;

        gungame.player_count++;
        gungame.getPlayerMap().put(p.getName(), p);
        gungame.getPlayerDataMap().put(p.getName(), new GunGamePlayerData());



        return true;
    }

    public boolean leave(Player p) {

        if (!gungame.getPlayerMap().containsKey(p.getName())) return false;

        gungame.player_count--;
        gungame.getPlayerMap().remove(p.getName(), p);
        gungame.getPlayerDataMap().remove(p.getName());

        return true;
    }
}

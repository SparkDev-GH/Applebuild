package eu.apple.applebuild.gungame;

public class GunGamePlayerData {
    public int kills;
    public int level;
    public int maxLevel;

    public GunGamePlayerData() {

        //@todo LOAD DATA FROM CONFIG
        kills = 0;
        level = 0;
        maxLevel = 0;

    }
}

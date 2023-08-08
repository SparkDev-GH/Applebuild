package eu.apple.applebuild.config.interfaces;

public interface RankConfig {

    /**
     * @return Integer - Returns an integer indicating the permission. Ranges from 0 to 4, where 0 is the lowest permission.;
     */
    Integer permissionLevel();

    /**
     * @return String - Returns the name of the Rank;
     */
    String name();

    /**
     * @return String - Returns the name of the color that the name has;
     */
    String nameColor();

}

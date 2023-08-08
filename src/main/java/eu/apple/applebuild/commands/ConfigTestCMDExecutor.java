package eu.apple.applebuild.commands;

import eu.apple.applebuild.Main;
import eu.apple.applebuild.config.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ConfigTestCMDExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Config config = Main.getInstance().getConfiguration();

        commandSender.sendMessage("" + config.getConfig().getInt("test.x"));


        return false;
    }
}

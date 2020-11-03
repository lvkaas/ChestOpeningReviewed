package de.torbusentwicklus.chestopening;

import de.torbusentwicklus.chestopening.api.mysql.MySqlConnection;
import de.torbusentwicklus.chestopening.api.provider.ChestOpeningProvider;
import de.torbusentwicklus.chestopening.api.provider.ConfigProvider;
import de.torbusentwicklus.chestopening.commands.ChestOpeningCommandExecutor;
import de.torbusentwicklus.chestopening.commands.ChestOpeningCommandImpl;
import de.torbusentwicklus.chestopening.listener.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public class ChestOpeningPlugin extends JavaPlugin {

    private final ConfigProvider configProvider = new ConfigProvider(getConfig());
    private final MySqlConnection mySqlConnection = new MySqlConnection(configProvider.getMySqlCredentialsFromFile());

    @Override
    public void onEnable() {
        ChestOpeningProvider chestOpeningProvider = new ChestOpeningProvider(mySqlConnection);

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(chestOpeningProvider), this);
        getCommand("chestOpening").setExecutor(new ChestOpeningCommandExecutor(new ChestOpeningCommandImpl(chestOpeningProvider)));
    }

    @Override
    public void onDisable() {
        try {
            mySqlConnection.disconnect();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}

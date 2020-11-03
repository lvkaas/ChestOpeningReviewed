package de.torbusentwicklus.chestopening.api.provider;

import de.torbusentwicklus.chestopening.api.mysql.MySqlCredentials;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;

@Getter
@AllArgsConstructor
public class ConfigProvider {

    private final FileConfiguration fileConfiguration;

    public MySqlCredentials getMySqlCredentialsFromFile() {
        setConfigDefaults();
        return readFromFile();
    }

    private void setConfigDefaults() {
        fileConfiguration.addDefault("mysql.hostName", "hostName");
        fileConfiguration.addDefault("mysql.database", "database");
        fileConfiguration.addDefault("mysql.userName", "userName");
        fileConfiguration.addDefault("mysql.password", "password");
        fileConfiguration.addDefault("mysql.port", "port");
    }

    private MySqlCredentials readFromFile() {
        return new MySqlCredentials(fileConfiguration.getString("mysql.hostName"),
                fileConfiguration.getString("mysql.database"),
                fileConfiguration.getString("mysql.userName"),
                fileConfiguration.getString("mysql.password"),
                fileConfiguration.getInt("mysql.port"));
    }

}

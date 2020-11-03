package de.torbusentwicklus.chestopening.api.mysql;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RequiredArgsConstructor
public class MySqlConnection {

    private final MySqlCredentials mySqlCredentials;

    @Getter
    private Connection connection;


    public void connect() throws SQLException {
        if (isConnected()) return;
        connection = DriverManager.getConnection("jdbc:mysql://" + mySqlCredentials.getHostName() + ":" + mySqlCredentials.getPort() + "/" +
                mySqlCredentials.getDatabase(), mySqlCredentials.getUserName(), mySqlCredentials.getPassword());
        createTables();
    }

    public void disconnect() throws SQLException {
        if (!isConnected()) return;
        connection.close();
    }

    private void createTables() throws SQLException {
        performStatement("CREATE TABLE IF NOT EXISTS items (ID INTEGER NOT NULL AUTO_INCREMENT, BASE64 VARCHAR(5000), RARITY INTEGER, PRIMARY KEY(ID));");
        performStatement("CREATE TABLE IF NOT EXISTS owning (UNIQUEID VARCHAR(64), ID INTEGER);");
        performStatement("CREATE TABLE IF NOT EXISTS players (UNIQUEID VARCHAR(64), CHESTS INTEGER);");
    }

    public boolean isConnected() {
        return connection != null;
    }

    private void performStatement(String tableDefinition) throws SQLException {
        connection.prepareStatement(tableDefinition).executeUpdate();
    }

}

package de.torbusentwicklus.chestopening.api.mysql;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MySqlCredentials {

    private final String hostName;
    private final String database;
    private final String userName;
    private final String password;

    private final int port;

}

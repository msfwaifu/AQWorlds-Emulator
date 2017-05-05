package com.aqworlds.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigData {

    public String DB_HOST;
    public String DB_NAME;
    public String DB_USERNAME;
    public String DB_PASSWORD;
    public int DB_PORT;
    public int DB_MAX_CONNECTIONS;
    public String SERVER_NAME;
    public boolean STAFF_ONLY;

    public boolean init() {
        try {
            this.load();
        } catch (IOException error) {
            return false;
        }
        return true;
    }

    private void load() throws IOException {
        Properties config = new Properties();
        config.load(new FileInputStream("conf/config.conf"));
        this.DB_HOST = config.getProperty("database.host");
        this.DB_USERNAME = config.getProperty("database.user");
        this.DB_PASSWORD = config.getProperty("database.pass");
        this.DB_NAME = config.getProperty("database.name");
        this.DB_PORT = Integer.parseInt(config.getProperty("database.port"));
        this.DB_MAX_CONNECTIONS = Integer.parseInt(config.getProperty("database.connections.max"));
        this.SERVER_NAME = config.getProperty("server.name");
        this.STAFF_ONLY = Boolean.parseBoolean(config.getProperty("server.staffonly"));
    }
}

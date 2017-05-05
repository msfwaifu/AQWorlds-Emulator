package com.aqworlds.database;

import com.aqworlds.config.ConfigData;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import jdbchelper.ConnectionPool;
import jdbchelper.JdbcHelper;
import jdbchelper.PooledDataSource;

public class Database {

    private MysqlConnectionPoolDataSource datasource;
    private ConfigData config;
    private ConnectionPool pool;
    private JdbcHelper jdbc;

    public Database(ConfigData config) {
        this.datasource = new MysqlConnectionPoolDataSource();
        this.config = config;
    }

    public boolean connect() {
        try {
            this.datasource.setServerName(this.config.DB_HOST);
            this.datasource.setPort(this.config.DB_PORT);
            this.datasource.setUser(this.config.DB_USERNAME);
            this.datasource.setPassword(this.config.DB_PASSWORD);
            this.datasource.setDatabaseName(this.config.DB_NAME);
            this.datasource.setAutoReconnectForConnectionPools(true);
            this.pool = new ConnectionPool(this.datasource, config.DB_MAX_CONNECTIONS);
            this.jdbc = new JdbcHelper(new PooledDataSource(this.pool));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public JdbcHelper getPool() {
        return this.jdbc;
    }
}

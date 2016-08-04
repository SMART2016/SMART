package com.smart.data.datasource;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.smart.Exception.DataSourceException;
import com.smart.log.LogFactory;
import com.smart.log.Logger;
import com.smart.util.PropertyUtil;
import oracle.jdbc.pool.OracleDataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * Created by dipanjan on 19/03/16.
 */
public class DataSourceFactory {
    private static final String DB_PROPERTY_FILE = "db.properties";

    private static final String MANDATORY_DB_PROPERTY = "DB_TYPE";

    private static final Logger log = LogFactory.getLogger(DataSourceFactory.class);

    private DataSourceFactory() {
    }

    /**
     * @return
     * @should load the property file
     * @should throw DataSourceException for DB_TYPE
     * @should return proper datasource
     */
    public static DataSource getDataSource() {
        Properties props = PropertyUtil.getProperties(DB_PROPERTY_FILE);
        String dbType = getDBTypeFrmProperty(props);
        return getDatasourceInstance(dbType.toLowerCase(), props);
    }


    /**
     * @param dbType
     * @param property
     * @return
     */
    private static DataSource getDatasourceInstance(String dbType, Properties property) {

        switch (dbType) {
            case "mysql":
                return getMySQLDataSource(property);
            case "oracle":
                return getOracleDataSource(property);
            default:
                log.error(dbType + " Invalid for fetching proper datasource");
                throw new DataSourceException(dbType + " Invalid for fetching proper datasource");
        }
    }

    private static String getDBTypeFrmProperty(Properties property) {
        if (property != null && !property.isEmpty() && property.containsKey(MANDATORY_DB_PROPERTY)) {
            return property.getProperty(MANDATORY_DB_PROPERTY);
        } else {
            log.error("DB_TYPE property not found Invalid properties file");
            throw new DataSourceException("DB_TYPE property not found Invalid properties file");
        }
    }

    public static Properties getDBProperties() {
        return PropertyUtil.getProperties(DB_PROPERTY_FILE);
    }

    public static DataSource getMySQLDataSource(Properties property) {

        MysqlDataSource mysqlDS = new MysqlDataSource();
        mysqlDS.setURL(property.getProperty("MYSQL_DB_URL"));
        mysqlDS.setUser(property.getProperty("MYSQL_DB_USERNAME"));
        mysqlDS.setPassword(property.getProperty("MYSQL_DB_PASSWORD"));

        return mysqlDS;
    }

    public static DataSource getOracleDataSource(Properties property) {

        OracleDataSource oracleDS = null;
        try {
            oracleDS = new OracleDataSource();
        } catch (SQLException e) {
            throw new DataSourceException(e.getMessage());
        }
        oracleDS.setURL(property.getProperty("ORACLE_DB_URL"));
        oracleDS.setUser(property.getProperty("ORACLE_DB_USERNAME"));
        oracleDS.setPassword(property.getProperty("ORACLE_DB_PASSWORD"));
        return oracleDS;
    }
}

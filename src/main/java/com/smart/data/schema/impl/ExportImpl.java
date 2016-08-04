package com.smart.data.schema.impl;

import com.smart.Exception.SchemaExportException;
import com.smart.data.datasource.DataSourceFactory;
import com.smart.data.schema.Export;
import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.io.DatabaseIO;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by dipanjan on 19/03/16.
 */
public class ExportImpl implements Export {
    private static final String FILE_PATH_PREFIX="src/main/resources/";
    private static final DataSource ds = DataSourceFactory.getDataSource();

    public static void exportDBSchemaToXml() {
        String dbToExport = getDBToExportFrmProperty();
        if(dbToExport != null) {
            Platform platform = PlatformFactory.createNewPlatformInstance(ds);
            new DatabaseIO().write(platform.readModelFromDatabase(dbToExport), FILE_PATH_PREFIX+dbToExport + ".xml");
        }
    }

    private static String getDBToExportFrmProperty() {
        Properties dbProps = DataSourceFactory.getDBProperties();
        if(dbProps != null) {
            return DataSourceFactory.getDBProperties().getProperty("DB_TO_EXPORT");
        }else{
            throw new SchemaExportException("DB_TO_EXPORT is not set properly");
        }
    }

    public static void main(String[] args){
        exportDBSchemaToXml();
    }
}

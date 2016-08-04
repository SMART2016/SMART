package com.smart.util;


import com.smart.Exception.PropertLoadException;
import com.smart.data.datasource.DataSourceFactory;
import com.smart.log.LogFactory;
import com.smart.log.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyUtil {

    private static final Logger log = LogFactory.getLogger(PropertyUtil.class);

    private PropertyUtil(){}
    public static Properties getProperties(String propertyFileName) {
        Properties props = null;
        try {
            props = loadProperty(propertyFileName);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new PropertLoadException(e.getMessage());
        }
        return props;
    }

    public static Properties loadProperty(String dbPropertyFileName) throws IOException {
        InputStream is;
        Properties property = new Properties();
        if (isPropertyPathValid(dbPropertyFileName)) {
            try {
                is = DataSourceFactory.class.getClassLoader().getResourceAsStream(dbPropertyFileName);
            } catch (Exception e) {
                throw new IOException("property file stream cannot be initialized..");
            }
            if (is != null) {
                try {
                    property.load(is);
                } catch (IOException e) {
                    throw new IOException("DB property file load error");
                }
            }
            return property;

        } else {
            throw new FileNotFoundException(dbPropertyFileName + " is not a valid filename");
        }
    }

    private static boolean isPropertyPathValid(String dbPropertyFileName) {
        return dbPropertyFileName != null && !dbPropertyFileName.isEmpty();
    }
}
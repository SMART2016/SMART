package com.smart.data.schema.converter;


import com.smart.Exception.JsonConvertionException;
import com.smart.log.LogFactory;
import com.smart.log.Logger;
import com.smart.util.PropertyUtil;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by dipanjan on 26/03/16.
 */
public final class XmlSchemaToJsonConveter {
    private static final Logger log = LogFactory.getLogger(XmlSchemaToJsonConveter.class);
    private static final String FILE_PATH_PREFIX="src/main/resources/";
    private static final String CONVERSION_PROPERTY_FILE = "convertion.properties";
    private static final String XML_TO_CONVERT = "XMLTOCONVERT";

    private XmlSchemaToJsonConveter() {
    }

    private static class Holder {
        private static final XmlSchemaToJsonConveter instance = new XmlSchemaToJsonConveter();
    }

    public static XmlSchemaToJsonConveter getInstance() {
        return Holder.instance;
    }

    public JSONObject getJson() {
        InputStream inputStream = null;
        String xmlFileToConvert = getXmlFileToConvert();
        if(xmlFileToConvert != null && !xmlFileToConvert.isEmpty()) {
            try {
                inputStream = XmlSchemaToJsonConveter.class.getClassLoader().getResourceAsStream(xmlFileToConvert);
                String xml = IOUtils.toString(inputStream);
                JSONObject jsonObject = XML.toJSONObject(xml);
                return jsonObject;
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                throw new JsonConvertionException("XML conversion to JSON failed for file: [ " + xmlFileToConvert + " ]", e);
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException ex) {
                    log.error(ex.getMessage(), ex);
                }
            }
        }else{
            log.error("No XML file path defined in the convertion.properties");
            throw new JsonConvertionException("No XML file path defined in the convertion.properties");
        }
    }

    public void writeFormattedJsonTofile(JSONObject jsonObject) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Object json = mapper.readValue(jsonObject.toString(), Object.class);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH_PREFIX+"Test.json"), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getXmlFileToConvert() {
        Properties props = PropertyUtil.getProperties(CONVERSION_PROPERTY_FILE);
        if (props != null && !props.isEmpty() && props.containsKey(XML_TO_CONVERT)) {
            return props.getProperty(XML_TO_CONVERT);
        } else {
            log.error("XMLTOCONVERT property not found ");
            throw new JsonConvertionException(XML_TO_CONVERT + " property not found or proprty file is corrupt");
        }
    }

    public static void main(String[] args) {
        log.info("Starting execution");
        Holder.instance.writeFormattedJsonTofile(Holder.instance.getJson());
    }
}

package com.dastan.utilities;

import com.dastan.constants.FrameworkConstants;
import com.dastan.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils() {
    }

    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAG = new HashMap<>();

    static {
        try {

            FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());
            property.load(file);

            for(Map.Entry<Object,Object> entry: property.entrySet()){
                CONFIGMAG.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String get(ConfigProperties key) throws Exception {
        if(Objects.isNull(key) || Objects.isNull(CONFIGMAG.get(key.name().toLowerCase()))){
            throw new Exception("Property name " + key + " is not found. Please check config.properties");
        }
        return CONFIGMAG.get(key.name().toLowerCase());
    }

}

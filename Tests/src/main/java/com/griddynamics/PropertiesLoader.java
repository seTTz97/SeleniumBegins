package com.griddynamics;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertiesLoader {
    public static String loadChosenProperty(String chosenProperty){
        PropertiesConfiguration config = new PropertiesConfiguration();
        String property = "";
        try{
            config.load("application.properties");
            property = config.getString(chosenProperty);
        }catch (ConfigurationException e){
            e.getMessage();
        }
        return property;
    }
}

package com.travelers.helpers;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;



public class PropertyLoader {

    public static PropertiesConfiguration loadProperties() throws ConfigurationException {
        Configurations configs = new Configurations();
        //PropertiesConfiguration config = configs.properties("src//main//resources//test.properties");
        //config.getString("driver");
        //config.getString("isDev");
        return configs.properties("src//main//resources//test.properties");
    }

    public static void main(String[] args) throws ConfigurationException {

        PropertiesConfiguration config = loadProperties();
        System.out.println(config.getString("driver"));
        System.out.println(config.getString("isDev"));
    }
}

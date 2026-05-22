package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesReader {

    public static String getConfigProperty(String property){
        String value = "";
        try{
            FileReader configFile = new FileReader(System.getProperty("user.dir")+"/src/test/java/resources/config.properties");
            Properties prop = new Properties();
            prop.load(configFile);
            value = prop.getProperty(property);
            configFile.close();
        }
        catch (IOException e){
            System.out.println("Error reading config.properties file -> " + e.getMessage());
        }
        return value;
    }
}

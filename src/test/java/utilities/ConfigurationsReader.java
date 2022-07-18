package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationsReader {

    static Properties properties;


static{
    String path = "configurations.properties";

    try {
        FileInputStream fis= new FileInputStream(path);
        properties=new Properties();
        try {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }


    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

}

    public static String getProperty(String key){
    return properties.getProperty(key);

    }


}
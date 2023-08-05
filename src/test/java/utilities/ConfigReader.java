package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {/**
 * This class reads Configurations.Properties file.
 * The method getProperty(String key) fetches the values from Configurations.properties file
 * Using the key provided as a parameter
 *
 */

private static FileInputStream input;
    private static Properties properties;


    static {
        /*
        Path to the Configurations.properties file
         */
        String path = System.getProperty("user.dir")+"/src/test/resources/configurations/Configuration.properties";
        try {
            // FileInputStream gets the file from provided path.
            input = new FileInputStream(path);
            properties= new Properties();
            properties.load(input);
        } catch (FileNotFoundException e) {
            System.out.println("Path for properties is invalid");
        } catch (IOException e) {
            System.out.println("Failed to load the properties file");;
        } finally {
            try {
                assert input != null;
                input.close();
            } catch (IOException e) {
                System.out.println("Exception occurred when trying to close input object");
            }
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }



}



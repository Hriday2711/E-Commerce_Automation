package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class DataProvider {

    /**
     * propertyFilePath: This is just a String variable which holds the information of the config file path
     * new FileReader(propertyFilePath): Creates a new FileReader, given the name of the file to read from
     * new BufferedReader(new FileReader(propertyFilePath)): Reads text from a character-input stream, buffering characters so as to provide for
     * the efficient reading of characters, arrays and lines
     * new Properties(): The Properties class represents a persistent set of properties. The Properties can be saved to a stream or loaded from a stream.
     * Each key and its corresponding value in the property list is a string.
     * properties.load(reader): Reads a property list (key and element pairs) from the input character stream in a simple line-oriented format.
     */
    private Properties properties;
    private final String propertyFilePath = "config/application.properties";


    public DataProvider(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("application.properties not found at " + propertyFilePath);
        }
    }

    /**
     * This method will help to get the browser from the application-config file
     * @return - browser from the app-config file
     */
    public String getBrowser(){
        String browser = properties.getProperty("browser");
        if(browser!= null) return browser;
        else throw new RuntimeException("Browser not specified in the application.properties file.");
    }

    /**
     * This method will help to get the default implicit wait time which will be applied for all the automation scripts
     *
     * @return - the time in seconds for implicit wait
     */
    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    /**
     * This method will help to get the web-application url for the automation test
     * @return - the application url in string format
     */
    public String getApplicationUrl() {
        String url = properties.getProperty("applicationURL");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
}

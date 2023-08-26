package utils;

import com.github.javafaker.Faker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;
import java.util.Random;

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
    private static Properties properties;
    private final String propertyFilePath = "config/application.properties";
    private static Faker faker;


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

    public static String getRemoteServerURL(){
        String remoteServerURL = properties.getProperty("remoteServerURL");
        if(remoteServerURL!=null) return remoteServerURL;
        else throw new RuntimeException("Remote Server URL is not defined. Please check the application.properties file.");
    }

    public static String getBrowserVersion(){
        String remoteBrowserVersion = properties.getProperty("browserVersion");
        if(remoteBrowserVersion!=null) return remoteBrowserVersion;
        else throw new RuntimeException("Remote Browser Version is not defined. Please check application.properties file.");
    }

    public static String getRemoteServerUserName(){
        String remoteServerUserName = properties.getProperty("remoteServerUserName");
        if(remoteServerUserName!=null) return  remoteServerUserName;
        else throw new RuntimeException("Remote server user-name is not defined in application.properties file.");
    }

    public static String getRemoteServerAccessKey(){
        String remoteServerAccessKey = properties.getProperty("remoteServerAccessKey");
        if(remoteServerAccessKey!=null) return remoteServerAccessKey;
        else throw new RuntimeException("Remote server access key is not defined in application.properties file.");
    }

    public static String getRemoteServerBuild(){
        String remoteServerBuild = properties.getProperty("remoteServerBuild");
        if(remoteServerBuild!=null) return remoteServerBuild;
        else throw new RuntimeException("Remote Server Build is not defined in application.properties file");
    }

    public static String getPlatformName(){
        String platformName = properties.getProperty("platformName");
        if(platformName!=null) return platformName;
        else throw new RuntimeException("Platform Name is not defined in application.properties file");
    }

    public static String getRemoteServerTestName(){
        String remoteServerTestName = properties.getProperty("remoteServerTestName");
        if(remoteServerTestName!=null) return remoteServerTestName;
        else throw new RuntimeException("Remote server test name is not defined in application.properties file.");
    }

    /**
     * Method to get a random full Name for automation test
     * @return - Full Name in the form of string
     * @throws Exception
     */
    public static String getRandomFullName() throws Exception {
        faker = new Faker();
        return faker.name().fullName();
    }

    /**
     * Method to get a random email for automation test
     * @return - Email in form of String
     * @throws Exception
     */
    public static String getRandomEmail() throws Exception {
        faker = new Faker();
        return faker.internet().emailAddress();
    }

    /**
     * Method to get a Random integer which we can use in our automation test within a range
     * @param min - base value of the range within which you need an integer
     * @param max - maximum value of the range within which you need an integer
     * @return
     * @throws Exception
     */
    public static int getRandomInt(int min, int max) throws Exception {
        faker = new Faker();
        return faker.number().numberBetween(min, max);
    }

    public static String getCompanyName() throws Exception {
        faker = new Faker();
        return faker.company().name();
    }

    public static String getRandomAddress() throws Exception {
        faker = new Faker();
        return faker.address().streetAddress();
    }

    public static String getRandomStateName() throws Exception {
        faker = new Faker();
        return faker.address().state();
    }

    public static String getRandomCityName() throws Exception {
        faker = new Faker();
        return faker.address().cityName();
    }

    public static String getRandomZipCode() throws Exception {
        faker = new Faker();
        return faker.address().zipCode();
    }

    public static String getRandomMobileNumber() throws Exception {
        faker = new Faker();
        return faker.phoneNumber().cellPhone();
    }
}

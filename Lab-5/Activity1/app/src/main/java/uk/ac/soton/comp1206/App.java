package uk.ac.soton.comp1206;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is the App class which acts as the main class for the application
 *
 */
public class App {

    private static final Logger logger = LogManager.getLogger("HelloWorld");

    /**
     * This is the main method which prints out 'Hello World!'
     * @param args command line arguments passed into the main method
     */
    public static void main( String[] args )
    {
        logger.info("about the say hello world");
        System.out.println( "Hello World!" );
        logger.info("we said hello world");
    }
}

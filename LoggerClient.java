import java.io.*;
import java.util.logging.*;
import java.net.*;
import java.util.*;
import java.sql.Timestamp; 

public class LoggerClient  {
    private static String ipAddr;
    private static final String LOGFILE = "simplefss-logs.txt";
    private static final Logger LOGGER = Logger.getLogger( LoggerClient.class.getName() );
    private static SimpleFormatter formatter;
    private static FileHandler fh;

    public LoggerClient() throws Exception { super(); }

    /**
     * Initialzied the logger as soon as the object is created.
     * This sets up the file handler which is used to send the logs to the
     * LOGFILE instead of simply the console. It also starts up the
     * formatter so that the logs are readable in the text file
     */
    static{
        try {
            // file to write the logs to
            fh = new FileHandler(LOGFILE, true);

            // helps to format the log messages to appropriate format
            formatter = new SimpleFormatter();  
            fh.setFormatter(formatter); 

            // stops log from being outputted to console
            //LOGGER.setUseParentHandlers(false);

            // adds the log file as a handler so that output is sent here
            LOGGER.addHandler(fh);

            // gets the handlers associated with the logger object
            LOGGER.getHandlers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Logs the connections made to the web server and each of the individual
     * web pages
     * 
     * Precondition: LoggerClient must have been initialized as an Object
     * Postcondition: log the client's connection and sends it to the LOGFILE
     */
    public void connection(String ipAddr) { 
        this.ipAddr = ipAddr;

        //Obtains the current timestamp of connection established
        Date date = new Date();
        long time  = date.getTime();
        Timestamp ts = new Timestamp(time);
        
        // Sends the IP Address with the connection established
        LOGGER.info(ipAddr + " - connection established\r\n");
    }
    
    /**
     * Logs the HTTP request the client makes to the server via browser
     * 
     * Precondition: LoggerClient must have been initialized as an Object
     * Postcondition: log the client's HTTP request and sends it to the LOGFILE
     */
    public void HTTPRequest(String filename, String request, ArrayList headerList) {
        // Current timestamp
        Date date = new Date();
        long time  = date.getTime();
        Timestamp ts = new Timestamp(time);

        String header = "";

        // Combines the elements of the header for it to be sent out as one unit
        for(int i=0; i<headerList.size(); i++) {
            header += headerList.get(i) + "\r\n";
        }
        
        // Sends in the IP address, http request and the file it was trying 
        // to access
        LOGGER.info(ipAddr + " - HTTP Request \r\n" + request + "\r\nFilename: " 
            + filename + "\r\n" + header + "\r\n");
    }
}
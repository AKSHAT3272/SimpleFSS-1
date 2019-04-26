import java.io.*;
import java.util.logging.*;
import java.net.*;
import java.util.*;
import java.sql.Timestamp; 

public class LoggerClient  {
    private String ipAddr;
    private static final Logger LOGGER = Logger.getLogger( LoggerClient.class.getName() );
    SimpleFormatter formatter;
    FileHandler fh;

    public LoggerClient() throws Exception { super(); }

    public void setupLogger() {
        try {
            // file to write the logs to
            fh = new FileHandler("simplefss-logs.txt");
            
            // helps to format the log messages to appropriate format
            formatter = new SimpleFormatter();  
            fh.setFormatter(formatter); 
            
            // stops log from being outputted to console
            //LOGGER.setUseParentHandlers(false);
            
            // adds the log file as a handler so that output is sent here
            LOGGER.addHandler(fh);
            
            // logConnection();
            LOGGER.getHandlers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Logs the connections made
    public void connection(String ipAddr) { 
        this.ipAddr = ipAddr;

        //Obtains the current timestamp of connection established
        Date date = new Date();
        long time  = date.getTime();
        Timestamp ts = new Timestamp(time);

        LOGGER.info(ipAddr + " - connection established\r\n");
    }
    
    // Logs the HTTP Request
    public void HTTPRequest(String filename, String request, ArrayList headerList) {
        Date date = new Date();
        long time  = date.getTime();
        Timestamp ts = new Timestamp(time);
        
        String header = "";
        
        // Combines the elements of the header for it to be sent out as one unit
        for(int i=0; i<headerList.size(); i++) {
            header += headerList.get(i) + "\r\n";
        }
        
        LOGGER.info(ipAddr + " - HTTP Request \r\n" + request + "\r\nFilename: " 
            + filename + "\r\n" + header + "\r\n");
    }

}

 

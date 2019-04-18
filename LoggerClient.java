import java.io.*;
import java.util.logging.*;
import java.net.*;
import java.util.*;
import java.sql.Timestamp; 

public class LoggerClient  {
    private String ipAddr;
    private static final Logger LOGGER = Logger.getLogger( LoggerClient.class.getName() );
    
    public LoggerClient() throws Exception { super(); }
    
    public void createLogs(String ipAddr) {
        this.ipAddr = ipAddr;
        logConnection();
    }
    
    public void logConnection() {
        //Obtains the current timestamp of connection established
        Date date = new Date();
        long time  = date.getTime();
        Timestamp ts = new Timestamp(time);
        
        //LOGGER.info("Logger Name: "+LOGGER.getName());
        LOGGER.info(ipAddr + " [" + ts + "] - connection established");
        
    }
    
    /** 
    public static void main(String[] args) throws SecurityException, IOException {
        
        // Write this out to a file, jesus
        try{
            
            System.out.println("Test output)");
            
            LOGGER.info("Logger Name: "+LOGGER.getName());
         
            LOGGER.warning("Can cause ArrayIndexOutOfBoundsException");
             
            //An array of size 3
            int []a = {1,2,3};
            int index = 2;
            LOGGER.config("index is set to "+index);
            System.out.println(a[index]);
        }catch(ArrayIndexOutOfBoundsException ex){
            LOGGER.log(Level.SEVERE, "Exception occur", ex);
        }
         
        */
       
    }
    
    
 

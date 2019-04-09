import java.io.*;
import java.util.logging.*;
import java.net.*;
 
public class LoggerClient {
 
    private static final Logger LOGGER = Logger.getLogger( LoggerClient.class.getName() );
    
    
    
    public static void main(String[] args) throws SecurityException, IOException {
        System.out.print("\f");
        
        //Currently for testing purposes
        String hostName = "localhost";
        int portNumber = 4444;
        
        try{
            Socket socket = new Socket(hostName, portNumber);
            
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
         
 
    }
    
    
 
}
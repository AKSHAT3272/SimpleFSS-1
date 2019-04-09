import java.net.*;
import java.io.*;

public class LoggerServer {
    public static void main(String[] args) throws IOException {
        System.out.println("\f");
        int portNumber = 4444;
        boolean listening = true;
        
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) { 
            if (listening) 
                System.out.println("I'm listening");
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}
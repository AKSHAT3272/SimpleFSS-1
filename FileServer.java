import java.io.* ;
import java.net.* ;
import java.util.* ;

public final class FileServer {

  public static void main(String argv[]) throws Exception {
	int port = 4444;
	String dir = "Home\\";
	
	/** UNCOMMENT if option to specify a different directory and port is wanted
	try {
	    port = (new Integer(argv[0])).intValue();
	    dir = argv[1];
	} catch (ArrayIndexOutOfBoundsException e) {
	    System.out.println("Needs: port and directory");
	    System.exit(-1);
	}*/
	
	ServerSocket socket = new ServerSocket(port);
	// Process HTTP requests
	while (true) {
	   //TCP connection request
	    Socket connection = socket.accept();
	    //Http request object (connection, directory) 
	    HttpRequest request = new HttpRequest(connection, dir);
	    //each request creates a new thread
	    Thread thread = new Thread(request);
	    thread.start();
	}
  }
}



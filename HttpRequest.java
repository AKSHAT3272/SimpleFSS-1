import java.io.* ;
import java.net.* ;
import java.util.* ;

final class HttpRequest implements Runnable {
    //Carriage Return Line Feed (windows \r unix \n)
    final static String CRLF = "\r\n"; 
    Socket socket;
    String dir;

    public HttpRequest(Socket socket, String dir) throws Exception {
        this.socket = socket;
        this.dir = dir;
    }

    //run() from Runnable interface 
    //When an object implementing interface Runnable is used to create a thread, starting the thread causes 
    //the object's run method to be called in that separately executing thread.
    public void run() {
        try {
            HttpProcessRequest();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void HttpProcessRequest() throws Exception {
        InputStream in = socket.getInputStream();
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //get the http request
        String request = br.readLine();
        // get the file name
        StringTokenizer tokens = new StringTokenizer(request);
        tokens.nextToken(); 
        String fileName = tokens.nextToken();  
        fileName = this.dir + fileName;
        System.out.println("Filename: " + fileName);
        // Open the file.
        FileInputStream fis = null ;
        boolean fileExists = true ;
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            fileExists = false ;
        }
        System.out.println(request);
        String headerLine = null;
        while ((headerLine = br.readLine()).length() != 0) {
            System.out.println(headerLine);
        }
        // HTTP Return Request.
        String statusLine = null;
        String contentTypeLine = null;
        String entityBody = null;
        if (fileExists) {
            statusLine = "HTTP/1.0 200 OK" + CRLF;
            contentTypeLine = "Content-Type: " + 
            contentType(fileName) + CRLF;
        } else {
            statusLine = "HTTP/1.0 404 Not Found" + CRLF;
            contentTypeLine = "Content-Type: text/html" + CRLF;
            entityBody = "<HTML>" + 
            "<HEAD><TITLE>Not Found</TITLE></HEAD>" +
            "<BODY>Not Found</BODY></HTML>";
        }
        os.writeBytes(statusLine);
        os.writeBytes(contentTypeLine);
        os.writeBytes(CRLF); //end of line
        if (fileExists) {
            sendBytes(fis, os);
            fis.close();
        } else {
            os.writeBytes(entityBody) ; //sent entity body HTTP/1.0 ....
        }
        os.close();
        br.close();
        socket.close();
    }

    private static void sendBytes(FileInputStream fis, 
    OutputStream os) throws Exception {
        //1K buffer
        byte[] buffer = new byte[1024];
        int bytes = 0;
        //Send requested file into socket output
        while ((bytes = fis.read(buffer)) != -1) {
            os.write(buffer, 0, bytes);
        }
    }

    private static String contentType(String fileName) {
        if(fileName.endsWith(".htm") || fileName.endsWith(".html")) {
            return "text/html";
        }
            return "application/x-php php";
    }
}

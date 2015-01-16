/* A TCP client that can be used to to send commands to a TCP server in
 * Pure Data. The commands are strings terminated with a ";" so e.g. the
 * netreceive object box in Pure Data can receive the commands.
 */ 

import java.io.*;
import java.net.*;

public class TcpClient
{
    private Socket socket;
    private PrintWriter out;
    private boolean connected;
    private String defaultHost = "localhost";
    private int defaultPort = 7779;

    public TcpClient()
    {
        socket = null;
        out = null;
        connected = false;
    }
    
    public void connect() {
        connect(defaultHost, defaultPort);
    }

    public void connect(String host, int port)
    {
        try {
            socket = new Socket(host, port);
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + host + ".");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + host + ".");
        }
        connected = true;
    }

    public void disconnect()
    {
        if ( connected )
        {
            try {
	            out.close();
	            socket.close();
                connected = false;
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection.");
            }            
        }
    }

    /**
     * Send command to a Pure Data audio engine. 
     */
    public void send(String command)
    {
        if ( connected ) out.println(command +";");   
    }
}
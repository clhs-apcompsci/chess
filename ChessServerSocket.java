
import java.net.*;
import java.io.*;

public class ChessServerSocket extends Thread
{
    ServerSocket Chess1;
    Socket Chess;
    public ChessServerSocket()
    {
        start();
    }

    @Override
    public void run()
    {
        try {
            System.out.println( "<Client> Started!" ); 
            Chess1 = new ServerSocket(4321);
            Chess = Chess1.accept();
            InputStreamReader InputChess = new InputStreamReader(Chess.getInputStream());
            BufferedReader BuffChess = new BufferedReader(InputChess);

            String check = BuffChess.readLine();
            System.out.println(check);

            if(check != null)
            {
                PrintStream PRChess = new PrintStream(Chess.getOutputStream());
                PRChess.println("Got it!"); 
            }
        } catch( IOException e ) { System.err.println( e ); }
    }
    
    public int getLocalPort()
    {
        return Chess1.getLocalPort();
    }
    
    public Socket accept() throws IOException
    {
        return Chess1.accept();
    }

}
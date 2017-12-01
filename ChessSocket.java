import java.net.*;
import java.io.*;

public class ChessSocket extends Thread
{
    Socket Chess;
    
    public static void main( String[] args )
    {
        new ChessSocket();
    }
    
    public ChessSocket()
    {
        start();
    }

    @Override
    public void run()
    {
        try {
            System.out.println( "<Server> Started!" );
            Chess = new Socket("localhost",4321);
            PrintStream PRChess = new PrintStream(Chess.getOutputStream());
            PRChess.println("<Server> Client connected!");

            InputStreamReader InputChess = new InputStreamReader(Chess.getInputStream());

            BufferedReader BuffChess = new BufferedReader(InputChess);

            String check = BuffChess.readLine();
            System.out.println("<Client> " + check);
        } catch( IOException e ) { System.err.println( e ); }
    }
      
    public int getLocalPort()
    {
        return Chess.getLocalPort();
    }
    
    
}

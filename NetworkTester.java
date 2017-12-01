
public class NetworkTester
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Server Start:" );
        new ChessServerSocket();
        Thread.sleep( 3000 );
        System.out.println( "Client Start:" );
        new ChessSocket();
        while( true ) {}
    }
}

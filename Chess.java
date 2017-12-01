
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Chess extends JFrame implements ActionListener, WindowListener
{
    private JLabel output;
    private JButton newGame;
    private Array2d<JButton> grid;
    private ArrayList<ChessPiece> pieces;
    public final int WIDTH = 8, HEIGHT = 8;
    
    public static void main( String[] args )
    {
        new Chess();
    }
    
    public Chess()
    {
        JPanel panel = new JPanel( new GridLayout( WIDTH, HEIGHT ) );
        grid = new Array2d<JButton>( WIDTH, HEIGHT );
        boolean dark = false;
        for( int y = 0; y < HEIGHT; y++ )
        {
            for( int x = 0; x < WIDTH; x++ )
            {
                grid.set( x, y, new JButton( "(" + x + ", " + y + ")" ) );
                if( dark )
                    grid.get( x, y ).setBackground( Color.BLACK );
                else
                    grid.get( x, y ).setBackground( Color.WHITE );
                grid.get( x, y ).setForeground( Color.GREEN );
                panel.add( grid.get( x, y ) );
                dark = !dark;
            }
            dark = !dark;
        }
        
        pieces = new ArrayList<ChessPiece>();
        for( int x = 0; x < WIDTH; x++ )
            pieces.add( new Pawn( false, new Point( x, 1 ) ) );
        for( int x = 0; x < WIDTH; x++ )
            pieces.add( new Pawn( true, new Point( x, WIDTH - 2 ) ) );
        
        output = new JLabel( "Loading . . ." );
        output.setFont( new Font( "SansSerif", Font.BOLD, 16 ) );
        output.setHorizontalAlignment( JLabel.CENTER );
        
        newGame = new JButton( "New Game" );
        newGame.setFocusable( true );
        newGame.addActionListener( this );
        
        addWindowListener( this );
        //if( compVcompGame )
        //    setSize( board.getWidth() * 64 + 16, grid.getHeight() * 64 + 64 );
        //else
        setSize( WIDTH * 64 + 16, HEIGHT * 64 + 32 + 64 );
        
        setLayout( new BorderLayout() );
        add( output, BorderLayout.NORTH );
        add( panel, BorderLayout.CENTER );
        add( newGame, BorderLayout.SOUTH );
        
        setLocationRelativeTo( null );
        //setResizable( false );
        setTitle( "Chess" );
        setIconImage( new ImageIcon( "chess/icon.png" ).getImage() );
        setVisible( true );
    }
    
    @Override
    public void actionPerformed( ActionEvent evt )
    {
    }
    
    public void refresh()
    {
        for( int y = 0; y < HEIGHT; y++ )
            for( int x = 0; x < WIDTH; x++ )
                grid.get( x, y ).setIcon( null );
        
        for( int i = 0; i < pieces.size(); i++ )
        {
            ChessPiece p = pieces.get( i );
            grid.get( p.position.getX(), p.position.getY() ).setIcon( p.getIcon() );
        }
    }
    
    @Override
    public void windowClosing( WindowEvent evt )
    {
        System.exit( 0 );
    }
    
    @Override public void windowOpened( WindowEvent evt ) {}
    @Override public void windowClosed( WindowEvent evt ) {}
    @Override public void windowIconified( WindowEvent evt ) {}
    @Override public void windowDeiconified( WindowEvent evt ) {}
    @Override public void windowActivated( WindowEvent evt ) {}
    @Override public void windowDeactivated( WindowEvent evt ) {}
}

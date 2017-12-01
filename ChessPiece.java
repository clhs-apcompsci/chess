import java.util.ArrayList;
import javax.swing.ImageIcon;
public abstract class ChessPiece
{
    private String pieceName;
    private ImageIcon icon;
    public boolean darkSide;
    public Point position;
    
    protected ArrayList<Point> possibleMoves =
        new ArrayList<Point>();
        
    public abstract ArrayList<Point> move(Point[][] whereTo);
    
    public void setSide(boolean mySide)
    {
        darkSide = mySide;
    }
    
    public void setName(String myName)
    {
        pieceName = myName;
    }
    
    public void setIcon(String path)
    {
        icon = new ImageIcon(path);
    }
    
    public void setPosition(Point myPos)
    {
        myPos.setPiece( this );
        position = myPos;
    }
    
    public void setPosition(int x, int y)
    {
        position = new Point(x,y);
    }
    
    public ImageIcon getIcon()
    {
        if( icon == null )
            setIcon( "images/" + ( darkSide ? "black" : "white" ) + "_" + pieceName.toLowerCase() + ".png" );
        return icon;
    }
    
    public String toString()
    {
        if(darkSide)
        {
            return "black " + pieceName;
        }
        else
        {
            return "white " + pieceName;
        }
    }
}

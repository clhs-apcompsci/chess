import java.util.ArrayList;
public class Rook extends ChessPiece
{
    public Rook(boolean side, Point p)
    {
        setSide(side);
        setName("Rook");
        setPosition(p);
    }

    public ArrayList<Point> move(Point[][] whereTo)
    {
        possibleMoves.clear();
        //depending on side:
        //can either move up/down one space, up/down two spaces,
        //or diagonally 'forward' when attacking
        //attacking to be handled separately

        for(int x = myPosition.getX(); x < 7; x++)
        {
            if(whereTo[x][myPosition.getY()].getPiece() != null)
            {
                if(whereTo[x][myPosition.getY()].getPiece().darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(x,myPosition.getY()));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(x,myPosition.getY()));
            }
        }

        for(int y = myPosition.getY(); y > 0; y--)
        {
            if(whereTo[myPosition.getX()][y].getPiece() != null)
            {
                if(whereTo[(myPosition.getX())][y].getPiece().darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(myPosition.getX(),y));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(myPosition.getX(),y));
            }
        }
        
        
        return possibleMoves;
    }

}

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

        for(int x = position.getX(); x < 7; x++)
        {
            if(whereTo[x][position.getY()].getPiece() != null)
            {
                if(whereTo[x][position.getY()].getPiece().darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(x,position.getY()));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(x,position.getY()));
            }
        }

        for(int y = position.getY(); y > 0; y--)
        {
            if(whereTo[position.getX()][y].getPiece() != null)
            {
                if(whereTo[(position.getX())][y].getPiece().darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(position.getX(),y));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(position.getX(),y));
            }
        }
        
        
        return possibleMoves;
    }

}

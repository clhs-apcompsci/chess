import java.util.ArrayList;
public class Bishop extends ChessPiece
{
    public Bishop(boolean side, Point p)
    {
        setSide(side);
        setName("Bishop");
        setPosition(p);
    }

    public ArrayList<Point> move(Point[][] whereTo)
    {
        possibleMoves.clear();
        //depending on side:
        //can either move up/down one space, up/down two spaces,
        //or diagonally 'forward' when attacking
        //attacking to be handled separately
        int y = myPosition.getY();
        for(int x = myPosition.getX(); x < 7 && y > 0; x++,y--)
        {
            if(whereTo[x][y].getPiece() != null)
            {
                if(whereTo[x][y].getPiece().darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(x,y));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(x,y));
            }
        }

        for(int x = myPosition.getX(); x > 7 && y < 0; x--,y++)
        {
            if(whereTo[x][y].getPiece() != null)
            {
                if(whereTo[x][y].getPiece().darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(x,y));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(x,y));
            }
        }
        return possibleMoves;
    }

}

import java.util.ArrayList;
public class Knight extends ChessPiece
{
    public Knight(boolean side, Point p)
    {
        setSide(side);
        setName("Knight");
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
        return possibleMoves;
    }

}


import java.util.ArrayList;
public class Queen extends ChessPiece
{
    public Queen(boolean side, Point p)
    {
        setSide(side);
        setName("Queen");
        setPosition(p);
    }

    public ArrayList<Point> move(Point[][] whereTo)
    {
        possibleMoves.clear();
        //depending on side:
        //can either move up/down one space, up/down two spaces,
        //or diagonally 'forward' when attacking
        //attacking to be handled separately
        for(int x = myPosition.getX(); x < 7; x--)
        {
            if(whereTo[myPosition.getX()-1][myPosition.getY()].getPiece() != null)
            {
                if(whereTo[(myPosition.getX()-1)][myPosition.getY()].getPiece().darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(myPosition.getX()-1,myPosition.getY()));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(myPosition.getX()-1,myPosition.getY()));
            }
        }

        for(int y = myPosition.getY(); y > 0; y--)
        {
            if(whereTo[myPosition.getX()][myPosition.getY()-1].getPiece() != null)
            {
                if(whereTo[(myPosition.getX())][myPosition.getY()-1].getPiece().darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(myPosition.getX(),myPosition.getY()-1));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(myPosition.getX(),myPosition.getY()));
            }
        }

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


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
        for(int x = position.getX(); x < 7; x--)
        {
            if(whereTo[position.getX()-1][position.getY()].getPiece() != null)
            {
                if(whereTo[(position.getX()-1)][position.getY()].getPiece().darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(position.getX()-1,position.getY()));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(position.getX()-1,position.getY()));
            }
        }

        for(int y = position.getY(); y > 0; y--)
        {
            if(whereTo[position.getX()][position.getY()-1].getPiece() != null)
            {
                if(whereTo[(position.getX())][position.getY()-1].getPiece().darkSide)
                {
                    break;
                }
                else
                {
                    possibleMoves.add(new Point(position.getX(),position.getY()-1));
                    break;
                }
            }
            else
            {
                possibleMoves.add(new Point(position.getX(),position.getY()));
            }
        }

        int y = position.getY();
        for(int x = position.getX(); x < 7 && y > 0; x++,y--)
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

        for(int x = position.getX(); x > 7 && y < 0; x--,y++)
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


import java.util.ArrayList;
public class King extends ChessPiece
{
    public King(boolean side, Point p)
    {
        setSide(side);
        setName("King");
        setPosition(p);
    }

    public ArrayList<Point> move(Point[][] whereTo)
    {
        possibleMoves.clear();
        //depending on side:
        //can either move up/down one space, up/down two spaces,
        //or diagonally 'forward' when attacking
        //attacking to be handled separately
        for(int x = 0; x < 7; x++)
        {


            if(darkSide)
            {
                if(position.getY() < 7 ) //dark pieces start at the top of board
                {
                    possibleMoves.add(new Point(position.getX() ,position.getY()) );
                }

            }
            else
            {
                if(position.getY() > 0) //white pieces at the bottom
                {
                    possibleMoves.add(new Point(position.getX(),position.getY()));
                }

            }

        }
        return possibleMoves;
    }

}

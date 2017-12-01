import java.util.ArrayList;
public class Pawn extends ChessPiece
{
    public Pawn(boolean side, Point p)
    {
        setSide(side);
        setName("Pawn");
        setPosition(p);
    }

    public ArrayList<Point> move(Point[][] whereTo)
    {
        possibleMoves.clear();
        //depending on side:
        //can either move up/down one space, up/down two spaces,
        //or diagonally 'forward' when attacking
        //attacking to be handled separately
        if(darkSide)
        {
            if(position.getY() < 7) //dark pieces start at the top of board
            {
                if(whereTo[position.getX()][position.getY()+1].getPiece() == null)
                {
                    possibleMoves.add(new Point(position.getX(),position.getY() + 1));
                }
            }
            if(position.getY() == 1)
            {
                possibleMoves.add(new Point(position.getX(),position.getY() + 2));
            }
            if(position.getX() > 0 && position.getY() < 7)
            {
                if(whereTo[position.getX()-1][position.getY()+1].getPiece() != null)
                {
                    if(whereTo[position.getX()-1][position.getY()+1].getPiece().darkSide != darkSide)
                    {
                        possibleMoves.add(new Point(position.getX() -1, position.getY()+1));
                    }
                }
            }

            if(position.getX() > 0 && position.getY() < 7)
            {
                if(whereTo[position.getX()+1][position.getY()+1].getPiece() != null)
                {
                    if(whereTo[position.getX()+1][position.getY()+1].getPiece().darkSide != darkSide)
                    {
                        possibleMoves.add(new Point(position.getX() +1, position.getY()+1));
                    }
                }
            }

            else
            {
                if(position.getY() > 0) //white pieces at the bottom
                {
                    if(whereTo[position.getX()][position.getY()-1].getPiece() == null)
                    {
                        possibleMoves.add(new Point(position.getX(),position.getY() - 1));
                    }
                }

                if(position.getY() == 1)
                {
                    possibleMoves.add(new Point(position.getX(),position.getY() - 2));
                }

                if(position.getX() > 0 && position.getY() > 0)
                {    
                    if(whereTo[position.getX()-1][position.getY()-1].getPiece() != null)
                    {
                        if(whereTo[position.getX()-1][position.getY()-1].getPiece().darkSide == darkSide)
                        {
                            possibleMoves.add(new Point(position.getX() -1, position.getY()-1));
                        }
                    }
                }

                if(position.getX() > 0 && position.getY() > 0)
                {
                    if(whereTo[position.getX()+1][position.getY()-1].getPiece() != null)
                    {
                        if(whereTo[position.getX()+1][position.getY()-1].getPiece().darkSide == darkSide)
                        {
                            possibleMoves.add(new Point(position.getX() +1, position.getY()-1));
                        }
                    }
                }

            }
        }
        return possibleMoves;
    }

}


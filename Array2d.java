
import java.util.Arrays;

public class Array2d<T>
{
    private Object[][] objects;
    
    public Array2d( int width, int height )
    {
        objects = new Object[width][height];
    }
    
    public Array2d( T[][] objs )
    {
        this( objs.length, objs[0].length );
        for( int x = 0; x < getWidth(); x++ )
            for( int y = 0; y < getHeight(); y++ )
                set( x, y, objs[x][y] );
    }
    
    @SuppressWarnings( "unchecked" )
    public T get( int x, int y )
    {
        //try {
            return ( T ) ( objects[x][y] );
        //} catch( IndexOutOfBoundsException e ) {
        //    return null;
        //}
    }
    
    public T get( int x, int y, Direction dir )
    {
        try {
            switch( dir )
            {
                case NORTH:         case UP:            return get(   x,   y - 1 );
                case SOUTH:         case DOWN:          return get(   x,   y + 1 );
                case EAST:          case RIGHT:         return get( x + 1,   y   );
                case WEST:          case LEFT:          return get( x - 1,   y   );
                
                case NORTHEAST:     case UP_RIGHT:      return get( x + 1, y - 1 );
                case NORTHWEST:     case UP_LEFT:       return get( x - 1, y - 1 );
                
                case SOUTHWEST:     case DOWN_LEFT:     return get( x - 1, y + 1 );
                case SOUTHEAST:     case DOWN_RIGHT:    return get( x + 1, y + 1 );
                
                                    default:            return null;
            }
        } catch( IndexOutOfBoundsException e ) {
            return null;
        }
    }
    
    public void set( int x, int y, T obj )
    {
        objects[x][y] = obj;
    }
    
    public boolean inBounds( int x, int y )
    {
        try {
            get( x, y );
            return true;
        } catch( IndexOutOfBoundsException e ) {
            return false;
        }
    }
    
    public int getWidth()
    {
        return objects.length;
    }
    
    public int getHeight()
    {
        if( getWidth() > 0 )
            return objects[0].length;
        else
            return 0;
    }
    
    public int size()
    {
        return getWidth() * getHeight();
    }
    
    public int getX( T obj )
    {
        for( int x = 0; x < getWidth(); x++ )
            for( int y = 0; y < getHeight(); y++ )
                if( objects[x][y] == obj )
                    return x;
        return -1;
    }
    
    public int getY( T obj )
    {
        for( int x = 0; x < getWidth(); x++ )
            for( int y = 0; y < getHeight(); y++ )
                if( objects[x][y] == obj )
                    return y;
        return -1;
    }
    
    public boolean contains( T obj )
    {
        for( int x = 0; x < getWidth(); x++ )
            for( int y = 0; y < getHeight(); y++ )
                if( objects[x][y] == obj )
                    return true;
        return false;
    }
    
    public String toString()
    {
        String dummy = getWidth() + "x" + getHeight() + " " + getClass().getCanonicalName() + ":";
        for( int y = 0; y < getHeight(); y++ )
        {
            dummy += "\n\t[    ";
            for( int x = 0; x < getWidth(); x++ )
                dummy += get( x, y ) + ",  ";
            dummy += "    ]";
        }
        
        return dummy;
    }
}

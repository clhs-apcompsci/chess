
import java.util.HashMap;
import java.util.ArrayList;

public class Message
{
    private HashMap<String, String> data;
    private ArrayList<String> vars;
    
    public Message( ID sender )
    {
        data = new HashMap<String, String>();
        vars = new ArrayList<String>();
        addVar( "sender", sender.toString() );
    }
    
    public Message( String msg )
    {
        
    }
    
    public void addVar( String varName, Object var )
    {
        String type;
        if( var instanceof Integer )
            type = "int";
        else if( var instanceof Double )
            type = "double";
        else if( var instanceof Float )
            type = "float";
        else if( var instanceof Long )
            type = "long";
        else if( var instanceof Character )
            type = "char";
        else if( var instanceof String )
            type = "String";
        else if( var instanceof Boolean )
            type = "boolean";
        else
            throw new IllegalArgumentException( varName + " is not primitive; is of type " + var.getClass().getCanonicalName() );
        data.put( type + " " + varName, var.toString() );
        vars.add( type + " " + varName );
    }
    
    public void removeVar( String name )
    {
        for( int i = 0; i < vars.size(); i++ )
            if( vars.get( i ).split( " " )[1].equals( name ) )
            {
                data.remove( vars.get( i ) );
                vars.remove( i );
            }
    }
    
    public int getInteger( String name )
    {
        return ( int ) ( getVar( "int", name ) );
    }
    
    public double getDouble( String name )
    {
        return ( double ) ( getVar( "double", name ) );
    }
    
    public float getFloat( String name )
    {
        return ( int ) ( getVar( "float", name ) );
    }
    
    public long getLong( String name )
    {
        return ( long ) ( getVar( "long", name ) );
    }
    
    public char getCharacter( String name )
    {
        return ( char ) ( getVar( "char", name ) );
    }
    
    public String getString( String name )
    {
        return ( String ) ( getVar( "String", name ) );
    }
    
    public boolean getBoolean( String name )
    {
        return ( boolean ) ( getVar( "boolean", name ) );
    }
    
    public Object getVar( String name )
    {
        for( int i = 0; i < vars.size(); i++ )
            if( vars.get( i ).split( " " )[1].equals( name ) )
                return data.get( vars.get( i ) );
        return null;
    }
    
    private Object getVar( String type, String name )
    {
        if( vars.contains( name ) )
            return data.get( name );
        return null;
    }
    
    public String toString()
    {
        removeVar( "timestamp" );
        addVar( "timestamp", System.nanoTime() );
        return data.toString();
    }
}


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
    
    public String toString()
    {
        removeVar( "timestamp" );
        addVar( "timestamp", System.nanoTime() );
        return data.toString();
    }
}

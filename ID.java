
import java.util.UUID;

public class ID
{
    String id;
    
    public ID()
    {
        id = UUID.randomUUID().toString();
    }
    
    public String toString()
    {
        return id;
    }
}

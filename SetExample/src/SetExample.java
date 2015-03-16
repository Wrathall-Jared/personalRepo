import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {

        // Set example with implement TreeSet
        Set<String> s=new TreeSet<String>();

        s.add("b");
        s.add("a");
        s.add("d");
        s.add("c");

        Iterator it=s.iterator();

        while(it.hasNext())
        {
          String value=(String)it.next();

          System.out.println("Value :"+value);
        }
    }
}
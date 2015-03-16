	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.Map;
	import java.util.Set;

	public class MapExample {
	    public static void main(String[] args) {

	        Map mp = new HashMap();
	        mp.put(new Integer(2), "Two");
	        mp.put(new Integer(1), "One");
	        mp.put(new Integer(3), "Three");
	        mp.put(new Integer(4), "Four");

	        Set st = mp.entrySet();

	        Iterator it = st.iterator();

	        while (it.hasNext()) {

	            Map.Entry m = (Map.Entry) it.next();

	            int key = (Integer) m.getKey();

	            String value = (String) m.getValue();
	            System.out.println("Key :" + key + "  Value :" + value);

	        }
	    }
	}


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String args[]) {  
	
		List<MyObject> proba = new ArrayList<>();
		proba.add(new MyObject(3));
		proba.add(new MyObject(4));
		proba.add(new MyObject(1));
		proba.add(new MyObject(7));
		
		Set<Integer> result = CollectionConverter.getHashSetOfProperties(proba, "getNumber");

	
		System.out.println(result.toString());
		//Integer test = result.get(0); // .iterator().next(); //
		
	}  

	
}

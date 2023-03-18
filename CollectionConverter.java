import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionConverter {

	/**
	 * Létre hozza egy objektum kollekció valamely property-jeinek kollekcióját.
	 * A kollekció az eredeti kollekcióval azonos típusú lesz.
	 * @param collection - az objektumok kollekciója
	 * @param getter - a kért property gettere, pl. "getUniqueId"
	 * @return
	 */
	public static Collection getSameTypeCollectionOfProperties(Collection<?> collection, String getter) {
		Collection result = null;
		try {
			result = getCollectionOfProperties(collection, getter, null);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Létre hozza egy objektum kollekció valamely property-jeinek kollekcióját.
	 * A kollekció ArrayList típusú lesz.
	 * @param collection - az objektumok kollekciója
	 * @param getter - a kért property gettere, pl. "getUniqueId"
	 * @return
	 */	
	public static ArrayList getArrayListOfProperties(Collection<?> collection, String getter) {
		ArrayList result = null;
		try {
			result = (ArrayList) getCollectionOfProperties(collection, getter, ArrayList.class);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;		
	}
	
	/**
	 * Létre hozza egy objektum kollekció valamely property-jeinek kollekcióját.
	 * A kollekció LinkedList típusú lesz.
	 * @param collection - az objektumok kollekciója
	 * @param getter - a kért property gettere, pl. "getUniqueId"
	 * @return
	 */	
	public static LinkedList getLinkedListOfProperties(Collection<?> collection, String getter) {
		LinkedList result = null;
		try {
			result = (LinkedList) getCollectionOfProperties(collection, getter, LinkedList.class);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;	
	}
	
	/**
	 * Létre hozza egy objektum kollekció valamely property-jeinek kollekcióját.
	 * A kollekció Vector típusú lesz.
	 * @param collection - az objektumok kollekciója
	 * @param getter - a kért property gettere, pl. "getUniqueId"
	 * @return
	 */	
	public static Vector getVectorOfProperties(Collection<?> collection, String getter) {
		Vector result = null;
		try {
			result = (Vector) getCollectionOfProperties(collection, getter, Vector.class);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Létre hozza egy objektum kollekció valamely property-jeinek kollekcióját.
	 * A kollekció Stack típusú lesz.
	 * @param collection - az objektumok kollekciója
	 * @param getter - a kért property gettere, pl. "getUniqueId"
	 * @return
	 */	
	public static Stack getStackOfProperties(Collection<?> collection, String getter) {
		Stack result = null;
		try {
			result = (Stack) getCollectionOfProperties(collection, getter, Stack.class);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Létre hozza egy objektum kollekció valamely property-jeinek kollekcióját.
	 * A kollekció HashSet típusú lesz.
	 * @param collection - az objektumok kollekciója
	 * @param getter - a kért property gettere, pl. "getUniqueId"
	 * @return
	 */	
	public static HashSet getHashSetOfProperties(Collection<?> collection, String getter) {
		HashSet result = null;
		try {
			result = (HashSet) getCollectionOfProperties(collection, getter, HashSet.class);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Létre hozza egy objektum kollekció valamely property-jeinek kollekcióját.
	 * A kollekció LinkedHashSet típusú lesz.
	 * @param collection - az objektumok kollekciója
	 * @param getter - a kért property gettere, pl. "getUniqueId"
	 * @return
	 */	
	public static LinkedHashSet getLinkedHashSetOfProperties(Collection<?> collection, String getter) {
		LinkedHashSet result = null;
		try {
			result = (LinkedHashSet) getCollectionOfProperties(collection, getter, LinkedHashSet.class);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Létre hozza egy objektum kollekció valamely property-jeinek kollekcióját.
	 * A kollekció TreeSet típusú lesz.
	 * @param collection - az objektumok kollekciója
	 * @param getter - a kért property gettere, pl. "getUniqueId"
	 * @return
	 */	
	public static TreeSet getTreeSetOfProperties(Collection<?> collection, String getter)  {
		TreeSet result = null;
		try {
			result = (TreeSet) getCollectionOfProperties(collection, getter, TreeSet.class);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Létre hozza egy objektum kollekció valamely property-jeinek kollekcióját.
	 * A kollekció PriorityQueue típusú lesz.
	 * @param collection - az objektumok kollekciója
	 * @param getter - a kért property gettere, pl. "getUniqueId"
	 * @return
	 */	
	public static PriorityQueue getPriorityQueueOfProperties(Collection<?> collection, String getter) {
		PriorityQueue result = null;
		try {
			result = (PriorityQueue) getCollectionOfProperties(collection, getter, PriorityQueue.class);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Létre hozza egy objektum kollekció valamely property-jeinek kollekcióját.
	 * A kollekció ArrayDeque típusú lesz.
	 * @param collection - az objektumok kollekciója
	 * @param getter - a kért property gettere, pl. "getUniqueId"
	 * @return
	 */	
	public static ArrayDeque getArrayDequeOfProperties(Collection<?> collection, String getter) {
		ArrayDeque result = null;
		try {
			result = (ArrayDeque) getCollectionOfProperties(collection, getter, ArrayDeque.class);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * It's magic!
	 * 
	 * @param collection
	 * @param getter
	 * @param returnCollectionType
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private static Collection getCollectionOfProperties(Collection<?> collection, String getter, Class<? extends Collection> returnCollectionType) 
			throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
      
		//lekérem az egyik elemet, annak a classát, és megkeresem rajta azt a gettert
        Method getterMethod = collection.iterator().next().getClass().getMethod(getter);
        
        //ha nincs kért kollekció típus megadva, akkor olyan típusú lesz, mint a kapott kollekció
		if (returnCollectionType == null) {
			returnCollectionType = collection.getClass();
		} 
				
		//megkeresem a kért kollekciótípus konstruktorát
		Constructor<?> collectionConstructor = returnCollectionType.getConstructor();
		
		Collection returnCollection = (Collection) collectionConstructor.newInstance();
		
		for (Object element : collection) {
			returnCollection.add(getterMethod.invoke(element));
		}
		
		return returnCollection;
	}
	
}
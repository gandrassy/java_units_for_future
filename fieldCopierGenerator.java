package hu.smartfront.warehouse.domain;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Másoló konstruktőr generátor.
 * Az így generált kód gyorsabban lefut, mintha futásidőben reflectionozna.
 * 
 * @author "Andrassy Gabor"
 *
 */
public class fieldCopierGenerator {

	// ide kerül az az objektum, aminek a property-jeit másolni akarom	
	final static Class objectClass = Goodsout.class;

	//az objektumok nevei
	final static String oldObject = "other";
	final static String newObject = "this";
	
	final static boolean fullyQualifiedClassName = false; 
	
	// a file neve, ahova a generált kód kerül. (Ha már létezik, kérdés nélkül felülírja!) 
	final static String fileName = "fieldCopierGeneratorOutput.txt";
	
	
	public static void main(String[] args) {

		Field[] fields = objectClass.getDeclaredFields();

		//elkészítem a másoló bigyulákat
		ArrayList<String> lines = new ArrayList<>(fields.length);
		String shortClassName = objectClass.getName();
		shortClassName = shortClassName.substring(shortClassName.lastIndexOf('.')+1);
		lines.add("    public " + shortClassName + "(" + ((fullyQualifiedClassName) ? objectClass.getName() : shortClassName)+ " " + oldObject + ") {");
		for (Field field : fields) {
			field.setAccessible(true);
			lines.add("        " + newObject + ".set" + capitalize(field.getName()) + "(" + oldObject + ".get" + capitalize(field.getName()) + "());");
	    }
		lines.add("    }");
		
		//file inicializálás
	    Path file = Paths.get(fileName);
	    try {
	    	Files.createFile(file);
	    } catch (FileAlreadyExistsException ignore) {  //ha már létezik, felülírom, és csá
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    
	    //beleírom
	    try {
	    	Files.write(file, lines);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }

	}
	
	private static String capitalize(String s) {
		return s.substring(0, 1).toUpperCase().concat(s.substring(1));
	}

}

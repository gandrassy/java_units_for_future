package hu.smartfront.warehouse.tools;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

import com.ibm.icu.text.Collator;

/**
 * Ez az osztály stringek nemzeti ABC szerinti sorba rendezéséhez használatos.
 *  
 * 
 * 
 * @author "Andrassy Gabor"
 *
 */
public class LocalisedStringComparator<T> implements Comparator<T> {

	Collator collator;
	
	Method getter = null;
	
	public LocalisedStringComparator() {
		collator = Collator.getInstance(LocaleContextHolder.getLocale());
	}
	
	public LocalisedStringComparator(String gettername) {
		getter = Class<T>.class.getMethod(gettername);
		collator = Collator.getInstance(LocaleContextHolder.getLocale());
	}
	
	public LocalisedStringComparator(Locale locale) {
		if (T.class  String) {
			
		}
		collator = Collator.getInstance(locale);
	}

	public LocalisedStringComparator(String gettername, Locale locale) {
		getter = T.class.getMethod(gettername);
		collator = Collator.getInstance(locale);
	}
	
	@Override
	public int compare(T t1, T t2) {
		String s1 = null;
		String s2 = null;
		if (getter != null) {
    		s1 = (String) getter.invoke(t1);
    		s2 = (String) getter.invoke(t2);
    	}
		
		return collator.compare(s1,s2);
	}
	
}

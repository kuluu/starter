package second;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Java\u2122");
		String e = "";
		String greeting = "Hello";
		System.out.println(greeting.length());
		char ch = greeting.charAt(1);
		System.out.println(ch);
		int i;
		i = greeting.codePointAt(1);
		System.out.println(i);
		System.out.println(greeting.offsetByCodePoints(0, 3));
		if(greeting.compareTo("hello")>0)
			System.out.println("gan!");
		else
			System.out.println("ni wanquan budong o ?");
		if(greeting == "Hello")
			System.out.println("1");
		if(greeting.substring(0,3) == "Hel")
			System.out.println("2");
		String s = greeting.substring(0,3);
		System.out.println(e + greeting + s);
		String message = e + s;
		int age =13;
		System.out.println( greeting + age);
		String all = String.join("/","S","M","L","XL");
		System.out.println( all);
		String repeated = "java".repeat(3);
		System.out.println( repeated);
		repeated = repeated.substring(0,4) + " is the best!";
		System.out.println( repeated);
		if(!(s.equals(repeated)))
			System.out.println("test whether two strings are equal");
		if("HELLO".equalsIgnoreCase(greeting))
			System.out.println("test whether weo strings are identical except for case distinction");
		}


}

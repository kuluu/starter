package filetest;
import java.io.*;
public class Example12_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f1 = new File("Example12_1.java");
		File f2 = new File("D:\\Java");
		System.out.println(f1.getName() + " is readable? " + f1.canRead());
		System.out.println(f1.getName() + "'s length is " + f1.length());
		System.out.println(f1.getName() + "'s absolutepath is " + f1.getAbsolutePath());
		System.out.println(f2.getName() + " is directory? "+ f2.isDirectory());
		
	}
}

package filetest;
import java.io.*;
public class Example12_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Runtime ce = Runtime.getRuntime();
			File file = new File("C:\\Users\\administered\\Desktop","�½��ı��ĵ�.txt");
	
			ce.exec(file.getAbsolutePath());
			}
		catch(Exception e) {
			System.out.println(e);
		}
}

}

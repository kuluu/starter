package filetest;
import java.io.*;
public class Example12_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int b;
		byte tom[] = new byte[18];
		try {
			File f = new File("Example12_3.java");
			FileInputStream in = new FileInputStream(f);
			while((b = in.read(tom, 0, 18))!=-1) {
				String s = new String(tom,0,b);
				System.out.print(s);
			}
			in.close();
		}
		catch(IOException e)
		{
			System.out.print("File read error : " + e);
		}
	}

}

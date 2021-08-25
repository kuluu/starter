package filetest;
import java.io.*;
public class Example12_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("D:\\Java\\source\\first\\src\\first");
		FileAccept fileAccept = new FileAccept();
		fileAccept.setExtendName("java");
		String fileName[] = dir.list(fileAccept);
		for(String name:fileName)
		{
			System.out.println(name);
		}	
		File file = new File("C:\\Users\\administered\\Documents","letter.txt");
		
		
	}
}
class FileAccept implements FilenameFilter{
	private String extendName;
	public void setExtendName(String s) {
		extendName = '.' + s;
	}
	public boolean accept(File dir,String name) {
		return name.endsWith(extendName);
	}
}
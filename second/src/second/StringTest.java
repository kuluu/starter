package second;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "123;456;789;123";			//注意：对String的所有操作所得结果都不改变a的值，只是作为
		System.out.println(a.charAt(0));		//结果返回回来
		System.out.println(a.indexOf(";"));
		System.out.println(a.concat(";000"));
		System.out.println(a.contains("000"));
		System.out.println(a.endsWith("000"));
		System.out.println(a.equals("000"));
		System.out.println(a.equalsIgnoreCase("000"));
		System.out.println(a.length());
		System.out.println(a.trim());
		String[] b = a.split(";");
		for(int i = 0;i<b.length;i++)
		{
			System.out.println(b[i]);
		}
		System.out.println("=======================");
		System.out.println(a.substring(2,5));
		System.out.println(a.replace("1","a"));
		System.out.println(a.replaceAll("1", "a"));
		System.out.println("======================");
		String s1 = "12345?6789";
		String s2 = s1.replace("?", "a");
		String s3 = s1.replaceAll("[\\d]", "a");
		System.out.println(s2);
		System.out.println(s3);
		
	}

}

package second;

public class StringBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb1 = new StringBuffer("123");
		StringBuffer sb2 = sb1;
		sb1.append("123456789415633156489645113416469853164");
		System.out.println(sb2);	//sb1和sb2还是指向同一个内存的。
	}

}

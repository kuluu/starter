package first;

public class Example2_1 {

	public static /* strictfp */void main(String[] args) {
		// TODO Auto-generated method stub
		char ch1='w',ch2='��';
		int p1=32831,p2=30452;
		System.out.println("\""+ch1+"\"��λ��:"+(int)ch1);
		System.out.println("\""+ch2+"\"��λ��:"+(int)ch2);
		System.out.println("��"+p1+"��λ���ϵ��ַ���:"+(char)p1);
		System.out.println("��"+p2+"��λ���ϵ��ַ���:"+(char)p2);
		int x=128;
		byte y;
		y=(byte)x;
		System.out.println(y);
		char c=65;
		y=65+32;
		float x1;
		double x2 = 12345.123456789;
		System.out.println(x2);
		x1=(float)x2;
		System.out.println(x1);
		System.out.println(FirstSample.CM_PER_INCH);
	}

}

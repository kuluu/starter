package first;
import static java.lang.Math.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 4;
		double y = Math.sqrt(x);
		System.out.println(y);
		y = Math.pow(x, 10);
		System.out.println(y);
		y = Math.exp(2);
		System.out.println(y);
		System.out.println(Math.PI);
		System.out.println(Math.E);
		System.out.println(PI);      //加了import static java.lang.Math.*;后就可去掉前缀Math
		System.out.println(E);
		int a = 1000000000 * 3;
		System.out.println(a);
		/*a = multiplyExact(1000000000,3);
		System.out.println(a);   exception:integer overflow*/
		
		int n = 123456789;
		float f = n;
		System.out.println(f);
				/*short m = n;
				System.out.println(m);	*/
		double x1 = 9.997;
		int nx = (int) x1;
		System.out.println(nx);
		
		nx = (int) Math.round(x1);  //the return value of the round method is a long
		System.out.println(nx);
		
		System.out.println((byte) 300 );
		
		nx++;			
		nx += 3.5;		//is equivalent to nx = (int)(nx + 3.5);
		System.out.println(nx);
		double x2 = 11 <= 10 ? nx : x1;
		System.out.println(x2);
		System.out.println(FirstSample.CM_PER_INCH);
	}

}

class Point
{
	int x, y;
	void setXY(int m, int n)
	{
		x = m;
		y = n;
	}
}

public class Example4_3 
{
	public static void main(String[] args)
	{
		Point p1, p2;
		System.out.println("\u1D546");
		p1 = new Point();
		p2 = new Point();
		System.out.println("call p1:" + p1);
		System.out.println("call p2:" + p2);
		p1.setXY(1111, 2222);
		p2.setXY(-100, -200);
		System.out.println("the location of p1: " + p1.x + ", " + p1.y);
		System.out.println("the location of p2: " + p2.x + ", " + p2.y);
		p1 = p2;
		System.out.println("call p1:" + p1);
		System.out.println("call p2:" + p2);
		System.out.println("the location of p1: " + p1.x + ", " + p1.y);
		System.out.println("the location of p2: " + p2.x + ", " + p2.y);
	}
}

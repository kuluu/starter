package first;

public class GouZhaoFangFaTest {

	int x;
	int y;
	public static void main(String args[])
	{
		XiyoujiRenwu zhubajie,sunwukong;
		zhubajie = new XiyoujiRenwu();
		sunwukong = new XiyoujiRenwu();
		
	}
	GouZhaoFangFaTest()
	{
		x = 1;
		y = 1;
	}
	GouZhaoFangFaTest(int a,int b)
	{
		x = a;
		y = b;
	}
	void Point(int a,int b)
	{
		x = a;
		y = b;
	}
	int Point()
	{
		return 12;
	}

}

class XiyoujiRenwu
{
	float height,weight;
	String head,ear;
	void speak(String s)
	{
		System.out.println(s);
		
	}
}

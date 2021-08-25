
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer computer = new Computer();
		double result = computer.getResult(1.0/3, 10, 20, 30);
		System.out.println("10,20,30的平均数:" + result);
		result = computer.getResult(1.0/6, 66, 12, 5, 89, 2, 51);
		System.out.println("66,12,5,89,2,51的平均数:" + result);
	}

}

class Computer
{
	double getResult(double a, int ...x)
	{
		double result = 0;
		int sum = 0;
		for(int param : x)
		{
			sum += param;
		}
		result = a * sum;
		return result;
	}
}

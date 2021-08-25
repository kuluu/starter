package first;

public class FirstSample {
	
	public static final double CM_PER_INCH = 2.54;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var vacationDays = 12;
		var greeting = "Hello";
		System.out.println(vacationDays+greeting);
		var paperWidth = 8.5;
		var paperHeight = 11.0;
		System.out.println("Paper size in centimeters: " + paperWidth * CM_PER_INCH
				 + " by " + paperHeight * CM_PER_INCH);
		
		System.out.println(15 / 2 );
		System.out.println(15 % 2 );
		System.out.println(15.0 / 2 );
		System.out.println(15 / 2.0 );
		System.out.println(15.0 / 2.0 );
		System.out.println(1.0 / 0 );
		System.out.println(0.0 / 0 );
		
	}

}

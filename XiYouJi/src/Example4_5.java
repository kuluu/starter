
public class Example4_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle = new Circle(10);
		System.out.println("main������circle������:" + circle);
		System.out.println("main������circle�İ뾶" + circle.getRadius());
		Circular circular = new Circular(circle, 20);
		System.out.println("circularԲ׶��bottom������: " + circular.bottom);
		System.out.println("Բ׶��bottom�İ뾶:" + circular.getBottomRadius());
		System.out.println("Բ׶�����:" + circular.getVolme());
		double r = 8888;
		System.out.println("Բ׶���ĵ�Բbottom�İ뾶:" + r);
		circular.setBottomRadius(r);
		System.out.println("Բ׶��bottom�İ뾶:" + circular.getBottomRadius());
		System.out.println("Բ׶�������" + circular.getVolme());
		System.out.println("main������circle�İ뾶:" + circle.getRadius());
		System.out.println("main������circle�����ý������仯");
		circle = new Circle(1000);
		System.out.println("����main������circle������: " + circle);
		System.out.println("main������circle�İ뾶:" + circle.getRadius());
		System.out.println("���ǲ�Ӱ��circularԲ׶��bottom������");
		System.out.println("circularԲ׶��bottom������:" + circular.bottom);
		System.out.println("Բ׶��bottom�İ뾶:" + circular.getBottomRadius());
		
		
	}

}

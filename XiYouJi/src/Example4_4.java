
public class Example4_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rect rect = new Rect();
		double w = 12.76, h = 25.28;
		rect.setWidth(w);
		rect.setHeight(h);
		System.out.println("矩形对象的宽：" + rect.getWidth() + "高：" + rect.height);
		System.out.println("矩形的面积：" + rect.getArea());
		w = 100;
		h = 256;			//此改动，并不影响rect中Width 和 Height 的值
		System.out.println("矩形对象的宽：" + rect.getWidth() + "高：" + rect.getHeight());
	}

}

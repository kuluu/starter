
public class Example4_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rect rect = new Rect();
		double w = 12.76, h = 25.28;
		rect.setWidth(w);
		rect.setHeight(h);
		System.out.println("���ζ���Ŀ�" + rect.getWidth() + "�ߣ�" + rect.height);
		System.out.println("���ε������" + rect.getArea());
		w = 100;
		h = 256;			//�˸Ķ�������Ӱ��rect��Width �� Height ��ֵ
		System.out.println("���ζ���Ŀ�" + rect.getWidth() + "�ߣ�" + rect.getHeight());
	}

}

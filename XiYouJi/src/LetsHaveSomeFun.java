
public class LetsHaveSomeFun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XiyoujiRenwu zhubajie = null, sunwukong = null;
		zhubajie = new XiyoujiRenwu();
		sunwukong = new XiyoujiRenwu();
		zhubajie.name = PersonName.�˽�;
		zhubajie.height = 1.83f;
		zhubajie.weight = 86f;
		zhubajie.head = "��ͷ";
		sunwukong.name = PersonName.���;
		sunwukong.height = 1.66f;
		sunwukong.weight = 1000f;
		sunwukong.head = "��ͷ";
		System.out.println(zhubajie.name + "�����:" +zhubajie.height );
		System.out.println(zhubajie.name + "��ͷ" + zhubajie.head);
		zhubajie.speak(zhubajie.name + "����Ȣϱ��");
		System.out.println(zhubajie.name + "���ڵ�ͷ��" + zhubajie.head);
	}

}

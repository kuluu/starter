
public class LetsHaveSomeFun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XiyoujiRenwu zhubajie = null, sunwukong = null;
		zhubajie = new XiyoujiRenwu();
		sunwukong = new XiyoujiRenwu();
		zhubajie.name = PersonName.八戒;
		zhubajie.height = 1.83f;
		zhubajie.weight = 86f;
		zhubajie.head = "猪头";
		sunwukong.name = PersonName.悟空;
		sunwukong.height = 1.66f;
		sunwukong.weight = 1000f;
		sunwukong.head = "猴头";
		System.out.println(zhubajie.name + "的身高:" +zhubajie.height );
		System.out.println(zhubajie.name + "的头" + zhubajie.head);
		zhubajie.speak(zhubajie.name + "我想娶媳妇");
		System.out.println(zhubajie.name + "现在的头：" + zhubajie.head);
	}

}

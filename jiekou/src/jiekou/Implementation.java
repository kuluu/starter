package jiekou;
interface Advertisement{
	public abstract void showAd();
	public abstract String getCorpName();
}

class Board{
	Advertisement adver;
	public void setAd(Advertisement adver)
	{
		this.adver = adver;
	}
	public void show()
	{
		if(adver != null)
		{
			System.out.println("广告牌显示" + adver.getCorpName() + "公司的广告词");
			adver.showAd();
		}
		else
			System.out.println("guangaopai wuguanggao ");
	}
}


class Apple implements Advertisement{
	public void showAd()
	{
		System.out.println("i donot know!");
	}
	public String getCorpName()
	{
		return "Apple";
	}
}

public class Implementation {
	public static void main(String []args)
	{
		Board board = new Board();
		board.setAd(new Apple());
		board.show();
		
	}
}

import java.io.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ex {
    public static void main(String[] args){
    	IO io=new IO();
    	io.input();
    	io.fen();
    	io.createFile("D:\\Java\\ʵ��8\\score.xls");
    	io.output();
    }
}
class IO{
	String[] mags=new String[10]; //��¼�ı�����������
	double[] score1=new double[10];//��¼�ܳɼ�
	int row=0; //��¼�ļ�����
	File file;
	//��ָ��·���´����ܳɼ�.xls�ļ���
	void createFile(String fileName) {  
		File file = new File(fileName);
		if (!file.exists()) {
			try{
                file.createNewFile();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
		this.file=file;	
	}
	//���ļ�score.txt�ж�ȡ��Ϣ
	void input() {
    	try{
    		File file=new File("D:\\Java\\ʵ��8\\score.txt");
    		FileReader in =new FileReader(file);
    		BufferedReader buff = new BufferedReader(in);
    		while((mags[row++]=buff.readLine())!=null){
    		}
    		in.close();
    		buff.close();
    	} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	//ͨ���������ʽ�ֽ�����ÿһ���ַ��������ֵ����������ܳɼ�
	void fen() {
		for(int i=1;i<row-1;i++) {
			score1[i]=getTotalScore(mags[i]);
		}
	}
	double getTotalScore(String s) { 
		String[] s1=s.split("\\s+");
		return Integer.parseInt(s1[3])*0.3+Integer.parseInt(s1[4])*0.7;
	}
	//����ʽҪ����Ϣд�롱�ܳɼ�.xls��
	void output() {  
		XSSFWorkbook xssfworkbook = new XSSFWorkbook();
		XSSFSheet sheet=xssfworkbook.createSheet("score");
		XSSFRow row0 = sheet.createRow(0); 
		row0.createCell(0).setCellValue("ѧ��");
		row0.createCell(1).setCellValue("����");
		row0.createCell(2).setCellValue("������");
		row0.createCell(3).setCellValue("ƽʱ�ɼ�");
		row0.createCell(4).setCellValue("���Գɼ�");
		row0.createCell(5).setCellValue("�ܳɼ�");
		for(int i=1;i<row-1;i++) {
			XSSFRow row1 = sheet.createRow(i);
			String[] s1=mags[i].split("\\s+");
			row1.createCell(0).setCellValue(s1[0]);
			row1.createCell(1).setCellValue(s1[1]);
			row1.createCell(2).setCellValue(s1[2]);
			row1.createCell(3).setCellValue(Integer.parseInt(s1[3]));
			row1.createCell(4).setCellValue(Integer.parseInt(s1[4]));
			row1.createCell(5).setCellValue(score1[i]);
		}
		try{
			FileOutputStream out = new FileOutputStream(file);
			xssfworkbook.write(out);
			out.flush();
			out.close();
		}catch(IOException e) {
    		System.out.println(e);
    	}
	}
}
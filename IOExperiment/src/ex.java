import java.io.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ex {
    public static void main(String[] args){
    	IO io=new IO();
    	io.input();
    	io.fen();
    	io.createFile("D:\\Java\\实验8\\score.xls");
    	io.output();
    }
}
class IO{
	String[] mags=new String[10]; //记录文本读出的数据
	double[] score1=new double[10];//记录总成绩
	int row=0; //记录文件行数
	File file;
	//在指定路径下创建总成绩.xls文件。
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
	//从文件score.txt中读取信息
	void input() {
    	try{
    		File file=new File("D:\\Java\\实验8\\score.txt");
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
	//通过正则表达式分解读入的每一行字符串获得数值，并计算出总成绩
	void fen() {
		for(int i=1;i<row-1;i++) {
			score1[i]=getTotalScore(mags[i]);
		}
	}
	double getTotalScore(String s) { 
		String[] s1=s.split("\\s+");
		return Integer.parseInt(s1[3])*0.3+Integer.parseInt(s1[4])*0.7;
	}
	//按格式要求将信息写入”总成绩.xls”
	void output() {  
		XSSFWorkbook xssfworkbook = new XSSFWorkbook();
		XSSFSheet sheet=xssfworkbook.createSheet("score");
		XSSFRow row0 = sheet.createRow(0); 
		row0.createCell(0).setCellValue("学号");
		row0.createCell(1).setCellValue("姓名");
		row0.createCell(2).setCellValue("行政班");
		row0.createCell(3).setCellValue("平时成绩");
		row0.createCell(4).setCellValue("考试成绩");
		row0.createCell(5).setCellValue("总成绩");
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
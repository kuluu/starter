import java.io.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class Experiment {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		createFile("总成绩.xls");
		File f = new File("D:\\Java\\实验8","score.txt");
		FileReader in = new FileReader(f);
		BufferedReader in2 = new BufferedReader(in);
		String title = null;
		String stu[];
		stu = new String[10];
		double total[];
		total = new double[20];
		try {
			title = in2.readLine();
			int i=0;
			
			while((stu[i] = in2.readLine())!=null)
			{
				
				total[i] = getTotalScore(stu[i]);

				i++;
			}	
			in2.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream fileIn = new FileInputStream("D:\\Java\\实验8\\总成绩.xls");
			Workbook wb = new HSSFWorkbook(fileIn);
			HSSFSheet sheet = (HSSFSheet)wb.createSheet("final grade");
			int rowNum=7;	//Excel表的行数
			int colNum=6;	//Excel表的列数
			HSSFRow row=null;
			int j=0;
			for(int i=0; i<rowNum; i++) {
				//3. 创建HSSFRow对象  
				row = sheet.createRow(i); 
				
				if(i==0){//创建表头
		//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  
					HSSFCell cell=row.createCell(0);  
					//设置单元格内容  
					cell.setCellValue("学员考试成绩一览表");  
/*合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列  */
					sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));  
				}
				
				if(i==1) {//在sheet里创建第二行
					//创建单元格并设置单元格内容  
					row.createCell(0).setCellValue("学号");  
					row.createCell(1).setCellValue("姓名");      
					row.createCell(2).setCellValue("行政班");  
					row.createCell(3).setCellValue("平时成绩"); 
					row.createCell(4).setCellValue("考试成绩"); 
					row.createCell(5).setCellValue("总成绩"); 
				}
				if(i>=2) {//在sheet里创建第三行  
					String[] grade;
					String regex = "\\s+";
					grade = stu[j].split(regex);
					double m,n;
					m = (float)Integer.parseInt(grade[3]);
					n = (float)Integer.parseInt(grade[4]);
					
					
					
					row.createCell(0).setCellValue(grade[0]);  
					row.createCell(1).setCellValue(grade[1]);  
					row.createCell(2).setCellValue(grade[2]);      
					row.createCell(3).setCellValue(m);   
					row.createCell(4).setCellValue(n); 
					row.createCell(5).setCellValue(total[j]);
					j++;
				}
			}
			
			//输出Excel文件  
			File outputFolder=new File("D:\\Java\\实验8");
			//创建Demo文件夹
			if(!outputFolder.exists())
				outputFolder.mkdir();			
			//创建文件
			File outputFile=new File(outputFolder, "总成绩.xls");
			if(!outputFile.exists())
				outputFile.createNewFile();
			
			FileOutputStream fout=new FileOutputStream(outputFile);			
			wb.write(fout);  	//Workbook提供了write的方法
			fout.flush();  
			fout.close();		//将输出流关闭			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}		
		
		
		
		
	}
	static void createFile(String fileName)
	{
		//输出Excel文件  
		File outputFolder=new File("D:\\Java\\实验8");
		//创建Demo文件夹
		if(!outputFolder.exists())
			outputFolder.mkdir();			
		//创建文件
		File outputFile=new File(outputFolder, "总成绩.xls");
		if(!outputFile.exists())
			try {
				outputFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	static double getTotalScore(String s)
	{
		String[] grade;
		String regex = "\\D+";
		grade = s.split(regex);
		double m,n;
		m = (double)Integer.parseInt(grade[2]);
		n = (double)Integer.parseInt(grade[3]);
		return (m *0.3 +n * 0.7);
	}

}

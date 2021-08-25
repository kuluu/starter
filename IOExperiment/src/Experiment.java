import java.io.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class Experiment {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		createFile("�ܳɼ�.xls");
		File f = new File("D:\\Java\\ʵ��8","score.txt");
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
			FileInputStream fileIn = new FileInputStream("D:\\Java\\ʵ��8\\�ܳɼ�.xls");
			Workbook wb = new HSSFWorkbook(fileIn);
			HSSFSheet sheet = (HSSFSheet)wb.createSheet("final grade");
			int rowNum=7;	//Excel��������
			int colNum=6;	//Excel��������
			HSSFRow row=null;
			int j=0;
			for(int i=0; i<rowNum; i++) {
				//3. ����HSSFRow����  
				row = sheet.createRow(i); 
				
				if(i==0){//������ͷ
		//������Ԫ��excel�ĵ�Ԫ�񣬲���Ϊ��������������0��255֮����κ�һ��  
					HSSFCell cell=row.createCell(0);  
					//���õ�Ԫ������  
					cell.setCellValue("ѧԱ���Գɼ�һ����");  
/*�ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������  */
					sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));  
				}
				
				if(i==1) {//��sheet�ﴴ���ڶ���
					//������Ԫ�����õ�Ԫ������  
					row.createCell(0).setCellValue("ѧ��");  
					row.createCell(1).setCellValue("����");      
					row.createCell(2).setCellValue("������");  
					row.createCell(3).setCellValue("ƽʱ�ɼ�"); 
					row.createCell(4).setCellValue("���Գɼ�"); 
					row.createCell(5).setCellValue("�ܳɼ�"); 
				}
				if(i>=2) {//��sheet�ﴴ��������  
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
			
			//���Excel�ļ�  
			File outputFolder=new File("D:\\Java\\ʵ��8");
			//����Demo�ļ���
			if(!outputFolder.exists())
				outputFolder.mkdir();			
			//�����ļ�
			File outputFile=new File(outputFolder, "�ܳɼ�.xls");
			if(!outputFile.exists())
				outputFile.createNewFile();
			
			FileOutputStream fout=new FileOutputStream(outputFile);			
			wb.write(fout);  	//Workbook�ṩ��write�ķ���
			fout.flush();  
			fout.close();		//��������ر�			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}		
		
		
		
		
	}
	static void createFile(String fileName)
	{
		//���Excel�ļ�  
		File outputFolder=new File("D:\\Java\\ʵ��8");
		//����Demo�ļ���
		if(!outputFolder.exists())
			outputFolder.mkdir();			
		//�����ļ�
		File outputFile=new File(outputFolder, "�ܳɼ�.xls");
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
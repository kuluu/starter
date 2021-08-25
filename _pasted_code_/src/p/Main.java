package p;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
public class Main {
    static List<String> listdata = new ArrayList<>();
    static int rowNum;//��
    static int columnNum;//��
    static String[][] listdata2;
    public static void main(String[] args) throws IOException {
        input();
        Strings();//�����������String�����������ܳɼ�
        Blankplace();//�������ո�
        createFile("�ܳɼ�.xls");
        HSSFWorkbook wb = new HSSFWorkbook();
        wb=WB();
        output(wb);
    }
    public static void input() {
        try {
            FileReader fr = new FileReader("F:\\CUIT�¼���\\Javaѧϰ\\ʵ��\\score.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            line= br.readLine();
            while(line!=null) {
                if (!line.endsWith("\t"))
                    line=line+"\t";
                listdata.add(line);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void Strings() {
    	int i=0;
        String temp = listdata.get(0);
        listdata.set(0,temp+"�ܳɼ�");
        for(String s:listdata) {//�����󸶸�s
            if(i==0) {
                i++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("\t");
            sb.append(getTotalScore(s));//�����ܳɼ�
            s= String.valueOf(sb);
            listdata.set(i++,s);
        }
    }
    public static void Blankplace(){
    	rowNum=listdata.size();
    	listdata2 = new String[listdata.size()][];
        int count=0; 
        for(String s:listdata) {
            s=s.replaceAll(" ","");
            s=s.replaceAll("\t"," ");
            listdata2[count++]=s.replaceAll(" +"," ").split(" ");
        }
    }
    public static HSSFWorkbook WB() {
    	int i=0;
    	HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet=(HSSFSheet)wb.createSheet("�ɼ���");
        HSSFRow row = null;
        for ( i=0; i<rowNum; i++) {
        	//������������������Ԫ��
            row=sheet.createRow(i);
            for (int j=0; j<columnNum; j++) {
            	HSSFCell  cell=row.createCell(j); 
            }
        }
        for(i=0;i<=sheet.getLastRowNum();i++) {//�������һ�е�����������������С1
            Row r=sheet.getRow(i);
            for(int j=0;j<r.getLastCellNum();j++) {//���ص������һ�е�������������������
                r.getCell(j).setCellValue(listdata2[i][j]);
            }
        }
        return wb;
    }
    public static void createFile(String fileName) {
    	
        File outputFile = new File("F:\\CUIT�¼���\\Javaѧϰ\\ʵ��",fileName);
        if(!outputFile.exists()) {//�ļ������ھʹ������ļ�
            try {
            	outputFile.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static double getTotalScore(String s) {
        String[] score = s.split("\t");  //��Tab���зָ�
        columnNum= score.length;
        return   Double.parseDouble(score[3])*0.3 + Double.parseDouble(score[4])*0.7;
        //ת����double�ʹ���
    }
    public static void output(Workbook wb) {
    	//ʹ������������������Excel�ļ���
        try {
            File file = new File("F:\\CUIT�¼���\\Javaѧϰ\\ʵ��\\�ܳɼ�.xls");
            FileOutputStream fout = new FileOutputStream(file);
            wb.write(fout);
            fout.flush();
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
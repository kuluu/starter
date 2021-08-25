package p;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
public class Main {
    static List<String> listdata = new ArrayList<>();
    static int rowNum;//行
    static int columnNum;//列
    static String[][] listdata2;
    public static void main(String[] args) throws IOException {
        input();
        Strings();//将读入的数据String化，并计算总成绩
        Blankplace();//处理多余空格
        createFile("总成绩.xls");
        HSSFWorkbook wb = new HSSFWorkbook();
        wb=WB();
        output(wb);
    }
    public static void input() {
        try {
            FileReader fr = new FileReader("F:\\CUIT事件薄\\Java学习\\实验\\score.txt");
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
        listdata.set(0,temp+"总成绩");
        for(String s:listdata) {//遍历后付给s
            if(i==0) {
                i++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("\t");
            sb.append(getTotalScore(s));//计算总成绩
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
        HSSFSheet sheet=(HSSFSheet)wb.createSheet("成绩表");
        HSSFRow row = null;
        for ( i=0; i<rowNum; i++) {
        	//按所需行列数创建单元格
            row=sheet.createRow(i);
            for (int j=0; j<columnNum; j++) {
            	HSSFCell  cell=row.createCell(j); 
            }
        }
        for(i=0;i<=sheet.getLastRowNum();i++) {//返回最后一行的索引，即比行总数小1
            Row r=sheet.getRow(i);
            for(int j=0;j<r.getLastCellNum();j++) {//返回的是最后一列的列数，即等于总列数
                r.getCell(j).setCellValue(listdata2[i][j]);
            }
        }
        return wb;
    }
    public static void createFile(String fileName) {
    	
        File outputFile = new File("F:\\CUIT事件薄\\Java学习\\实验",fileName);
        if(!outputFile.exists()) {//文件不存在就创建新文件
            try {
            	outputFile.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static double getTotalScore(String s) {
        String[] score = s.split("\t");  //以Tab进行分割
        columnNum= score.length;
        return   Double.parseDouble(score[3])*0.3 + Double.parseDouble(score[4])*0.7;
        //转换成double型处理
    }
    public static void output(Workbook wb) {
    	//使用输出流把数据输出到Excel文件里
        try {
            File file = new File("F:\\CUIT事件薄\\Java学习\\实验\\总成绩.xls");
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
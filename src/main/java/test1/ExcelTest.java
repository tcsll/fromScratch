package test1;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelTest {
    public static void main(String[] args) {
        String path = "C:/Users/lenovo/Desktop/1.24 动态数据透视表.xlsx";
        List list = doRead(path);
        list = doWrite(list);
        for(int i =0;i< list.size();i++){
            System.out.println("第"+i+"行:"+list.get(i));
        }
    }



    static List<String> doWrite(List<String> opList) {
        for(int i =0;i<opList.size();i++){
            if(i==7) {
                String str = opList.get(i);
                str = str + "啊啊a";
                opList.set(i, str);
            }

            if(i==9) {
                String str = opList.get(i);
                str = str + "啊啊a";
                opList.set(i, str);
            }
        }

        return opList;
    }




    static List<String> doRead(String pathName) {
        List<String> result = new ArrayList<>();
        try {
            File file = new File(pathName);
            FileInputStream fs = new FileInputStream(file.getAbsolutePath());
            //2003.xls文件
            HSSFWorkbook hwb = null;
            //2007.xlsx文件
            XSSFWorkbook xwb = null;
            //表格（第一个 index=0）
            Sheet sheet = null;
            if (pathName.contains(".xlsx")) {
                xwb = new XSSFWorkbook(fs);
                sheet = xwb.getSheetAt(0);
            } else {
                hwb = new HSSFWorkbook(fs);
                sheet = hwb.getSheetAt(0);
            }
            int firstRowNum = sheet.getFirstRowNum();
            int lastRowNum = sheet.getLastRowNum();
            for (int i = firstRowNum; i <= lastRowNum; i++) {
                StringBuilder sb = new StringBuilder();
                //取得第i行 （第一行i=0是表头）
                Row row = sheet.getRow(i);
                if (row != null) {
                    int cellNum = row.getPhysicalNumberOfCells();
                    for (int cell = 0; cell < cellNum; cell++) {
                        row.getCell(cell).setCellType(CellType.STRING);
                        String rowStr = row.getCell(cell).getStringCellValue();
                        sb.append(rowStr).append("|");
                    }
                }
                String str = sb.toString();
                str = str.substring(0, str.length() - 1);
                System.out.println("第" + i + "行：" + str);
                result.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }




}

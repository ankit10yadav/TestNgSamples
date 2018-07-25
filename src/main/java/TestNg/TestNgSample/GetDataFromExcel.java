package TestNg.TestNgSample;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.tools.ant.util.StringTokenizer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class GetDataFromExcel 
{
	public static String path="/Users/ankitverma/Documents/workspace-sts-3.9.4.RELEASE/TestNgSample/src/main/java/TestNg/TestNgSample/data.xlsx";
	public static Workbook workbook;
	public static ArrayList<String[]> al = new ArrayList<String[]>();
	//public static String[] Stemp=new String[2];
	public static ArrayList<String[]> getdata()
	{
		
		try 
		{
			workbook = WorkbookFactory.create(new File(path));
		} catch (EncryptedDocumentException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) 
        	{
        	String[] Stemp=new String[2];
        	int i=0;
            Row row = rowIterator.next();
            if(row.getRowNum()==0)
            	row=rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            	while (cellIterator.hasNext()) 
            	{
            		Cell cell = cellIterator.next();
            		String cellValue = dataFormatter.formatCellValue(cell);
            		//System.out.println(cellValue);
            		Stemp[i]=cellValue;
            		
            		i++;
            		
            	}
           al.add(Stemp);
           // System.out.println();
        	}

        /*System.out.println(al.get(0)[0]);
        System.out.println(al.get(0)[1]);
        System.out.println(al.get(1)[0]);
        System.out.println(al.get(1)[1]);*/
        return al;
        
	}
}


package parsers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class XLSParser {

	final static String filePath = "src\\main\\resources\\parser.xls";
	private HashMap<Integer, ArrayList<String>> table;

	public static void main(String[] args) {
		xlsParser();
	}
	
	public static List<String> xlsParser() {
		List<String> city = new ArrayList<String>();
	try {
		InputStream file = new FileInputStream(filePath);
		HSSFWorkbook wb = new HSSFWorkbook(file);
 
		HSSFSheet sheet=wb.getSheetAt(0);
		HSSFRow currentRow = null;
		HSSFCell currentCell = null;
		int currentRowNumber = 1; 
		int currentCellNumber = 0;
		ArrayList<String> row = new ArrayList<String>();
		while ((currentRow = sheet.getRow(currentRowNumber)) != null) {
			city.add(currentRow.getCell((short) 0).getStringCellValue());
		    currentRowNumber++;
			currentCellNumber = 0;
		}
		file.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return city;
}
	
//	public static HashMap<Integer, ArrayList<String>> getFullTable() {
//		HashMap<Integer, ArrayList<String>> table = new HashMap<Integer, ArrayList<String>>();
//		try {
//			FileInputStream file = new FileInputStream(new File(filePath));
//			
//			HSSFWorkbook workbook = new HSSFWorkbook(file);
//			HSSFSheet sheet = workbook.getSheetAt(0);
//			
//			HSSFRow currentRow = null;
//			HSSFCell currentCell = null;
//			int currentRowNumber = 0; 
//			int currentCellNumber = 0;
//			int rowNumber = 1; 
//			
//			while ((currentRow = sheet.getRow(currentRowNumber)) != null) {
//				ArrayList<String> row = new ArrayList<String>();
//				while ((currentCell = currentRow.getCell(currentCellNumber)) != null) {
//					row.add(currentCell.toString());
//					currentCellNumber++;
//				}
//				System.out.println(row);
//				table.put(rowNumber,row);
//				currentRowNumber++;
//				currentCellNumber = 0;
//				rowNumber++;
//			}
//System.out.println(table);
//			file.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return table;
//	}
//	
//	public ArrayList<String> getTableRow(String rowNumber) {
//		ArrayList<String> row = new ArrayList<String>();
//		if (table == null) {
//			table = getFullTable();
//		}
//		if(Integer.parseInt(rowNumber) < table.keySet().size()) {
//			row = table.get(rowNumber);
//		}
//
//		return row;
//	}
	
	
}


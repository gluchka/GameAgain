package parsers;



	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

	public class Myself {


		final static String filePath = "src\\main\\resources\\parser.txt";
		private List<ArrayList<String>> table;

		public static void main(String[] args) {
			getFullTable();
		}
		
		
		public static List<ArrayList<String>> getFullTable() {
			List< ArrayList<String>> table = new ArrayList< ArrayList<String>>();
			try {
				FileInputStream file = new FileInputStream(filePath);
				
				HSSFWorkbook workbook = new HSSFWorkbook(file);
				HSSFSheet sheet = workbook.getSheetAt(0);
				
				HSSFRow currentRow = null;
				HSSFCell currentCell = null;
				int currentRowNumber = 0; 
				int currentCellNumber = 0;
				int rowNumber = 1; 
				
				while ((currentRow = sheet.getRow(currentRowNumber)) != null) {
					ArrayList<String> row = new ArrayList<String>();
					while ((currentCell = currentRow.getCell(currentCellNumber)) != null) {
						row.add(currentCell.toString());
						currentCellNumber++;
					}
//					System.out.println(row);
					table.add(row);
//					table.put(rowNumber,row);
					currentRowNumber++;
					currentCellNumber = 0;
					rowNumber++;
				}
		
			
				file.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return table;
		}
		
		public ArrayList<String> getTableRow(int rowNumber) {
			ArrayList<String> row = new ArrayList<String>();
			if (table == null) {
				table = getFullTable();
			}
			if(rowNumber < table.size()) {
				row = table.get(rowNumber);
				
			}

			return row;
		}
		
		
	}



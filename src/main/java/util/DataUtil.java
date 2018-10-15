package util;

import java.util.Hashtable;

public class DataUtil {

	public static Object[][] getData(Xls_Reader xls, String testCaseName) {

		// D:\Selenium\Workspace\POMWithPF
		String sheetName = Constants.DATA_XLS_SHEET;
		int testStartRow = 1;
		
		System.out.println(xls.getCellData(sheetName, 0, testStartRow));
		while (!xls.getCellData(sheetName, 0, testStartRow).equals(testCaseName)) {
			testStartRow++;
		}
		System.out.println("test row starts: " + testStartRow);

		
		
		int colStartRowNum = testStartRow + 1;
		int dataStartRowNum = testStartRow + 2;

		// calculate number colnumber

		int cols = 0;
		while (!xls.getCellData(sheetName, cols, colStartRowNum).equals("")) {
			cols++;
		}
		System.out.println("total number of col: " + cols);

		
		
		int rows = 0;
		while (!xls.getCellData(sheetName, 0, dataStartRowNum + rows).equals("")) {
			rows++;
		}
		System.out.println("total number of rows: " + rows);

		
		
		Object[][] data = new Object[rows][1];

		
		int dataRow = 0;
		Hashtable<String, String> table;
		for (int rowNum = dataStartRowNum; rowNum < dataStartRowNum + rows; rowNum++) {
			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {
				String key = xls.getCellData(sheetName, colNum, colStartRowNum);
				String value = xls.getCellData(sheetName, colNum, rowNum);
				table.put(key, value);

//				data[dataRow][colNum] = xls.getCellData("Data", colNum, rowNum);
				// 0,0 0,1 1,0 ...
			}
			data[dataRow][0] = table;
			dataRow++;
		}

		return data;

	}

	public static boolean isTestExecutable(Xls_Reader xls, String testCaseName) {
		int rows = xls.getRowCount(Constants.TESTCASE_XLS_SHEET);
		for (int rNum = 2; rNum <= rows; rNum++) {
			String testName = xls.getCellData(Constants.TESTCASE_XLS_SHEET, Constants.TESTCASENAME_XLS, rNum);
			if (testName.equals(testCaseName)) {
				String runMode = xls.getCellData(Constants.TESTCASE_XLS_SHEET, Constants.RUNMODE_XLS, rNum);
				if (runMode.equals("Y")) {
					return true;
				} else
					return false;
			}
		}
		return false;
	}
	
	

}

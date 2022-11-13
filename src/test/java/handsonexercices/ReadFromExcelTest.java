package handsonexercices;


import org.testng.annotations.Test;

import util.Helper;

public class ReadFromExcelTest {

@Test
public void testReadFromExcecl() {
	String fpath="src/test/resources/TestExcel.xls";
	String sheetname="login";
	int rownum=3;
	int colnum=3;
	Helper help=new Helper();
	Object value=help.readFromExcel(fpath, sheetname, rownum, colnum);
	System.out.println(value);
	
}
}

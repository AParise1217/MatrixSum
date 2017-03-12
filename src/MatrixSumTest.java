import static org.junit.Assert.*;

import org.junit.*;

public class MatrixSumTest {


	@Test
	public void testMain() {
		int[][] testDataSet1 = {{3, 5, 7, 9}, {33, 44, 12, 15}, {1, 45, 67, 88}, {66, 54, 99, 5}};
		int[][] testDataSet2 = {{2,4,6,8}, {10,12,14,16}, {18,20,22,24}, {26,28,30,32}};
		int[][] testDataSet3 = {{3,6,9,12}, {15,18,21,24}, {27,30,33,36}, {39,42,45,48}};
		
		
		MatrixSum ms1 = new MatrixSum(testDataSet1);
		MatrixSum ms2 = new MatrixSum(testDataSet2);
		MatrixSum ms3 = new MatrixSum(testDataSet3);

		boolean testTotal = (ms1.sumValues.get("totalSum") == (3+5+7+9+33+44+12+15+1+45+67+88+66+54+99+5));
		boolean testColSum = (ms2.sumValues.get("col2Sum") == (6+14+22+30));
		boolean testDiagSum = ((ms2.sumValues.get("leftDiagSum") == (2+12+22+32)) && (ms3.sumValues.get("rightDiagSum") == (12+21+30+39)));
		boolean testNumRows = (ms1.sumValues.get("numRows") == 4);
		boolean testNumCols = (ms3.sumValues.get("numCols") == 4);
		
		assertTrue("testTotal failed", testTotal);
		assertTrue("testColSum failed", testColSum);	
		assertTrue("testDiagSum failed", testDiagSum);
		assertTrue("testNumRows failed",testNumRows);
		assertTrue("testNumCols failed", testNumCols);
	}

}

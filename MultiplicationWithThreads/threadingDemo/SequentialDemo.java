package threadingDemo;



public class SequentialDemo {
	
	
	public static int[][] multiply(int[][] a, int[][] b) {
	       int rowsInA = a.length;
	       int columnsInA = a[0].length; // same as rows in B
	       int columnsInB = b[0].length;
	       int[][] c = new int[rowsInA][columnsInB];
	       for (int i = 0; i < rowsInA; i++) {
	           for (int j = 0; j < columnsInB; j++) {
	               for (int k = 0; k < columnsInA; k++) {
	                   c[i][j] += a[i][k] * b[k][j];
	               }
	           }
	       }
	       return c;
	   }
	public static void showMatrix(int [][] c){
		for (int i = 0; i < c.length; i++) {
	           for (int j = 0; j < c[0].length; j++) {
	               System.out.print(c[i][j] + " ");
	           }
	           System.out.println();
	       }
	}
	public static int[][] populateMatrix(int [][] a){
		int rowsInA = a.length;
	    int columnsInA = a[0].length;
		for (int i = 0; i < rowsInA; i++) {
			for (int j = 0; j < columnsInA; j++) {
				a[i][j]=(int)(Math.random()*3+1);
			}
		}
		return a;
	}
}

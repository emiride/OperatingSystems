package threadingDemo;

import java.util.ArrayList;

public class ThreadingDemo3 {

	private static int[][] matrix1;
	private static int[][] matrix2;
	private static int[][] matrixResult;

	public static int[][] multiply(int[][] a, int[][] b) {
		matrix1=a;
		matrix2=b;
		matrixResult = new int[a.length][b.length];
		int n = matrix1.length;
		int count = 0;
		ArrayList<Thread> workerList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
				Thread t = new Thread(new MyThread(count,(n/4)*i+1));
				t.start();
				workerList.add(t);
				count = (n/4)*i+1;
		}

		for (Thread t : workerList) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return matrixResult;
	}
	
	static class MyThread implements Runnable {

		private int fromRow;
		private int toRow;

		public MyThread(int fromRow, int toRow) {
			this.fromRow = fromRow;
			this.toRow = toRow;
		}

		@Override
		public void run() {

		       int columnsInA = matrix1[0].length; // same as rows in B
		       int columnsInB = matrix2[0].length;
		       for (int i = fromRow; i < toRow; i++) {
		           for (int j = 0; j < columnsInB; j++) {
		               for (int k = 0; k < columnsInA; k++) {
		                   matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
		               }
		           }
		       }
		}

	}

	public static void showMatrix(int[][] c) {
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] populateMatrix(int[][] a) {
		int rowsInA = a.length;
		int columnsInA = a[0].length;
		for (int i = 0; i < rowsInA; i++) {
			for (int j = 0; j < columnsInA; j++) {
				a[i][j] = (int) (Math.random() * 3 + 1);
			}
		}
		return a;
	}

	

}

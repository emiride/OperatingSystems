package threadingDemo;

import java.util.ArrayList;

public class ThreadingDemo {

	private static int[][] matrix1;
	private static int[][] matrix2;
	private static int[][] matrixResult;

	public static int[][] multiply(int[][] a, int[][] b) {
		matrix1=a;
		matrix2=b;
		matrixResult = new int[a.length][b.length];

		ArrayList<Thread> workerList = new ArrayList<>();

		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix2[0].length; j++) {
				Thread t = new Thread(new MyThread(i, j));
				t.start();
				workerList.add(t);
			}
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

	static class MyThread implements Runnable {

		private int row1;
		private int column2;

		public MyThread(int row1, int column2) {
			this.row1 = row1;
			this.column2 = column2;
		}

		@Override
		public void run() {
			int result = 0;

			for (int i = 0; i < matrix2.length; i++) {
				result += matrix1[row1][i] * matrix2[i][column2];
			}

			matrixResult[row1][column2] = result;
		}

	}

}

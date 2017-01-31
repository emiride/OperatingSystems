package threadingDemo;

import java.util.Scanner;
import java.io.*;

public class TestingClass {

	public static void main(String[] args) {
		
		
		int size = 4000;
		/*
		int[][] matrix1 = new int[size][size];
		int[][] matrix2 = new int[size][size];
		matrix1 = ThreadingDemo3.populateMatrix(matrix1);
		matrix2 = ThreadingDemo3.populateMatrix(matrix2);
		int [][] resultMatrix = ThreadingDemo3.multiply(matrix1,matrix2);
		ThreadingDemo3.showMatrix(matrix1);
		System.out.println();
		ThreadingDemo3.showMatrix(matrix2);
		System.out.println();
		ThreadingDemo3.showMatrix(resultMatrix);*/
		System.out.print("\tSequential: \tThreaded2: \tThreaded3");
		for (int i = 4; i <= size; i+=4) {
			System.out.println();
			long startTime = System.currentTimeMillis();
			int[][] matrix1 = new int[i][i];
			int[][] matrix2 = new int[i][i];
			matrix1 = SequentialDemo.populateMatrix(matrix1);
			matrix2 = SequentialDemo.populateMatrix(matrix2);
			int [][] resultMatrix = SequentialDemo.multiply(matrix1,matrix2);
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.print(i+"x"+i+": ");
			System.out.print("\t\t"+(double)elapsedTime);
			
			/*startTime = System.currentTimeMillis();
			matrix1 = new int[i][i];
			matrix2 = new int[i][i];
			matrix1 = ThreadingDemo.populateMatrix(matrix1);
			matrix2 = ThreadingDemo.populateMatrix(matrix2);
			resultMatrix = ThreadingDemo.multiply(matrix1,matrix2);
			stopTime = System.currentTimeMillis();
			elapsedTime = stopTime - startTime;
			System.out.print("\t\t"+(double)elapsedTime);*/
			
			startTime = System.currentTimeMillis();
			matrix1 = new int[i][i];
			matrix2 = new int[i][i];
			matrix1 = ThreadingDemo2.populateMatrix(matrix1);
			matrix2 = ThreadingDemo2.populateMatrix(matrix2);
			resultMatrix = ThreadingDemo2.multiply(matrix1,matrix2);
			stopTime = System.currentTimeMillis();
			elapsedTime = stopTime - startTime;
			System.out.print("\t\t"+(double)elapsedTime);
			
			startTime = System.currentTimeMillis();
			matrix1 = new int[i][i];
			matrix2 = new int[i][i];
			matrix1 = ThreadingDemo3.populateMatrix(matrix1);
			matrix2 = ThreadingDemo3.populateMatrix(matrix2);
			resultMatrix = ThreadingDemo3.multiply(matrix1,matrix2);
			stopTime = System.currentTimeMillis();
			elapsedTime = stopTime - startTime;
			System.out.print("\t\t"+(double)elapsedTime);
		}	
		
	}

}

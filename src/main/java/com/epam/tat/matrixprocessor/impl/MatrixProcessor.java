package com.epam.tat.matrixprocessor.impl;

import com.epam.tat.matrixprocessor.IMatrixProcessor;
import com.epam.tat.matrixprocessor.exception.MatrixProcessorException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Function Description:
 * Complete the functions below. All methods must work with matrices of the double type.
 *
 * Constraints:
 * 0 < m < 10
 * 0 < n < 10
 * where m - number of rows in matrix
 * where n - number of columns in matrix
 *
 * In case of incorrect input values or inability to perform a calculation, the method should throw an appropriate
 * exception.
 *
 */
public class MatrixProcessor implements IMatrixProcessor {
	public static void main(String[] args) {

		double[][] a;
		double[][] b;
		double[][] res;
		double det;

		Scanner input = new Scanner(System.in);

		int m,n,l,k;

		try {
			System.out.println("Enter размер матрицы m: ");
			m = input.nextInt();
			System.out.println("Enter размер матрицы n: ");
			n = input.nextInt();
			System.out.println("Enter размер по строкам второй матрицы l: ");
			l = input.nextInt();
			System.out.println("Enter размер по столбцам второй матрицы k: ");
			k = input.nextInt();

		}
		catch (InputMismatchException e) {
			System.out.println("\n Ошибка неверный формат размера матрицы! Описание: " + e);
			return;}


		if ((m>0&m<10)&(n>0&n<10)) {
			a=matGen(m,n);
			b=matGen(l,k);

			System.out.println();
			System.out.println("Матрица из случайных чисел: ");
			System.out.println();
			pM(a);
			IMatrixProcessor trans=new MatrixProcessor();
			res=trans.transpose(a);
			System.out.println("Матрица транспонированная: ");
			pM(res);
			res=trans.turnClockwise(a);
			System.out.println("Матрица повернутая по часовой на 90: ");
			pM(res);
			res= trans.multiplyMatrices(a,b);
			System.out.println("Первая матрица из случайных чисел: ");
			pM(a);
			System.out.println("Вторая матрица из случайных чисел: ");
			pM(b);
			System.out.println("Матрица, полученная их умножением: ");
			pM(res);
			det= trans.getMatrixDeterminant(a);
			System.out.println("Матрицы для вычисления детерминанта: ");
			pM(a);
			System.out.println("Ее детерминант равен: "+det);
			res= trans.getInverseMatrix(a);
			System.out.println("Вот что стало с матрицей для обращения:");
			pM(a);
			System.out.println("Зато обратная к ней матрица: ");
			pM(res);


		}
		else {System.out.println("Размер матрицы  должны быть целые положительные числа less than 10 ");}




	}
	static double[][] matGen(int m, int n) {
		Random random = new Random();
		double[][] arr = new double[m][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = rD3(random.nextDouble());
			}
		}
		return arr;

	}
	static double rD3(double x){
		BigDecimal bd = new BigDecimal(Double.toString(x));
		bd = bd.setScale(3, RoundingMode.HALF_UP);
		return  bd.doubleValue();
	}
	static void pM(double[][] matrix){
		System.out.println();
		for (int i = 0; i < matrix.length; i++, System.out.println()) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}

		}
		System.out.println();
	}
	static double[][] generateSubArray (double [][] A, int N, int j1){
		double [][] m;
		m = new double[N-1][];
		for (int k=0; k<(N-1); k++)
			m[k] = new double[N-1];

		for (int i=1; i<N; i++){
			int j2=0;
			for (int j=0; j<N; j++){
				if(j == j1)
					continue;
				m[i-1][j2] = A[i][j];
				j2++;
			}
		}
		return m;
	}


	/**
	 * Matrix transpose is an operation on a matrix where its rows become columns with the same numbers.
	 * Ex.:
	 * |1 2|			|1 3 5|
	 * |3 4|   ====>	|2 4 6|
	 * |5 6|
	 *
	 * @param matrix - matrix for transposition
	 * @return the transposed matrix
	 */
	@Override
	public double[][] transpose(double[][] matrix) {
		if((matrix==null)||(matrix.length==0)||(matrix[0].length==0)){
		throw new MatrixProcessorException("Матрицу нельзя транспонировать!");
		} else{
		double[][] trans_mat = new double[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				trans_mat[j][i] = matrix[i][j];
			}
		}


		//throw new UnsupportedOperationException("You need to implement this method");
		return trans_mat;}
	}

	/**
	 * The method flips the matrix clockwise.
	 * Ex.:
	 * * |1 2|			|5 3 1|
	 * * |3 4|   ====>	|6 4 2|
	 * * |5 6|
	 *
	 * @param matrix - rotation matrix
	 * @return rotated matrix
	 */
	@Override
	public double[][] turnClockwise(double[][] matrix) {
		if((matrix==null)||(matrix.length==0)||(matrix[0].length==0)){
			throw new MatrixProcessorException("Матрицу нельзя повернуть!");
		}else{
		double[][] rot_mat = new double[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				rot_mat[j][matrix.length-i-1] = matrix[i][j];
			}
		//throw new UnsupportedOperationException("You need to implement this method");

	}
		return rot_mat;}
	}

	/**
	 * This method multiplies matrix firstMatrix by matrix secondMatrix
	 *
	 * See {https://en.wikipedia.org/wiki/Matrix_multiplication}
	 *
	 * @param firstMatrix  - first matrix to multiply
	 * @param secondMatrix - second matrix to multiply
	 * @return result matrix
	 */
	@Override
	public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
		if((firstMatrix==null)||(firstMatrix.length==0)||(firstMatrix[0].length==0)||
				(secondMatrix==null)||(secondMatrix.length==0)||(secondMatrix[0].length==0 )){
			throw new MatrixProcessorException("Матрицы нельзя использовать!");
		} else {

			if (firstMatrix[0].length == secondMatrix.length) {
				double[][] resMat = new double[firstMatrix.length][secondMatrix[0].length];
				for (int i = 0; i < firstMatrix.length; i++) {
					for (int u = 0; u < secondMatrix[0].length; u++) {
						for (int j = 0; j < secondMatrix.length; j++) {

							resMat[i][u] += firstMatrix[i][j] * secondMatrix[j][u];
						}
					}
				}
				for (int i = 0; i < firstMatrix.length; i++) {
					for (int u = 0; u < secondMatrix[0].length; u++) {


						resMat[i][u] = rD3(resMat[i][u]);

					}
				}


				return resMat;

			} else throw new MatrixProcessorException("Матрицы нельзя перемножить");

			//throw new UnsupportedOperationException("You need to implement this method");
		}
	}

	/**
	 * This method returns the inverse of the matrix
	 *
	 * See {https://en.wikipedia.org/wiki/Invertible_matrix}
	 *
	 * @param matrix - input matrix
	 * @return inverse matrix for input matrix
	 */
	@Override
	public double[][] getInverseMatrix(double[][] matrix) {
		if((matrix==null)||(matrix.length==0)||(matrix[0].length==0)){
			throw new MatrixProcessorException("Матрицу нельзя обратить!");
		}else{
		int i,j,k;
		double[][] e = new double[matrix.length][matrix.length ];
        if ((getMatrixDeterminant(matrix)!=0)&(matrix.length==matrix[0].length)){
		//заполнение единичной матрицы
		for (i=0;i<matrix.length;i++){
			for (j=0;j<matrix.length;j++){
				if (i==j) e[i][j]=1;
				else e[i][j]=0;
			}
		}
//Задаём номер ведущей строки (сначала 0,1...size)
		for (k=0;k<matrix.length;k++){
			for (j=k+1;j<matrix.length;j++){
				matrix[k][j]=matrix[k][j]/matrix[k][k];//все элементы k-ой строки матрицы A, кроме k-ого и до него, делим на разрешающий элемент - a[k][k]
			}
			for (j=0;j<matrix.length;j++){
				e[k][j]=e[k][j]/matrix[k][k];//все элементы k-ой строки матрицы e, делим на разрешающий элемент - a[k][k]
			}
			matrix[k][k]=1.0;//элемент соответствующий  разрещающему - делим на самого себя(т.е получит. 1 )
//идём сверху вниз, обходя k-ую строку
			if (k>0) {//если номер ведущей строки не первый
				for (i=0;i<k;i++){   //строки, находящиеся выше k-ой
					for (j=0;j<matrix.length;j++){
						e[i][j]=e[i][j]-e[k][j]*matrix[i][k];//Вычисляем элементы матрицы e,идя по столбцам с 0 -ого  к последнему
					}
					for (j= matrix.length-1;j>=k;j--){
						matrix[i][j]=matrix[i][j]-matrix[k][j]*matrix[i][k];//Вычисляем элементы матрицы a,идя по столбцам с последнего к k-ому
					}
				}
			}
			for (i=k+1;i<matrix.length;i++){   //строки, находящиеся ниже k-ой
				for (j=0;j<matrix.length;j++){
					e[i][j]=e[i][j]-e[k][j]*matrix[i][k];
				}
				for (j= matrix.length-1;j>=k;j--){
					matrix[i][j]=matrix[i][j]-matrix[k][j]*matrix[i][k];
				}
			}
		}
			for(int l=0;l< matrix.length;l++)
			{
				for(int u=0;u<matrix[0].length;u++)
				{


					e[l][u]=rD3(e[l][u]);

				}
			}
		return e;
		}//На месте исходной матрицы должна получиться единичная а на месте единичной - обратная.
       else throw new MatrixProcessorException("Для неквадратных матриц и вырожденных матриц обратных матриц не существует.");
		//throw new UnsupportedOperationException("You need to implement this method");
	    }
	}

	/**
	 * This method returns the determinant of the matrix
	 *
	 * See {https://en.wikipedia.org/wiki/Determinant}
	 *
	 * @param matrix - input matrix
	 * @return determinant of input matrix
	 */
	@Override
	public double getMatrixDeterminant(double[][] matrix) {
		if((matrix==null)||(matrix.length==0)||(matrix[0].length==0)){
			throw new MatrixProcessorException("У матрицы нельзя посчитать детерминант!");
		}else{
		double res;
		double [][] m;
		if (matrix.length==matrix[0].length) {

			// Trivial 1x1 matrix
			if (matrix.length == 1) res = matrix[0][0];
				// Trivial 2x2 matrix
			else if (matrix.length == 2) res = matrix[0][0]*matrix[1][1] - matrix[1][0]*matrix[0][1];
				// NxN matrix
			else{
				res=0;
				for (int j1=0; j1<matrix.length; j1++){
					m = generateSubArray (matrix, matrix.length, j1);
					res += Math.pow(-1.0, 1.0+j1+1.0) * matrix[0][j1] * getMatrixDeterminant(m);
				}
			}

			return res;
		}
		else throw new MatrixProcessorException("Детерминант вычисляется только для квадратной мартицы");

		//throw new UnsupportedOperationException("You need to implement this method");
	}
	}
}

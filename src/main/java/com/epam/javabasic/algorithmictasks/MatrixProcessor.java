package com.epam.javabasic.algorithmictasks;

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
 * Created by anton_chyrko on 9/21/20.
 */
public class MatrixProcessor {

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
	public double[][] transpose(double[][] matrix) {
		throw new UnsupportedOperationException("You need to implement this method");
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
	public double[][] turnClockwise(double[][] matrix) {
		throw new UnsupportedOperationException("You need to implement this method");
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
	public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
		throw new UnsupportedOperationException("You need to implement this method");
	}

	/**
	 * This method returns the inverse of the matrix
	 *
	 * See {https://en.wikipedia.org/wiki/Invertible_matrix}
	 *
	 * @param matrix - input matrix
	 * @return inverse matrix for input matrix
	 */
	public double[][] getInverseMatrix(double[][] matrix) {
		throw new UnsupportedOperationException("You need to implement this method");
	}

	/**
	 * This method returns the determinant of the matrix
	 *
	 * See {https://en.wikipedia.org/wiki/Determinant}
	 *
	 * @param matrix - input matrix
	 * @return determinant of input matrix
	 */
	public double getMatrixDeterminant(double[][] matrix) {
		throw new UnsupportedOperationException("You need to implement this method");
	}
}

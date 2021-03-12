package com.epam.javabasic.algorithmictasks;

import com.epam.javabasic.algorithmictasks.impl.MatrixProcessor;
import org.junit.jupiter.api.BeforeEach;

/**
 * Created by anton_chyrko on 9/23/20.
 */
public abstract class AbstractTest {

	protected IMatrixProcessor testClass;

	@BeforeEach
	void setUp() {
		testClass = new MatrixProcessor();
	}

	protected String formMsg(double[][] actualMatrix, double[][] expectedMatrix) {
		return String.format("Wrong result of method \nactualMatrix : \n%s \nexpectedMatrix \n%s)",
				printMatrix(actualMatrix), printMatrix(expectedMatrix));
	}

	protected String formMsg(double actualDeterminant, double expectedDeterminant) {
		return String.format("Wrong result of method \nactualDeterminant : \n%s \nexpectedDeterminant \n%s)",
				actualDeterminant, expectedDeterminant);
	}

	private String printMatrix(double[][] matrix) {
		StringBuilder sb = new StringBuilder();
		for (double[] doubles : matrix) {
			for (double aDouble : doubles) {
				sb.append(String.format("%s \t", aDouble));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}

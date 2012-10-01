package pca;

import Jama.Matrix;

public class JamaSVDLearning {

	public static void main(String[] args) {
		double[][] array = { { 1, 0, 0, 0, 2 }, { 0, 0, 3, 0, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 4, 0, 0, 0 }, };

		Matrix matrix_a = new Matrix(array);
		
		
		
		double[][] v_array = matrix_a.svd().getV().getArray();
		double[][] s_array = matrix_a.svd().getS().getArray();
		double[][] u_array = matrix_a.svd().getU().getArray();

		System.out.println("==============v matrix===================");
		MatrixTool.showTwoDimensionArray(v_array);
		System.out.println("==============s matrix===================");
		MatrixTool.showTwoDimensionArray(s_array);
		System.out.println("==============u matrix===================");
		MatrixTool.showTwoDimensionArray(u_array);

		/*
		 * matrix_a.svd().getS().getArray(); matrix_a.svd().getV().getArray();
		 */

	}

	

}

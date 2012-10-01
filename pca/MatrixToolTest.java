package pca;

import Jama.EigenvalueDecomposition;
import Jama.Matrix;

public class MatrixToolTest {
	public static void main(String[] args) {

		MatrixToolTest matrix_tool_test = new MatrixToolTest();
		matrix_tool_test.getEigTest();

	}

	public void getColumnTest(int column_offset, Matrix matrix_input) {
		double[] gotten_column = MatrixTool.getColumn(column_offset,
				matrix_input);

		for (int i = 0; i < gotten_column.length; i++) {
			System.out.printf("%f\t", gotten_column[i]);
		}
		System.out.printf("\n");
	}

	public void minusColumnTest() {

		double[][] array_before = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.printf("#####################################\n");
		MatrixTool.showTwoDimensionArray(array_before);
		Matrix matrix_to_test = new Matrix(array_before);

		MatrixTool.minusColumn(2, matrix_to_test, 8.0);

		System.out.printf("#####################################\n");
		double[][] array_after = matrix_to_test.getArray();

		MatrixTool.showTwoDimensionArray(array_after);
	}

	public void getMinusedColumnTest() {

		double[][] array_before = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out
				.printf("################    orginal_matrix_before    #####################\n");

		Matrix matrix_to_test = new Matrix(array_before);
		MatrixTool.showTwoDimensionArray(matrix_to_test.getArray());

		Matrix new_matrix = MatrixTool.getminusedColumn(2, matrix_to_test, 8.0);

		System.out
				.printf("###############  new_matrix  ######################\n");

		MatrixTool.showTwoDimensionArray(new_matrix.getArray());

		System.out
				.printf("###############  orginal_matrix_after  ######################\n");

		MatrixTool.showTwoDimensionArray(matrix_to_test.getArray());

	}

	public void getCenterMatrixTest() {

		double[][] array_before = { { 10, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out
				.printf("################    orginal_matrix_before    #####################\n");

		Matrix matrix_to_test = new Matrix(array_before);
		MatrixTool.showTwoDimensionArray(matrix_to_test.getArray());
		
		
		Matrix new_matrix = MatrixTool.getCenterMatrix(matrix_to_test);

		System.out
				.printf("###############  new_matrix  ######################\n");

		MatrixTool.showTwoDimensionArray(new_matrix.getArray());

		System.out
		.printf("###############  orginal_matrix_after  ######################\n");
		MatrixTool.showTwoDimensionArray(matrix_to_test.getArray());
	}
	/*
	 * description:����Э�������Ļ����ϲ��Ծ��������ֵ�ֽ����ʾ
	 */
	public void getEigTest(){

		//��http://blog.csdn.net/ybdesire/article/details/6270328�õ�������
		//double[][] array_before = { { 1,2 }, { 3,6}, {4,2 },{5,2} };

		double[][] array_before = { { 1,2,100,400 }, { 3,6,200,500}, {4,2,300,600},{5,2,400,700} };
		
		System.out
				.printf("################    orginal_matrix_before    #####################\n");

		Matrix matrix_to_test = new Matrix(array_before);
		MatrixTool.showTwoDimensionArray(matrix_to_test.getArray());
		
		Matrix cov_matrix  = MatrixTool.getCovMatrix(matrix_to_test);
		
		System.out
		.printf("###############  cov_matrix  ######################\n");
		
		MatrixTool.showTwoDimensionArray(cov_matrix.getArray());
		
		System.out
		.printf("################    orginal_matrix_after  #####################\n");
		MatrixTool.showTwoDimensionArray(matrix_to_test.getArray());
		
		
		EigenvalueDecomposition matrix_res = cov_matrix.eig();
		System.out
		.printf("################    ������ֵ��ɵĶԽǾ���  #####################\n");
		
		MatrixTool.showTwoDimensionArray(matrix_res.getD().getArray());
		
		System.out
		.printf("################    ÿһ�ж�Ӧ����һ����������  #####################\n");
		MatrixTool.showTwoDimensionArray(matrix_res.getV().getArray());
		
	}
	
	
	
	public void getMatrixInverseTest(){
		double[][] array_before = { { 10, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out
				.printf("################    orginal_matrix_before    #####################\n");

		Matrix matrix_to_test = new Matrix(array_before);
		MatrixTool.showTwoDimensionArray(matrix_to_test.getArray());
		
		
		
		Matrix matrix_inversed = matrix_to_test.inverse();//�õ����������
		
		System.out
		.printf("###############  inversed_matrix  ######################\n");
		
		MatrixTool.showTwoDimensionArray(matrix_inversed.getArray());
		
		System.out
		.printf("################    orginal_matrix_after  #####################\n");
		
		MatrixTool.showTwoDimensionArray(matrix_to_test.getArray());
		}
	
	public void getTransposeMatrixTest(){
		
		double[][] array_before = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },{10,11,12} };

		System.out
				.printf("################    orginal_matrix_before    #####################\n");

		Matrix matrix_to_test = new Matrix(array_before);
		MatrixTool.showTwoDimensionArray(matrix_to_test.getArray());
		
		Matrix transposed_matrix  = MatrixTool.getTransposeMatrix(matrix_to_test);
		
		System.out
		.printf("###############  transposed_matrix  ######################\n");
		
		MatrixTool.showTwoDimensionArray(transposed_matrix.getArray());
		
		System.out
		.printf("################    orginal_matrix_after  #####################\n");
		MatrixTool.showTwoDimensionArray(matrix_to_test.getArray());
		
	}
	
	public void getCovMatrixTest(){
		//��http://blog.csdn.net/ybdesire/article/details/6270328�õ�������
		double[][] array_before = { { 1,2 }, { 3,6}, {4,2 },{5,2} };

		System.out
				.printf("################    orginal_matrix_before    #####################\n");

		Matrix matrix_to_test = new Matrix(array_before);
		MatrixTool.showTwoDimensionArray(matrix_to_test.getArray());
		
		Matrix cov_matrix  = MatrixTool.getCovMatrix(matrix_to_test);
		
		System.out
		.printf("###############  cov_matrix  ######################\n");
		
		MatrixTool.showTwoDimensionArray(cov_matrix.getArray());
		
		System.out
		.printf("################    orginal_matrix_after  #####################\n");
		MatrixTool.showTwoDimensionArray(matrix_to_test.getArray());
		
	}


}

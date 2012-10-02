package pca;

import Jama.Matrix;

/*
 * Description:为弥补jama的Maxtrix类中缺少的函数，编写这个工具类，函数大多是静态的
 */
public class MatrixTool {
	
	/*
	 * @param matrix_input传的矩阵
	 * @return matrix_input对应的协方差矩阵
	 * @author wuwei
	 */
	public static Matrix getCovMatrix(Matrix matrix_input) {
		
		double row_cnt = matrix_input.getRowDimension();
		
		Matrix center_matrix = MatrixTool.getCenterMatrix(matrix_input);//得到中心矩阵
		Matrix transposed_matrix = MatrixTool.getTransposeMatrix(center_matrix);   //得到中心矩阵的转置矩阵
		Matrix matrix_tmp = transposed_matrix.times(center_matrix);
		
		double factor = 1 / (row_cnt - 1);
		System.out.printf("factor:%f\n",factor);
		
		return matrix_tmp.times( factor );
		
	}
	
	
	
	/*
	 * @param matrix_input传的矩阵
	 * @return matrix_input对应的转置后的矩阵
	 */
	public static Matrix getTransposeMatrix(Matrix matrix_input){
		
		int row_cnt = matrix_input.getRowDimension();// 行数
		int column_cnt = matrix_input.getColumnDimension();// 列数
		double[][] to_return_array = new double[column_cnt][row_cnt];
		for(int i = 0; i < row_cnt; i++){
			for(int j = 0;j < column_cnt; j++){
				to_return_array[j][i] = matrix_input.get(i, j);
			}
		}
		return new Matrix(to_return_array);		
	}
	
	
	
	/*
	 * @param column_offset要得到的是第column_offset列的数据,column_offset从零开始算
	 * @param matrix_input传的矩阵
	 * @return 一个1维数组，对应的是matrix_input的第column_offset列的内容
	 * 
	 */
	public static double[] getColumn(int column_offset, Matrix matrix_input) {

		int row_cnt = matrix_input.getRowDimension();// 行数
		double[] column_array = new double[row_cnt];// 申请出返回的数组的空间
		for (int i = 0; i < row_cnt; i++) {
			column_array[i] = matrix_input.get(i, column_offset);
		}
		return column_array;

	}
	
	
	/*
	 * Description:将数组matrix_input第column_offset列的内容减去minus_value,执行好之后，matrix_input的值发生了变化，这传的是应用
	 * @param column_offset 被减去的是matrix_input的第column_offset列
	 * @param matrix_input 输入的等待处理的Matrix
	 * @param minus_value 数组matrix_input第column_offset要减去minus_value
	 * @return 流水线模式，没有返回值
	 * 
	 */
	public static void minusColumn(int column_offset, Matrix matrix_input,double minus_value) {

		int row_cnt = matrix_input.getRowDimension();// 行数

		double[][] martix_array = matrix_input.getArray();// 得到内部array的引用

		for (int i = 0; i < row_cnt; i++) {
			martix_array[i][column_offset] = martix_array[i][column_offset]
					- minus_value;
		}

	}
	
	
	/*
	 * Description:将数组matrix_input第column_offset列的内容减去minus_value,执行好之后，matrix_input的值不发生变化
	 * @param column_offset 被减去的是matrix_input的第column_offset列
	 * @param matrix_input 输入的等待处理的Matrix
	 * @param minus_value 数组matrix_input第column_offset要减去minus_value
	 * @return 处理好之后新生成的Matrix
	 * 
	 */
	public static Matrix getminusedColumn(int column_offset, Matrix matrix_input,
			double minus_value) {

		int row_cnt = matrix_input.getRowDimension();// 行数

		double[][] martix_array = matrix_input.getArrayCopy();

		for (int i = 0; i < row_cnt; i++) {
			martix_array[i][column_offset] = martix_array[i][column_offset]
					- minus_value;
		}

		return new Matrix(martix_array);
	}
	
	
	
	/*
	 * Description:按行打出一个二维double数组的值
	 * @param v_array 要显示的二维数组
	 * @return 流水线模式，没有返回值
	 */
	public static void showTwoDimensionArray(double[][] v_array) {
		for (int i = 0; i < v_array.length; i++) {
			double[] v_array_line = v_array[i];
			for (int j = 0; j < v_array_line.length; j++) {
				double to_print = v_array[i][j];
				System.out.printf("%f\t", to_print);
			}
			System.out.printf("\n");
		}

	}
	
	
	/*
	 * Description:得到中心矩阵（即每个维度减去这个维度的均值）
	 * @param matrix_input 输入的等待处理的Matrix
	 * @return matrix_input对应的中心矩阵
	 * 
	 */
	
	public static Matrix getCenterMatrix(Matrix matrix_input){
		
		Matrix matrix_to_return = new Matrix(matrix_input.getArrayCopy());
		
		int colum_cnt = matrix_input.getColumnDimension();//列数
		
	    //按列遍历一个数组
		for(int column_offset = 0;column_offset < colum_cnt;column_offset++ ){
			double[] current_column_array = MatrixTool.getColumn(column_offset, matrix_input);
			double avg_value = MatrixTool.getArrayAvg(current_column_array);//这一列的平均值
			MatrixTool.minusColumn(column_offset, matrix_to_return, avg_value);
		}
		
		return matrix_to_return;
		}
	
	
	
	
	
	/*
	 * Description:得到一个double数组的均值
	 * @param array_input,传入的一维的double数组
	 * @return array_input中内容的平均值
	 * 
	 */
	public static double getArrayAvg(double[] array_input) {
		
		double sum = 0;
		for (int i = 0; i < array_input.length; i++) {
			sum = sum + array_input[i];
			}
		return sum / array_input.length;

	}
	
	

}

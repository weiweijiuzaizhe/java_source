package pca;

import Jama.Matrix;

/*
 * Description:Ϊ�ֲ�jama��Maxtrix����ȱ�ٵĺ�������д��������࣬��������Ǿ�̬��
 */
public class MatrixTool {
	
	/*
	 * @param matrix_input���ľ���
	 * @return matrix_input��Ӧ��Э�������
	 * @author wuwei
	 */
	public static Matrix getCovMatrix(Matrix matrix_input) {
		
		double row_cnt = matrix_input.getRowDimension();
		
		Matrix center_matrix = MatrixTool.getCenterMatrix(matrix_input);//�õ����ľ���
		Matrix transposed_matrix = MatrixTool.getTransposeMatrix(center_matrix);   //�õ����ľ����ת�þ���
		Matrix matrix_tmp = transposed_matrix.times(center_matrix);
		
		double factor = 1 / (row_cnt - 1);
		System.out.printf("factor:%f\n",factor);
		
		return matrix_tmp.times( factor );
		
	}
	
	
	
	/*
	 * @param matrix_input���ľ���
	 * @return matrix_input��Ӧ��ת�ú�ľ���
	 */
	public static Matrix getTransposeMatrix(Matrix matrix_input){
		
		int row_cnt = matrix_input.getRowDimension();// ����
		int column_cnt = matrix_input.getColumnDimension();// ����
		double[][] to_return_array = new double[column_cnt][row_cnt];
		for(int i = 0; i < row_cnt; i++){
			for(int j = 0;j < column_cnt; j++){
				to_return_array[j][i] = matrix_input.get(i, j);
			}
		}
		return new Matrix(to_return_array);		
	}
	
	
	
	/*
	 * @param column_offsetҪ�õ����ǵ�column_offset�е�����,column_offset���㿪ʼ��
	 * @param matrix_input���ľ���
	 * @return һ��1ά���飬��Ӧ����matrix_input�ĵ�column_offset�е�����
	 * 
	 */
	public static double[] getColumn(int column_offset, Matrix matrix_input) {

		int row_cnt = matrix_input.getRowDimension();// ����
		double[] column_array = new double[row_cnt];// ��������ص�����Ŀռ�
		for (int i = 0; i < row_cnt; i++) {
			column_array[i] = matrix_input.get(i, column_offset);
		}
		return column_array;

	}
	
	
	/*
	 * Description:������matrix_input��column_offset�е����ݼ�ȥminus_value,ִ�к�֮��matrix_input��ֵ�����˱仯���⴫����Ӧ��
	 * @param column_offset ����ȥ����matrix_input�ĵ�column_offset��
	 * @param matrix_input ����ĵȴ������Matrix
	 * @param minus_value ����matrix_input��column_offsetҪ��ȥminus_value
	 * @return ��ˮ��ģʽ��û�з���ֵ
	 * 
	 */
	public static void minusColumn(int column_offset, Matrix matrix_input,double minus_value) {

		int row_cnt = matrix_input.getRowDimension();// ����

		double[][] martix_array = matrix_input.getArray();// �õ��ڲ�array������

		for (int i = 0; i < row_cnt; i++) {
			martix_array[i][column_offset] = martix_array[i][column_offset]
					- minus_value;
		}

	}
	
	
	/*
	 * Description:������matrix_input��column_offset�е����ݼ�ȥminus_value,ִ�к�֮��matrix_input��ֵ�������仯
	 * @param column_offset ����ȥ����matrix_input�ĵ�column_offset��
	 * @param matrix_input ����ĵȴ������Matrix
	 * @param minus_value ����matrix_input��column_offsetҪ��ȥminus_value
	 * @return �����֮�������ɵ�Matrix
	 * 
	 */
	public static Matrix getminusedColumn(int column_offset, Matrix matrix_input,
			double minus_value) {

		int row_cnt = matrix_input.getRowDimension();// ����

		double[][] martix_array = matrix_input.getArrayCopy();

		for (int i = 0; i < row_cnt; i++) {
			martix_array[i][column_offset] = martix_array[i][column_offset]
					- minus_value;
		}

		return new Matrix(martix_array);
	}
	
	
	
	/*
	 * Description:���д��һ����άdouble�����ֵ
	 * @param v_array Ҫ��ʾ�Ķ�ά����
	 * @return ��ˮ��ģʽ��û�з���ֵ
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
	 * Description:�õ����ľ��󣨼�ÿ��ά�ȼ�ȥ���ά�ȵľ�ֵ��
	 * @param matrix_input ����ĵȴ������Matrix
	 * @return matrix_input��Ӧ�����ľ���
	 * 
	 */
	
	public static Matrix getCenterMatrix(Matrix matrix_input){
		
		Matrix matrix_to_return = new Matrix(matrix_input.getArrayCopy());
		
		int colum_cnt = matrix_input.getColumnDimension();//����
		
	    //���б���һ������
		for(int column_offset = 0;column_offset < colum_cnt;column_offset++ ){
			double[] current_column_array = MatrixTool.getColumn(column_offset, matrix_input);
			double avg_value = MatrixTool.getArrayAvg(current_column_array);//��һ�е�ƽ��ֵ
			MatrixTool.minusColumn(column_offset, matrix_to_return, avg_value);
		}
		
		return matrix_to_return;
		}
	
	
	
	
	
	/*
	 * Description:�õ�һ��double����ľ�ֵ
	 * @param array_input,�����һά��double����
	 * @return array_input�����ݵ�ƽ��ֵ
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

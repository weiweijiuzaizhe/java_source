package pca;

import Jama.Matrix;

public class PcaTest {
	public static void main(String[] args) {
		double[][] array = { { -1, 1, 0 }, { -4, 3, 0 }, { 1, 0, 2 } };
		Matrix matrix = new Matrix(array);
		double[] columnPackedArray = matrix.getColumnPackedCopy();//һ��һ�е�����һ��
		PcaTest.showArray(columnPackedArray);
	}
	
	public static void showArray(double[] array_input){
		for(int i=0;i< array_input.length;i++){
			System.out.printf("%f\t",array_input[i]);
		}
		
	}

}

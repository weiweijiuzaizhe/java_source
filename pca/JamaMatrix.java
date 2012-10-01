package pca;

import Jama.Matrix;
//来自于http://zhidao.baidu.com/question/324732745.html
public class JamaMatrix {
	public static void main(String[] args) {
		double[][] array = { { -1, 1, 0 }, { -4, 3, 0 }, { 1, 0, 2 } };
		// 定义一个矩阵
		Matrix A = new Matrix(array);

		// 由特征值组成的对角矩阵
		/*
		 * 对角线特征值矩阵
		 */
		A.eig().getD().print(4, 2);//4列，精确到小数点后2位
		// 每一列对应的是一个特征向量
		
		/*
		 * 得到特征向量矩阵
		 */
		A.eig().getV().print(4, 2);

		double[][] arrayb = { { 1, -2, 2 }, { -2, -2, 4 }, { 2, 4, -2 } };
		Matrix B = new Matrix(arrayb);//根据数组生成矩阵
		B.eig().getD().print(4, 2);//输出特征值（放在对角阵中，对角线上）
		B.eig().getV().print(4, 2);//输出特征向量
	}
}
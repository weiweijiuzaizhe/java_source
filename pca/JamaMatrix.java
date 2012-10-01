package pca;

import Jama.Matrix;
//������http://zhidao.baidu.com/question/324732745.html
public class JamaMatrix {
	public static void main(String[] args) {
		double[][] array = { { -1, 1, 0 }, { -4, 3, 0 }, { 1, 0, 2 } };
		// ����һ������
		Matrix A = new Matrix(array);

		// ������ֵ��ɵĶԽǾ���
		/*
		 * �Խ�������ֵ����
		 */
		A.eig().getD().print(4, 2);//4�У���ȷ��С�����2λ
		// ÿһ�ж�Ӧ����һ����������
		
		/*
		 * �õ�������������
		 */
		A.eig().getV().print(4, 2);

		double[][] arrayb = { { 1, -2, 2 }, { -2, -2, 4 }, { 2, 4, -2 } };
		Matrix B = new Matrix(arrayb);//�����������ɾ���
		B.eig().getD().print(4, 2);//�������ֵ�����ڶԽ����У��Խ����ϣ�
		B.eig().getV().print(4, 2);//�����������
	}
}
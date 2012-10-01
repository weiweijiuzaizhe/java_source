package collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Test {
	private static int m_iNum = 0;
	private int mCount;
	
	public Test() {
		mCount = 0;
		m_iNum = 0;
	}
	
	public Test(int num) {
		mCount = 1;
		m_iNum = num;
	}
	
	public static void main(String argv[])
	{
	    
	    int arr1[] = {4, 5, 2, 1, 3, 9, 0, 7, 6, 8};
	    
	    System.out.println("/nmax number in arrray arr1 is:" + maxInt(arr1, arr1.length));
	    
	    Test sd = new Test();
	    
	    float f21 = 3; // ok
//	    float f1 = 3.4; // ERROR! Type mismatch: cannot convert from double to float
	    float f1 = 3.4f;
	    float f3 = 3.4f;
	    f3 = f3 + 1;
	    
	    int i = 0;
	    ArrayList list = new ArrayList();
	    Vector v = new Vector();
	    while(i < 10) {
	    	list.add(i);
	    	list.add(i);
	    	v.add(i);
	    	i++;
	    }
	    
	    System.out.println("ArrayList:");
	    for(i = 0; i < list.size(); i++) {
	    	System.out.print(list.get(i) + ", ");
	    }
	    
	    System.out.println("/nVector:");
	    for(i = 0; i < v.size(); i++) {
	    	System.out.print(v.get(i) + ", ");
	    }
	    
	    // 一个类集不能直接存储基本数据类型int，char，double等的值
//	    ArrayList <int> mylist1 = new ArrayList <int>(); 
	    ArrayList <int[]> mylist2 = new ArrayList <int[]>();
	    ArrayList <String> mylist3 = new ArrayList <String>(); 
	    ArrayList <Integer> mylist4 = new ArrayList <Integer>();
	    
	    Map<String, String> map1 = new HashMap<String, String>();
	    Map<Integer, String> map2 = new HashMap<Integer, String>();
	    for (int j = 0; j < 10; j++) {
	    	map2.put(j, "Hello " + j);
	    }
	    
	    System.out.println();
	    for(int j = 0; j < map2.size(); j++) {
	    	System.out.println(map2.get(j));
	    }
	}
	
	public String toString()
	{
		System.out.println("BBB" + this.m_iNum);
		
		return "Z";
	}
	
	static void setInt(int i){
		i++;
		System.out.println("setInt(): i = " + i);
	}
	
	//234
	public int[] fun(int[] arr) {
		int n = arr.length;
		int i = 0; 
		int j = n - 1;
		
		while (i < j) {
			if (arr[i] % 2 != 0) { // odd number
				i++;
			} else { // even
				if (arr[j] % 2 != 0) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j--;
			}
		}
		
		return arr;
	}
	
	public static int maxInt(int[] arr, int n)	{
		
		for(int i = 1; i < n; i++)
		{
			arr[0] = arr[i] > arr[0] ? arr[i]:arr[0];
		}
		
		return arr[0]; 
	}
	
	protected class Test1 extends Test{
		public Test1(int count) {
			setInt(0); // 非静态内部类可以访问外部类的静态和非静态成员函数
			toString();
			System.out.println("mCount = " + mCount); // 非静态内部类只能访问外部类的非静态成员变量
		}
	}
	
	static class Test2 extends Test{
		public Test2(int count) {
			setInt(0); // 静态内部类可以访问外部类的静态和非静态成员函数
			toString();
			System.out.println("m_iNum = " + m_iNum); // 静态内部类只能访问外部类的静态成员变量
		}
	}
	
}

package collection;

//������http://blogold.chinaunix.net/u1/52135/showart_409444.html

 import java.util.HashMap;
 import java.util.Iterator;
 import java.util.Map;
 import java.util.TreeMap;
 
 public class TestHashMap {
	 public static void main(String[] args) {
		 //�����ݷ���HashMap��
		 Map<String, String> map=new HashMap<String,String>();
		 map.put("a", "aaa");
		 map.put("b", "bbb");
		 map.put("c", "ccc");
		 map.put("d", "ddd");
		 //�õ�һ��������,��������Ϊ��
		 Iterator<String> iter=map.keySet().iterator();
		 while(iter.hasNext()){
			 String key=iter.next();
			 System.out.println("map key "+key.toString()+" value=---"+map.get(key));
			 }
		 TreeMap<String, String> tab=new TreeMap<String, String>();
		 tab.put("a", "aaa");
		 tab.put("b", "bbb");
		 tab.put("c", "ccc");
		 tab.put("d", "ddd");
		 Iterator<String> iter2=tab.keySet().iterator();
		 
		 while(iter2.hasNext()){
			 String key=iter2.next();
			 System.out.println("tab key "+key.toString()+" value=---"+tab.get(key));
			 }
		 }
	 }
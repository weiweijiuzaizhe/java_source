package collection;

//来自于http://blogold.chinaunix.net/u1/52135/showart_409444.html

 import java.util.HashMap;
 import java.util.Iterator;
 import java.util.Map;
 import java.util.TreeMap;
 
 public class TestHashMap {
	 public static void main(String[] args) {
		 //将数据放入HashMap中
		 Map<String, String> map=new HashMap<String,String>();
		 map.put("a", "aaa");
		 map.put("b", "bbb");
		 map.put("c", "ccc");
		 map.put("d", "ddd");
		 //得到一个迭代器,救命啊，为何
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
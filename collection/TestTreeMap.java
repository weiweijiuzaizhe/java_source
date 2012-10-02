package collection;

//来自于http://blogold.chinaunix.net/u1/52135/showart_409444.html

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
 
 public class TestTreeMap {
	 public static void main(String[] args){
		 //将数据放入HashMap中
		 Map<String, String> tree_map=new TreeMap<String,String>();
		 tree_map.put("a", "aaa");
		 tree_map.put("b", "bbb");
		 tree_map.put("c", "ccc");
		 tree_map.put("d", "ddd");
		 //得到一个迭代器
		 Iterator<String> iter=tree_map.keySet().iterator();
		 while(iter.hasNext()){
			 String key=iter.next();
			 System.out.println("map key "+key.toString()+" value=---"+tree_map.get(key));
		 }
	 }
 }
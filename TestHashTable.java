package collection;

import java.util.Hashtable;
//À´×Ôhttp://topic.csdn.net/t/20011217/18/426674.html
//Hashtable
public   class     TestHashTable{
		 public   static   void   main(String[]   args){
			 Hashtable<String,Integer>   numbers=   new   Hashtable<String,Integer>();
			// numbers.put( "one ",   new     String( "ppp ")); 
	                       numbers.put( "two ",   new   Integer(2)); 
	                       numbers.put( "three ",   new   Integer(3));
	                       Integer   n   =   (Integer)   numbers.get( "two "); 
	                      // String   temp=(String)   numbers.get( "one ");
	                       if(n!=null)
	                    	   System.out.println( "two= "+n);
	                 //      System.out.println( "one= "+temp); 
	           }
	 }

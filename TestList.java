package collection;

import java.util.LinkedList;
//À´×Ôhttp://topic.csdn.net/t/20011217/18/426674.html
public   class   TestList{ 
    public   static   void   main(String[]   args){ 
              int   i=2; 
              LinkedList<Object>     linklist   =   new   LinkedList<Object>(); 
              linklist.add(new   String( "first ")); 
              linklist.add(new   Integer(1)); 
              linklist.add(new     String( "third ")); 
              linklist.add(i,new   String( "second "));
              String   firstr=(String)linklist.getFirst(); 
              String   secstr=(String)linklist.get(i); 
            
              linklist.remove(2); 
  
              String   rsec=(String)linklist.get(i);
              System.out.println( "first= "+firstr); 
              System.out.println( "before   remove   seconc= "+secstr); 
              System.out.println( "after   remove     second= "+rsec); 
    } 
}    

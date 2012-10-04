package multi_thread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class synDemo { 
    private List<String> nameList = Collections.synchronizedList(new LinkedList<String>()); 

    public synchronized void add(String name) { 
        nameList.add(name); 
    } 

    /*
     * 使用synchronized对synchronized实现外部同步
     */
    public synchronized String removeFirst() { 
        if (nameList.size() > 0) { 
            return (String) nameList.remove(0); 
        } else { 
            return null; 
        } 
    } 
}
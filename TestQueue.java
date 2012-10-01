package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//来自http://www.blogjava.net/dreamstone/archive/2007/07/28/133003.html

public class TestQueue {
    public static void main(String[] args) {
        //队列是先进先出
        Queue<String> q = new LinkedList<String>();
        //这里offer和add类似
        q.offer("a");
        q.offer("b");
        q.offer("c");
        System.out.println(q);
        //队列头部弹出
        q.poll();
        System.out.println(q);
        //栈你是后进先出
        Stack<String> s = new Stack<String>();
        s.add("a");
        s.add("b");
        //这里push等同add
        s.push("c");
        System.out.println(s);
        //栈顶弹出
        s.pop();
        System.out.println(s);
        //只是看一下栈顶的值，并不移除
        s.peek();
        System.out.println(s);
    }
}

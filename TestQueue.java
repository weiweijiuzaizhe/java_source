package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//����http://www.blogjava.net/dreamstone/archive/2007/07/28/133003.html

public class TestQueue {
    public static void main(String[] args) {
        //�������Ƚ��ȳ�
        Queue<String> q = new LinkedList<String>();
        //����offer��add����
        q.offer("a");
        q.offer("b");
        q.offer("c");
        System.out.println(q);
        //����ͷ������
        q.poll();
        System.out.println(q);
        //ջ���Ǻ���ȳ�
        Stack<String> s = new Stack<String>();
        s.add("a");
        s.add("b");
        //����push��ͬadd
        s.push("c");
        System.out.println(s);
        //ջ������
        s.pop();
        System.out.println(s);
        //ֻ�ǿ�һ��ջ����ֵ�������Ƴ�
        s.peek();
        System.out.println(s);
    }
}

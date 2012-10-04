package multi_thread;

/** 
* Java线程：线程的同步-同步代码块 
* 
* @author leizhimin 2009-11-4 11:23:32 
*/ 
public class SynDemo_3 { 
        public static void main(String[] args) { 
                SynDemo3User u = new SynDemo3User("张三", 100); 
                SynDemo3Mythread t1 = new SynDemo3Mythread("线程A", u, 20); 
                SynDemo3Mythread t2 = new SynDemo3Mythread("线程B", u, -60); 
                SynDemo3Mythread t3 = new SynDemo3Mythread("线程C", u, -80); 
                SynDemo3Mythread t4 = new SynDemo3Mythread("线程D", u, -30); 
                SynDemo3Mythread t5 = new SynDemo3Mythread("线程E", u, 32); 
                SynDemo3Mythread t6 = new SynDemo3Mythread("线程F", u, 21); 

                t1.start(); 
                t2.start(); 
                t3.start(); 
                t4.start(); 
                t5.start(); 
                t6.start(); 
        } 
} 

class SynDemo3Mythread extends Thread { 
        private SynDemo3User u; 
        private int y = 0; 

        SynDemo3Mythread(String name, SynDemo3User u, int y) { 
                super(name); 
                this.u = u; 
                this.y = y; 
        } 

        public void run() { 
                u.oper(y); 
        } 
} 

class SynDemo3User { 
        private String code; 
        private int cash; 

        SynDemo3User(String code, int cash) { 
                this.code = code; 
                this.cash = cash; 
        } 

        public String getCode() { 
                return code; 
        } 

        public void setCode(String code) { 
                this.code = code; 
        } 

        /** 
         * 业务方法 
         * 
         * @param x 添加x万元 
         */ 
        public void oper(int x) { 
                try { 
                        Thread.sleep(10L); 
                        synchronized (this) { 
                                this.cash += x; 
                                System.out.println(Thread.currentThread().getName() + "运行结束，增加“" + x + "”，当前用户账户余额为：" + cash); 
                        } 
                        Thread.sleep(10L); 
                } catch (InterruptedException e) { 
                        e.printStackTrace(); 
                } 
        } 

        @Override 
        public String toString() { 
                return "User{" + 
                                "code='" + code + '\'' + 
                                ", cash=" + cash + 
                                '}'; 
        } 
}
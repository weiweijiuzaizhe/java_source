package multi_thread;

/** 
* Java线程：线程的同步 
* 
* @author leizhimin 2009-11-4 11:23:32 
*/ 
public class SynDemo_2 { 
        public static void main(String[] args) { 
                User u = new User("张三", 100); 
                innerThread t1 = new innerThread("线程A", u, 20); 
                innerThread t2 = new innerThread("线程B", u, -60); 
                innerThread t3 = new innerThread("线程C", u, -80); 
                innerThread t4 = new innerThread("线程D", u, -30); 
                innerThread t5 = new innerThread("线程E", u, 32); 
                innerThread t6 = new innerThread("线程F", u, 21); 

                t1.start(); 
                t2.start(); 
                t3.start(); 
                t4.start(); 
                t5.start(); 
                t6.start(); 
        } 
} 

class innerThread extends Thread { 
        private User u; 
        private int y = 0; 

        innerThread(String name, User u, int y) { 
                super(name); 
                this.u = u; 
                this.y = y; 
        } 

        public void run() { 
                u.oper(y); 
        } 
} 

class User { 
        private String code; 
        private int cash; 

        User(String code, int cash) { 
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
         * @param x 添加x万元 
         */ 
        public synchronized void oper(int x) { 
                try { 
                        Thread.sleep(10L); 
                        this.cash += x; 
                        System.out.println(Thread.currentThread().getName() + "运行结束，增加“" + x + "”，当前用户账户余额为：" + cash); 
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
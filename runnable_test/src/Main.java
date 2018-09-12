public class Main {
    public static void main(String args[]){
        task t1=new task();     //一个对象

        /********两个线程共享一个对象资源******/
        Thread thread1=new Thread(t1,"task1");
        thread1.start();
        Thread thread2=new Thread(t1,"task2");
        thread2.start();

    }
}
class task implements Runnable {
    private int size=10;
    @Override
    public void run(){
        while (size>0) {
            System.out.println(Thread.currentThread().getName() + ":" + size--);
        }

    }
}








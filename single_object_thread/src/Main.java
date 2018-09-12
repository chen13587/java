public class Main {
    public static void main(String args[]){

        task t1=new task();
        Thread task1=new Thread(t1);
        task1.start();
        Thread task2=new Thread(t1);
        task2.start();      //输出只执行了一次构造方法
//        Thread task3=new Thread(t1);
//        task3.start();
//        Thread task4=new Thread(t1);
//        task4.start();

    }

}
class task implements Runnable{
    @Override
    public void run(){
        single_object s1=single_object.new_obj("chen");
    }
}

class single_object{
    private static single_object obj=null;
    private String name;
    private static Object o=new Object();
    private single_object(String name){
        System.out.println("执行私有构造方法");
        this.name=name;
    }
    public static single_object new_obj(String name){      //静态方法，实现不生成对象也能调用
        if(obj==null){      //第一层模拟锁
            synchronized (o){       //同步块
                if(obj==null) {     //第二层模拟锁
                    obj = new single_object(name);
                }
            }
        }
        return obj;
    }

    public String getName() {
        return name;
    }
}






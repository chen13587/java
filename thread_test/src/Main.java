public class Main {
    public static void main(String args[]){
        task t1=new task("A");
        t1.start();
        task t2=new task("B");
        t2.start();
        task t3=new task("C");
        t3.start();
    }
}
class task extends Thread{
    public task(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(this.getName()+":"+i);
        }
    }
}


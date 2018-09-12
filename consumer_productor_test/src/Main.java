import java.util.LinkedList;
public class Main {
    public static void main(String args[]){
        basket bk=new basket();
        consumer con=new consumer(bk);
        productor pro=new productor(bk);

        pro.start();
        con.start();
    }
}
class consumer extends Thread{
    private basket bk=null;
    public consumer(basket bk){
        this.bk=bk;
    }
    @Override
    public void run(){
        try {
            bk.pull_melon();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class productor extends Thread{
    private basket bk=null;
    public productor(basket bk){
        this.bk=bk;
    }
    @Override
    public void run(){
        try {
            bk.push_melon();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class basket{
    private LinkedList<melon> bk=new LinkedList<melon>();

    public synchronized void push_melon() throws InterruptedException {      //同步方法
        for(int i=0;i<20;i++){      //添加20个melon
            melon m=new melon(i);
            push(m);
        }
    }
    public synchronized void pull_melon() throws InterruptedException {
        for(int i=0;i<20;i++){      //消费20个melon
            pull();
        }
    }
    private void push(melon app) throws InterruptedException {        //productor调用
        if(bk.size()<5){
            Thread.sleep(500);
            bk.addFirst(app);
            System.out.println("添加成功，当前存在："+bk.size()+"个："+app.getId());
            notify();
        }
        if(bk.size()>=5){
            System.out.println("满了，通知消费----");
            wait();     //等待notify()来唤醒
        }
    }
    private void pull() throws InterruptedException {        //consumer调用
        if(bk.size()>0){
            Thread.sleep(500);
            bk.removeFirst();
            System.out.println("成功消费，当前剩余："+bk.size()+"个");
            notify();
        }
        if(bk.size()<=0){
            System.out.println("空了，通知生产----");
            wait();
        }
    }
}

class melon{
    private int id;
    public melon(int id){
        this.id=id;
    }
    public int getId() {
        return id;
    }
}
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]){
        girl lisa=new girl();
        lisa.add(new boy_1());      //添加观察者
        lisa.add(new boy_2());
        lisa.add(new boy_3());
//        lisa.remove(boy1);
        lisa.send("我生病了");      //遍历调用观察者方法
    }


}
class girl implements Igirl{
    private List<Iobserver> list=new ArrayList<>();

    @Override
    public void add(Iobserver s) {
        list.add(s);
    }
    @Override
    public void remove(Iobserver s) {
        list.remove(s);
    }
    @Override
    public void send(String s) {
        for(Iobserver l:list){      //增强for循环
            l.update(s);
        }
    }

}

class boy_1 implements Iobserver{
    @Override
    public void update(String str) {
        System.out.println("收到："+str);
        if(str.equals("我生病了")){
            System.out.println("我来了");
        }
    }
}
class boy_2 implements Iobserver{
    @Override
    public void update(String str) {
        System.out.println("收到："+str);
        if(str.equals("我生病了")){
            System.out.println("我不在");
        }
    }
}
class boy_3 implements Iobserver{
    @Override
    public void update(String str) {
        System.out.println("收到："+str);
        if(str.equals("我生病了")){
            System.out.println("我不认识你");
        }
    }
}










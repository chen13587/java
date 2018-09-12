public class inner_class {
    public static void main(String args[]){
        person per=new person();
        per.func();

        person.inner_cla2 inner=per.new inner_cla2();       //外部类的外部实例化内部类：外部类名.内部类名 新对象=外部类对象.new 内部类名();
        inner.func();

        person.inner_cla1 inner2=new person().new inner_cla1();
        inner2.func();
    }
}
interface Iapi{
    public  abstract void  func();
}
abstract class Acla{
    public abstract void func();
}
class person{
    public String name;
    public void func(){
        inner_cla1 c1=new inner_cla1();
        inner_cla2 c2=new inner_cla2();
        c1.func();
        c2.func();
    }
    public void func2(){
        System.out.println("外部类方法");

    }
    public class inner_cla1 extends Acla{
        @Override
        public void func() {
            System.out.println("重写抽象方法");
            person.this.func2();        //内部类调用外部类的成员/方法（外部类名.this.成员/方法）
        }
    }
    public class inner_cla2 implements Iapi{
        @Override
        public void func() {
            System.out.println("重写接口内方法");
        }
    }
}
















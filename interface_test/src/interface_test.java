public class interface_test {
    public static void main(String args[]){
        Ieat a=new dog();       //关键：接口的变量引用实现类的对象（类似向上转型）
        a.eat();
        a=new cat();
        a.eat();
    }
}

interface Ieat{
    public abstract void eat();     //具有共性但逻辑不相关的事物的方法抽象（比如人和狗都能eat但不能继承同一个父类，因为逻辑不相关）


}

class dog implements Ieat{
    @Override
    public void eat() {
        System.out.println("啃骨头");
    }
}
class cat implements Ieat{
    @Override
    public void eat() {
        System.out.println("吃鱼肉");
    }
}

















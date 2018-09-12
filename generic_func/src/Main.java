public class Main {
    public static void main(String args[]){
        animal dog=new dog();
        person s=new person();
        s.func(dog);
        s.func(new dog(){
            @Override
            public void eat(){
                System.out.println("匿名内部类实现：啃骨头");

            }

        });

    }
}

abstract class animal{      //父类
    abstract void eat();
}
class dog extends animal{    //继承animal抽象类（接口也可以）
    @Override
    public void eat() {
        System.out.println("啃骨头");
    }
}
class cat {             //没有继承animal抽象类
    public void eat() {
        System.out.println("吃鱼肉");
    }
}

class person{
    //方法重载
    public  <T> void func(T dat){       //接收任何实参
        System.out.println("方法1");
        System.out.println(dat);
    }
    public  <T extends animal> void func(T dat){       //接收animal类或animal的子类
        System.out.println("方法2");
        dat.eat();
    }
    public  <T1,T2> void func(T1 dat ,T2 dat2){       //多个泛型变量
        System.out.println("方法3");
        System.out.println(dat);
        System.out.println(dat2);
    }



}













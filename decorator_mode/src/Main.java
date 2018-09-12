public class Main {
    public static void main(String args[]){
        System.out.println("\n******  不装饰  *****");
        component c=new component();
        c.doing();
        System.out.println("\n******  装饰1层  *****");
        decorator_1 d1=new decorator_1(c);
        d1.doing();
        System.out.println("\n******  装饰2层  *****");
        decorator_2 d2=new decorator_2(d1);
        d2.doing();
    }
}
interface I_func{
    public abstract void doing();
}

class component implements I_func{      //成员
    @Override
    public void doing() {
        System.out.println("实现方法");
    }
}

class concrete implements I_func{       //具体
    private I_func o=null;
    public concrete(I_func o){
        this.o=o;
    }
    @Override
    public void doing() {
        o.doing();      //调用传入对象的doing方法
    }
}

class decorator_1 extends concrete{
    public decorator_1(I_func o){
        super(o);       //传对象到父类构造方法
    }
    @Override
    public void doing() {      //重写父类方法
        super.doing();      //重写前调用一次父类方法
        func();
    }
    private void func(){
        System.out.println("扩展方法_1");
    }
}

class decorator_2 extends concrete{
    public decorator_2(I_func o){
        super(o);
    }
    @Override
    public void doing(){
        super.doing();
        func();
    }
    private void func(){
        System.out.println("扩展方法_2");
    }
}



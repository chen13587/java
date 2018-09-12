public class strategy_mode {
    public static void main(String args[]){
        person p=new person();
        way obj_1=new method_1();
        way obj_2=new method_2();

        p.set_obj(obj_2);
        p.exc_method();
    }
}

//环境角色（持有具体策略对象的实行者）
class person{
    private way w=null;
    public void set_obj(way w){
        this.w=w;
    }
    public void exc_method(){
        w.typing("hello");

    }
}

//抽象角色（抽象类或接口）
interface way{
    public abstract void typing(String str);
}

//具体策略角色（具体执行方法，继承抽象角色）
class method_1 implements way{      //策略1
    @Override
    public void typing(String str){
        System.out.println("方法1: "+str);
    }
}
class method_2 implements way{      //策略2
    @Override
    public void typing(String str){
        System.out.println("方法2: "+str);
    }
}


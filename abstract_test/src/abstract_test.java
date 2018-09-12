public class abstract_test {
    public static void main(String args[]){
        person obj=new chen("cpl",18);
        obj.output();
        obj=new yang("yxy",18);
        obj.output();
    }
}

abstract class person{
    protected String name;
    protected int age;
    public person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public abstract void output();      //抽象方法，实现交由子类
}

class chen extends person{
    public chen(String name,int age){       //构造方法
        super( name, age);      //交给父类构造方法
    }
    public void output(){
        System.out.println("chen-> name: "+super.name+", age: "+super.age);
    }
}
class yang extends person{
    public yang(String name,int age){
        super( name, age);
    }
    public void output(){
        System.out.println("yang-> name: "+super.name+", age: "+super.age);
    }
}

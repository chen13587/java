public class class_extends {
    public static void main(String args[]){
        chi_cla a=new chi_cla(5);
        System.out.println(a.age);
        a.setAge(10);
        System.out.println(a.age);
    }
}

class fat_cla{
    public int age;

    public fat_cla(int a){
        System.out.println("调用父类构造方法");
        this.age=a;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
class chi_cla extends fat_cla{
    public chi_cla(int a) {     //子类构造方法
        super(a);   //调用父类构造方法      //必须为子类构造方法第一行
        System.out.println("调用子类构造方法");
    }
    @Override       //方法重写（重写父类方法）
    public void setAge(int age) {
        super.setAge(age);
    }
}










public class func_override {

    public static void main(String args[]){
        chi_cal c=new chi_cal();
        c.f1();

    }
}

class fat_cla{
    public void f1(){
        System.out.println("我是父类方法");
    }
}

class chi_cal extends fat_cla{
    @Override
    public void f1(){
        super.f1();       //用super可以调用父类未被重写的方法
        System.out.println("我是子类方法");

    }

}
















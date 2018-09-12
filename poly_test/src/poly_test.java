public class poly_test {
    public static void main(String args[]){
        shool_printer p=new shool_printer();

        color_printer cp=new color_printer();
        black_printer bp=new black_printer();

        p.setSp(cp);       //传入指定打印机对象
        p.output();        //输出不同对象的同一方法的不同实现
        p.setSp(bp);       //传入指定打印机对象
        p.output();        //输出不同对象的同一方法的不同实现
    }
}

class shool_printer{
    private shool_printer sp=null;
    public void setSp(shool_printer sp) {       //最关键一点：父类变量接收不同子类对象
        this.sp = sp;
    }
    public void print(){
        System.out.println("我没有被重写");
    }
    public void output(){
        this.sp.print();    //调用被不同子类重写的print方法
    }
}
class color_printer extends shool_printer{
    @Override
    public void print() {
        System.out.println("我是彩色打印机");
    }
}
class black_printer extends shool_printer{
    @Override
    public void print() {
        System.out.println("我是黑白打印机");
    }
}


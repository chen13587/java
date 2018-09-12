public class abstract_template {
    public static void main(String args[]){
        work obj=new math_teacher();
        obj.begin();
        obj=new english_teacher();
        obj.begin();
    }
}

abstract class work{
    private void start(){
        System.out.println("开始工作");
    }
    public abstract void working();     //抽象方法

    private void end() {
        System.out.println("工作结束\n");
    }

    public void begin(){
        start();
        working();
        end();
    }
}
class english_teacher extends work{
    @Override
    public void working(){
        System.out.println("打开英语书");
    }
}
class math_teacher extends work{
    @Override
    public void working() {
        System.out.println("打开数学书");
    }
}


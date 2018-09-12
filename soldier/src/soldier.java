public class soldier {
    public static void main(String args[]){
        officer chen=new officer("chen");
        chen.start_attack();
        chen.start_attack(chen.get_soldier()[0]);       //返回获取数组
    }
}

abstract class attack{
    private String name;
    public void begin(){
        System.out.println("准备进攻");
    }
    public abstract void attacking();       //交给子类完成
    public void end(){
        System.out.println("结束进攻\n");
    }
    public void action(){
        begin();
        attacking();
        end();
    }
    public attack(String name){
        this.name=name;

    }
    public String getname() {
        return name;
    }
}


class sea_soldier extends attack{       //海军
    public sea_soldier(String name){
        super(name);
    }
    @Override
    public void attacking(){
        System.out.println(super.getname()+"使用鱼雷攻击");
    }
}

class air_soldier extends attack{       //空军
    public air_soldier(String name){
        super(name);
    }
    @Override
    public void attacking(){
        System.out.println(super.getname()+"使用导弹攻击");
    }
}

class officer extends attack{
    private attack sold[]=new attack[2];
    public officer(String name){
        super(name);
        this.sold[0]=new sea_soldier("杨欣怡");
        this.sold[1]=new air_soldier("马咸蛋");
    }
    @Override
    public void attacking() {
        System.out.println(super.getname()+"使用手枪攻击");
    }

    /*************方法重载*************/
    public void start_attack(){
        for(int i=0;i<sold.length;i++){
            sold[i].action();
        }
        this.action();      //调用当前对象执行action()
        System.out.println("一轮攻击结束\n");
    }
    public void start_attack(attack soldier){
        soldier.action();
        System.out.println("一轮攻击结束\n");

    }
    /*************方法重载*************/

    public attack[] get_soldier(){      //获取士兵数组
        return sold;
    }


}

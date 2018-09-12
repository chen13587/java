public class polymorphic {
    public static void main(String args[]) {
        animal obj = new dog();       //向上转型，父类变量 引用子类对象，只有父类变量能引用多个不同子类对象
        obj.eat();
        //ani_1.run();      //不能执行run()，因为是父类变量引用子类对象，子类特有方法将丢失
        obj = new cat();
        obj.eat();

        if(obj instanceof cat) {
            cat new_obj = (cat) obj;        //向下转型
            new_obj.tree();             //向下转换后可以执行特有方法
        }else{
            System.out.println("对象和类不匹配，无法转型");
        }


    }
}
//多态
class animal{
    public void eat(){
        System.out.println("吃东西");
    }
}

class dog extends animal{
    @Override
    public void eat() {
        System.out.println("吃骨头");
    }
    public void run(){
        System.out.println("跑得快");
    }
}
class cat extends animal{
    @Override
    public void eat() {
        System.out.println("吃鱼肉");
    }
    public void tree(){
        System.out.println("我会爬树");
    }
}


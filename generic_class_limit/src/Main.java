public class Main {
    public static void main(String args[]){
        person<cat> an=new person<>();
        an.setAnimal(new cat());
        an.feed();


        //无限制通配符？
        person<?> f1;
        person<dog> f2=new person<>();
        f2.setAnimal(new dog());
        f1=f2;      //因为f1是泛型通配符对象，所以f1可以引用任何对象
        f1.feed();

        //上边界限制通配符 <? extends 类/普通类型>
        person <? extends Animal> f3;
        person<cat> f4=new person<>();
        f4.setAnimal(new cat());
        f3=f4;      //因为f3是上边界限制Animal类通配符，所有能引用Animal类或其子类
        f3.feed();

        //下边界限制通配符 <? super 类/普通类型>
        person <? super dog> f5;
        person <Animal> f6=new person<>();
        f6.setAnimal(new dog());
        f5=f6;
        f5.feed();

    }

}

class person <T extends Animal>{        //限制泛型只能接收Animal类或Animal的子类，不写默认extends Object，所以可以接收所有类
    private T animal;
    public void setAnimal(T animal){
        this.animal=animal;
    }
    public void feed(){
        animal.eat();
    }
}

interface  Animal{
     abstract void eat();
}

class dog implements Animal{

    @Override
    public void eat(){
        System.out.println("啃骨头");
    }
}
class cat implements Animal{
    @Override
    public void eat(){
        System.out.println("喂鱼肉");
    }
}
class duck {
    public void eat(){
        System.out.println("吃豆");
    }
}







public class Main {
    public static void main(String srgs[]){
        //泛型类(普通类型)
        generic1<String> gen=new generic1<>("hello");
        gen.setDat("hi");
        System.out.println(gen.getDat());
        generic1<Integer> gen2=new generic1<>(33);
        System.out.println(gen2.getDat());

        //泛型类(类)
        generic1<student> gen_stu = new generic1<>(new student("chen"));
        System.out.println(gen_stu.getDat().getName());     //getDat返回student对象，getName()返回student对象的名字

        //泛型类(泛型类(类))
        generic1<generic1<student>>gg_stu = new generic1<>(new generic1<>(new student("yxy")));
        System.out.println(gg_stu.getDat().getDat().getName());

        //泛型类(泛型类(普通类型))
        generic1<generic1<String>> gen3 =new generic1<>(new generic1<>("chen"));
        System.out.println(gen3.getDat().getDat());

        //多个泛型变量
        generic2<String,Integer> gen4=new generic2<>("szy",18);
        System.out.println(gen4.getDat1());
        System.out.println(gen4.getDat2());

        //泛型继承泛型
        son<String,Integer> gen5=new son<>("mxd",21);
        System.out.println(gen5.getDat());
        System.out.println(gen5.getDat2());

        //泛型接口
        person<String,Integer> gen6=new person(4);
        gen6.show("hello");

    }
}

class student{
    private String name;
    public student(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

class generic1 <T>{
    private T dat;
    public generic1(T dat){
        this.dat=dat;
    }

    public void setDat(T dat) {
        this.dat = dat;
    }

    public T getDat() {
        return this.dat;
    }
}



class generic2 <T1,T2>{
    private T1 dat1;
    private T2 dat2;
    public generic2(T1 dat1,T2 dat2){
        this.dat1=dat1;
        this.dat2=dat2;
    }
    public T1 getDat1() {
        return dat1;
    }

    public T2 getDat2() {
        return dat2;
    }
}

class parten <T>{
    private T dat;
    public parten(T dat){
        this.dat=dat;
    }
    public void setDat(T dat) {
        this.dat = dat;
    }
    public T getDat() {
        return this.dat;
    }
}

class son <T1,T2> extends parten<T1>{       //父类的泛型形参必须由子类代收，然后传递到父类
    private T2 dat2;
    public son(T1 dat1,T2 dat2){
        super(dat1);
        this.dat2=dat2;
    }

    public T2 getDat2() {
        return dat2;
    }

    @Override
    public T1 getDat(){     //获取父类变量值
       return super.getDat();
    }
}


interface generic3 <T>{
    public abstract void show(T dat);
}
class person<T1,T2> implements generic3 <T1>{
    private T2 dat2;
    public person(T2 dat2){
        this.dat2=dat2;
    }
    @Override
    public void show(T1 dat){
        System.out.println(dat);
        System.out.println(dat2);

    }
}



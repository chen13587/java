import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class Main {

    public static void main (String args[]) throws Exception {
        student std1 = null;
        student std=new student("chen",2);

        Class<?> tmp1=std.getClass();       //获取对象的Class
        System.out.println(tmp1);

        Class<?> tmp2=tmp1.getSuperclass();     //获取Class对象的父类Class对象
        System.out.println(tmp2);

        Class<?> tmp3=student.class;        //获取类的的Class对象
        System.out.println(tmp3);

        try{
            Class<?> tmp4= Class.forName("student");
            System.out.println(tmp4);
            try {
                System.out.println("*********获取Class对象的构造方法*********");
                Constructor<?> con=tmp4.getConstructor(new Class[]{String.class,int.class});       //获取无参构造方法
                System.out.println("*********用构造方法实例化对象*********");
                 std1=(student)con.newInstance(new Object[]{"chen",20});
                System.out.println(std1.getName());
            }catch (Exception e){
                System.out.println("错误");
                System.out.println(e);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("*********getDeclareMethod方法，获取Class对象中的方法。并调用对象的指定方法*********");
        Method mt=tmp1.getDeclaredMethod("output",new Class[]{});
        mt.setAccessible(true);
        System.out.println(mt.getName());
        System.out.println((String)mt.invoke(std1,new Object[]{}));     //调用std1对象的getName方法

        System.out.println("*********getDeclareMethods方法，获取Class对象中的方法，返回数组格式*********");
//        Method mt_arr[]=tmp1.getDeclaredMethods();
//
//        for (Method m:mt_arr){
//            System.out.println(m.getName()+"->"+m.getModifiers());
//            System.out.println(m.invoke(std1,new Object[]{}));
//        }
        System.out.println("*********getDeclareField方法，获取Class对象中的成员*********");
        Field fl=tmp1.getDeclaredField("age");
        fl.setAccessible(true);
        fl.set(std,23);
        System.out.println(std.getAge());
        System.out.println(fl);
//        System.out.println("*********getDeclareFields方法，获取Class对象中的成员，返回数组格式*********");
//        Field fl[]=tmp1.getDeclaredFields();

        System.out.println("*********getDeclareFields方法，获取Class对象中的成员，返回数组*********");
        Field f[]=tmp1.getDeclaredFields();
//        for(Field tmp:f){
//            tmp.setAccessible(true);
//            tmp.set(std,11);      //无法设置值，因为两个成员类型不同
//        }


    }
}
class student{
    private String name;
    private int age;
    public student(String name,int age){
        this.name=name;
        this.age=age;
    }
    public student(){
        System.out.println("hhh");
    }
    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;

    }
    private void output(){
        System.out.println("我是私有方法");

    }
}

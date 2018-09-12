import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String args[]) throws Exception{
        student std=new student("chen",34);
        try{
            student st=(student)copyObject.copy(std);

            System.out.println("**********************");
            System.out.println(st.getAge());
            System.out.println(st.getName());
        }catch (Exception e){
            System.out.println("错误");
            System.out.println(e);
        }
    }
}

class copyObject{
    public static Object copy(Object obj) throws Exception {
        Object st=null;
        try {
            Class<?> obj_class=obj.getClass();        //获取对象的类
            Constructor<?> constr=obj_class.getConstructor(new Class[]{String.class,int.class});
            st=constr.newInstance(new Object[]{null,0});

            Field field[]=obj_class.getDeclaredFields();
            for(Field f:field){
                /**************使用对象的get和set方法来复制****************/
                String getMethod="get"+f.getName().substring(0,1).toUpperCase()+f.getName().substring(1);
                String setMethod="set"+f.getName().substring(0,1).toUpperCase()+f.getName().substring(1);
                System.out.println("get名字："+getMethod+"，set名字："+setMethod);

                Method mt=obj_class.getDeclaredMethod(getMethod,new Class[]{});     //获取方法用Object类型接收，因为类型会变
                Object val=mt.invoke(obj,new Object[]{});    //返回值用

                Method mt2=obj_class.getDeclaredMethod(setMethod,new Class[]{f.getType()});     //传入一个参数类型
                mt2.invoke(st,new Object[]{val});

                /**************直接修改成员，简单*************/
//                f.setAccessible(true);      //强制访问private私有成员
//                System.out.println(f.getName());       //返回成员名
//                Object val=f.get(obj);
//                f.set(st,val);
            }
        }catch (Exception e){
            System.out.println("错误："+e);
        }
        return st;
    }
}


class student{
    private String name;
    private int age;
    public student(String name,int age){
        this.age=age;
        this.name=name;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
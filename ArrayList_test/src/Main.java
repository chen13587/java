import java.util.ArrayList;
import java.util.List;
public class Main{
    public static void main(String args[]){
        System.out.println("hello");
        List<student> obj=new ArrayList<student>();
        List<student> obj1=new ArrayList<student>();
        obj.add(new student("chen1",2));

        obj.add(new student("chen3",31));
        obj.add(new student("chen3",31));

        obj.add(new student("chen4",42));
        obj.add(new student("chen5",52));
        obj.add(new student("chen6",62));
        obj.add(new student("chen7",672));
        obj.add(new student("chen8",27));
        obj.add(new student("chen9",28));
        obj.add(new student("chen10",289));
        obj.add(new student("chen11",29));
        obj.add(new student("chen12",234));
        obj.add(new student("chen13",223));

        System.out.println("name="+obj.get(5).getName()+", age="+obj.get(5).getAge());
        System.out.println("name="+obj.get(1).getName()+", age="+obj.get(1).getAge());
        System.out.println("name="+obj.get(8).getName()+", age="+obj.get(8).getAge());
        System.out.println(obj.get(1).equals(obj.get(2)));

    }
}

class student{
    private String name;
    private int age;
    public student(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    @Override
    public boolean equals(Object o){        //重写比较方法
        student obj=(student)o;
        if(obj==this){      //如果传入对象和调用对象是同一个，直接返回true
            return true;
        }else if(!this.name.equals(obj.getName())){
            return false;
        }else if(this.age!=obj.getAge()){
            return false;
        }
        return true;


    }
}

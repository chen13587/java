
import java.util.LinkedList;

public class Main {
    public static void main(String args[]) {
        LinkedList<student> obj=new LinkedList<>();
        obj.add(new student("chen1",23));
        obj.add(new student("chen2",13));
        obj.add(1,new student("chen3",14));

//        System.out.println(obj.removeFirst());
//        obj.remove(2);      //删除指定位置的元素
        obj.addFirst(new student("First",1));
        obj.addLast(new student("Last",111));
        obj.pollLast();
        for (student tmp:obj){
            System.out.println(tmp.getName());
        }
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

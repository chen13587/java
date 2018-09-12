import java.util.HashSet;
import java.util.Iterator;
public class Main {
    public static void main(String args[]){
        HashSet<student> hs=new HashSet<>();
//        hs.add("chen1");
//        hs.add("chen4");
        hs.add(new student("chen",18));
        hs.add(new student("yxy",19));
        hs.add(new student("sdz",13));
        hs.add(new student("che1n",18));
        Iterator<student> s=hs.iterator();      //生成可迭代对象

        student obj=null;       //临时对象
        while(s.hasNext()){
            obj=s.next();       //赋值到临时对象，如果下一步直接操作2个next指针，next将会后移2位
            System.out.println(obj.getName()+"->"+obj.getAge());
        }
    }
}
class student{
    private int age;
    private String name;
    public student(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    /*******重写HashSet判断同键的方法，使其只要name和age相同，就认为是同键*******/
    @Override
    public boolean equals(Object o){
        student obj=(student) o;
        if(this.age==obj.age&&this.name.equals(obj.name))
            return true;
        return false;
    }
    @Override
    public int hashCode(){
        return this.age+this.name.hashCode();
    }
}

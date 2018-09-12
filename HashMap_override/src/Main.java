import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String args[]){
        Map<student,String> m =new HashMap<>();
        m.put(new student("花",12),"chen1");
        m.put(new student("鱼",14),"chen2");
        m.put(new student("花",12),"chen3");     //3会覆盖1，因为student类重写了判断是否同键的方法

        Set<Map.Entry<student,String>> o=m.entrySet();
        for(Map.Entry<student,String> tmp : o){
            System.out.println(tmp.getKey().getAge()+"-"+tmp.getValue());
        }
        System.out.println("元素个数"+m.size());

        /*****迭代对象 输出所有键******/
        Set<student> k=m.keySet();
        Iterator<student> key=k.iterator();
        while(key.hasNext()){
            System.out.println(key.next());
        }

    }
}
class student{
    private String like;
    private int age;
    public student(String like,int age){
        this.like=like;
        this.age=age;
    }
    public int getAge() {
        return age;
    }

    /******重写equals和hashCode方法，让put添加的like和age相同的对象，都认为是put同一个键******/
    @Override
    public boolean equals(Object o){       //重写equals方法
        if(o==this){
            return true;
        }
        student obj=(student)o;
        if((this.age==obj.age)&&(this.like==obj.like)){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){      //重写hashCode方法
        return this.age+this.like.hashCode();
    }
}
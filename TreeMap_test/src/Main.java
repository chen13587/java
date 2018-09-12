import java.util.*;
public class Main {
    public static void main(String args[]){
        Map<student,Integer> tree = new TreeMap<>(new Comparator <student>(){
            @Override
            public int compare(student s1,student s2){      //匿名内部类 重写Comparator接口的compare比较方法
                return s1.getName().compareTo(s2.getName());
            }
        });
//        tree.put(("chen1"),15);
//        tree.put(("chen2"),25);
        tree.put(new student("chen2",12),3);
        tree.put(new student("chen3",11),4);
        tree.put(new student("chen4",5),6);
        tree.put(new student("chen5",74),7);
        tree.put(new student("chen6",32),9);
        Set<Map.Entry<student,Integer>> kv=tree.entrySet();

        for(Map.Entry<student,Integer> tmp:kv){
            System.out.println(tmp.getKey().getAge()+"->"+tmp.getValue());
        }
        System.out.println("**********获取所有键*********");
        Set<student> s=tree.keySet();       //获取所有键
        for (student std:s){
            System.out.println(std.getName());
        }
        Collection<Integer> v=tree.values();        //获取所有值
        for (Integer val:v){
            System.out.println(val);
        }

        System.out.println("元素个数"+tree.size());
        System.out.println("是否为空"+tree.isEmpty());

    }
}

class student /*implements Comparable <student>*/ {
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
    /*
    @Override
    public int compareTo(student o){        //因为对象默认无法排序，重写Comparable接口的compareTo排序规则，使对象按指定规则排序
        if(this.age>o.age){     //如果put传入的键大一些，该键就放节点右边
            return 1;   //放右边
        }else if(this.age<o.age){   //如果put传入的键小一些，该键就放节点左边
            return -1;  //放左边
        }
        return 0;   //相等就覆盖节点
    }
    */
}

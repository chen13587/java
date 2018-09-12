import java.lang.reflect.Array;
import java.util.*;
public class Main {
    public static void main(String args[]){

      //Collections常用API方法

        List<String> mlist=new ArrayList<>();
        mlist.add("chen8");
        mlist.add("chen5");
        mlist.add("chen3");
        mlist.add("chen1");
        mlist.remove("chen1");
//        Collections.sort(mlist);    //自然排序
//        Collections.shuffle(mlist);       //打乱顺序
//        Collections.fill(mlist,"yxy");        //填充元素
        System.out.println("**********迭代对象********");
        Iterator<String> list=mlist.iterator();
        while(list.hasNext()){
            System.out.println(list.next());
        }

        System.out.println("**********增强for循环********");
        for(String m:mlist){
            System.out.println(m);
        }

        System.out.println(Collections.binarySearch(mlist,"chen5"));    //二分查找，注意：查找前必须排序

/*
        //重写sort排序规则，使其根据对象中的age成员排序
        List<student> mlist=new ArrayList<>();
        mlist.add(new student("chen0",1));
        mlist.add(new student("chen1",7));
        mlist.add(new student("chen2",4));
        mlist.add(new student("chen3",2));
        Collections.sort(mlist, new Comparator<student>(){
            @Override
            public int compare(student s1,student s2){      //匿名内部类写法 重写sort排序规则
                if(s1.getAge()>s2.getAge()){
                    return 1;
                }else if(s1.getAge()<s2.getAge()){
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        Iterator<student> tmp=mlist.iterator();
        while (tmp.hasNext()){

            System.out.println(tmp.next().getAge());
        }


*/
    }
}
class student{
    private String  name;
    private int age;
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
}




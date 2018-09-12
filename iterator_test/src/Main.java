import java.util.Iterator;
import java.util.LinkedList;
public class Main {
    public static void main(String args[]){
        LinkedList<Integer> obj=new LinkedList<>();
        obj.add(1);
        obj.add(2);
        obj.add(3);


        Iterator<Integer> it=obj.iterator();   //生成迭代器对象
        while (it.hasNext()){       //hasNext()方法判断序列中是否还有元素
            System.out.println(it.next());     //next()方法获取序列中下一个元素
        }
    }

}

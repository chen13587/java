import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String args[]){
        my_stack<String> stk=new my_stack<>();
        stk.push("chen1");
        stk.push("chen2");
        stk.push("chen3");

        System.out.println(stk.pull());
        System.out.println(stk.pull());
        System.out.println(stk.pull());
        System.out.println("***********************");

        my_queue<String> lst=new my_queue<>();
        lst.push("chen1");
        lst.push("chen2");
        lst.push("chen3");

        System.out.println(lst.pull());
        System.out.println(lst.pull());
        System.out.println(lst.pull());

//        stk.pull_all();
    }
}

class my_stack <T>{     //LIFO后进先出
    LinkedList<T> stack;
    public my_stack(){
        stack=new LinkedList<>();
    }
//    public T get(int index){
//        return stack.get(index);
//    }
    public void push(T dat){
        stack.addFirst(dat);
    }
    public T pull(){
        return stack.pollFirst();
    }
    public void pull_all(){     //迭代器遍历
        Iterator<T> it_obj=stack.iterator();
        while (it_obj.hasNext()){
            System.out.println(it_obj.next());
        }
    }
}
class my_queue <T>{     //FIFO先进先出
    LinkedList<T> queue;
    public my_queue(){
        queue=new LinkedList<>();
    }
//    public T get(int index){
//        return list.get(index);
//    }
    public void push(T dat){
        queue.addFirst(dat);
    }
    public T pull(){
        return queue.pollLast();
    }
    public void pull_all(){     //迭代器遍历
        Iterator<T> it_obj=queue.iterator();
        while (it_obj.hasNext()){
            System.out.println(it_obj.next());
        }
    }
}

import java.util.*;
public class Main {
    public static void main(String args[]){
        String arr[]={"chen","yxy","chen","szy","wpl"};
        count cnt=new count();

        System.out.println("******Entry对象 输出键->值*******");
        Map<String,Integer> c=cnt.func(arr);
        Set<Map.Entry<String,Integer>> tmp=c.entrySet();
        for(Map.Entry<String,Integer> k_v:tmp){
            System.out.println(k_v.getKey()+"->"+k_v.getValue());
        }
        System.out.println("******Set容器生成迭代对象 输出键*******");
        Set<String> t=c.keySet();
        Iterator t2=t.iterator();
        while (t2.hasNext()){
            System.out.println(t2.next());
        }
        System.out.println("******Collection容器生成迭代对象 输出值*******");
        Collection<Integer> c1=c.values();
        Iterator c2=c1.iterator();
        while (c2.hasNext()){
            System.out.println(c2.next());
        }
    }
}
class count{
    public <T> Map<T,Integer>func(Object arr[]){
        Map<T,Integer> obj=new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            if (obj.get(arr[i])==null) {
                obj.put((T)arr[i],1);
            }
            else{
                obj.put((T)arr[i],obj.get(arr[i])+1);
            }
        }
        return obj;
    }
}







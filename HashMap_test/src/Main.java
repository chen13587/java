import java.util.*;

public class Main {
    public static void main(String args[]){
        Map<String,String> t=new HashMap<>();
        t.put("1","chen1");
        t.put("2","chen2");
        t.put("3","chen3");
        t.put("4","chen4");

        Set<String> keys=t.keySet();        //获取所有键集合，由Set<T>接口对象引用

        System.out.println("***********Iterator**************");
        Iterator key=keys.iterator();
        while (key.hasNext()) {
            System.out.println(t.get(key.next()));
        }

        System.out.println("***********Collection**************");
        Collection<String> values=t.values();    //获取所有值集合，由Collection<T>接口对象引用
        Iterator val=values.iterator();
        while (val.hasNext()){
            System.out.println(val.next());
        }

        System.out.println("***********Entry**************");
        Set<Map.Entry<String,String>> e=t.entrySet();       //entrySet()返回Entry对象集合
        for(Map.Entry<String,String> key_val:e){
            System.out.println(key_val.getKey()+"->"+key_val.getValue());

        }
//        Iterator<Integer> k=key.iterator();       //迭代对象
//        while (k.hasNext()){
//            System.out.println(k.next());
//        }

    }
}


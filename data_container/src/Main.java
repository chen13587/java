import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        int num=0;
        Icontainer<String> obj=new data<>(10);
        for(int i=0;i<30;i++){
            obj.addVal("chen"+num++);
        }
        Object arr[]=obj.getArr();
        for(int i=0;i<obj.getNum();i++) {
            System.out.println(arr[i]);
        }
    }
}

interface Icontainer<T>{
    void addVal(T dat);
    Object[] getArr();
    T getVal(int index);
    int getNum();
}

class data<T> implements Icontainer<T>{
    private Object arr[];
    private int num=0;
    public data(int size){
        arr=new Object[size];
    }
    public data(){
        arr=new Object[10];
    }
    @Override
    public void addVal(T dat){
        if(num>=arr.length){
            arr=Arrays.copyOf(arr,arr.length*2);
        }
        arr[num++]=dat;
    }
    @Override
    public T getVal(int index){
        return (T)arr[index];
    }
    public int getNum() {
        return num;
    }
    @Override
    public Object[] getArr(){
        return arr;
    }
}


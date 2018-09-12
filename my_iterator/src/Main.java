import java.util.Arrays;

public class Main  {
    public static void main(String args[]){
        IList<String> a=new mArrayList<>();     //声明IList对象，可引用所有IList子类对象
        a.madd("chen1");
        a.madd("chen2");
        a.madd("chen3");
        a.madd("chen4");
        a.madd("chen5");
        a.madd("chen6");
        a.madd("chen7");
        a.madd("chen8");

        Iiterator<String> i=a.miterator();      //声明一个接口对象，可引用所有Iiterator子类对象
        while (i.mhasNext()){
            System.out.println(i.mnext());
        }
    }
}

interface Iiterator<T>{     //接口
    public abstract boolean mhasNext();     //判断序列中是否还有元素
    public abstract T mnext();          //返回下一个元素
}

class mIterator<T> implements Iiterator<T>{
    private IList<T> obj;       //声明一个接口对象，能引用所有IList的子类对象
    private int num;

    @Override
    public T mnext(){
        return obj.mget(num++);
    }
    @Override
    public boolean mhasNext(){
        if(num>=obj.msize()){
            return false;
        }
        return true;
    }

    public mIterator(IList<T> obj){     //构造方法，声明为IList接口对象，能引用所有IList的子类对象
        this.obj=obj;
    }

}

interface IList<T>{
    public void madd(T dat);
    public int msize();
    public T mget(int index);
    mIterator miterator();      //生成可迭代对象方法
}

class mArrayList<T> implements IList<T>{
    private Object arr[];       //声明Object数组，可存放任何数据
    private int num;
    public mArrayList(){
        arr=new Object[5];
    }
    public mArrayList(int size){
        arr=new Object[size];
    }
    @Override
    public void madd(T dat){
        if (num>=arr.length){
            arr=Arrays.copyOf(arr,arr.length*2);     //扩容2倍
        }
        arr[num++]=dat;
    }
    @Override
    public int msize(){
        return num;
    }
    @Override
    public T mget(int index){
        return (T)arr[index];
    }
    @Override
    public mIterator miterator(){
        return new mIterator<>(this);     //传入自身对象，实例化一个迭代对象
    }
}


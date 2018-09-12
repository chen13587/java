import java.lang.invoke.StringConcatFactory;
import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        my_stringbuilder str=new my_stringbuilder("12121212");
        str.append("hello");
        str.append("hello");
        str.append("hello");
        str.append("hello");
        str.append("hello");
        str.append("hello");
        str.append("hello");
        str.append("hello");
        str.append("hello");
        str.append("hello");
        str.append("hello");
        str.append("hello");

        System.out.println(str.toString());
        System.out.println(str.capacity());
    }

}

class my_stringbuilder{
    private char arr[];
    private int cnt;
    public my_stringbuilder(){
        arr=new char[16];
    }
    public my_stringbuilder(int size){
        arr=new char[size];
    }
    public my_stringbuilder(String str){
        this.cnt=str.length();
        arr=new char[cnt];
        str.getChars(0,cnt,arr,0);      //拷贝字串到字符数组
    }

    public my_stringbuilder append(String str){
        int size=str.length();
//        this.cnt+=size;
        if((this.cnt+size)>arr.length){
            arr=Arrays.copyOf(arr,(this.cnt+size)*2); //拷贝长度，扩容
            str.getChars(0,size,arr,this.cnt);
            this.cnt+=size;
            return this;
        }
        else{
            str.getChars(0,str.length(),arr,this.cnt);
            this.cnt+=size;
            return this;        //？？？？？？？？
        }
    }
    public int length(){
        return this.cnt;
    }
    public int capacity(){
        return arr.length;


    }
    public String toString(){
        String str;
        str=new String(arr,0,this.cnt);
        return str;
    }
}











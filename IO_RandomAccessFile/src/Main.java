import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String args[]) throws Exception {
        RandomAccessFile raf=new RandomAccessFile("/home/chen/桌面/tmp/tmp","rw"); //读写模式
        person per[]={new person("chen",18),new person("yang",16)};
        for(person p:per){
            raf.writeInt(p.getAge());
            raf.writeChars(p.getName());
        }
        for(int i=0;i<per.length;i++){
            raf.seek(i*person.size());      //设置指针位置，注意：读取一次位置会自动向后偏移
//            System.out.println("指针："+raf.getFilePointer());
            System.out.println(raf.readInt());     //注意：读取指针位置一定要和写入指针位置一致，否则读取乱码
            System.out.println(readName(raf));
        }
    }
    public  static String readName(RandomAccessFile raf) throws IOException {
        char by[]=new char[15];
        for(int i=0;i<by.length;i++) {
            by[i]=raf.readChar();
        }
        return new String(by).replace('\u0000',' ');
    }
}
class person{
    private StringBuilder name;     //固定15个字符=30字节
    private int age;

    public person(String name,int age){
        this.age=age;
        if(name!=null){
            this.name=new StringBuilder(name);

        }else {
            this.name=new StringBuilder(15);

        }
        this.name.setLength(15);        //设置为15个字符
    }
    public int getAge() {
        return this.age;
    }
    public String getName() {
        return this.name.toString();
    }
    public static int size(){
        return 34;

    }
}
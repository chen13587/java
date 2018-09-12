import java.io.*;
public class Main {
    public static void main(String args[]) throws Exception {
        System.out.println("*********序列化对象********");
        File file=new File("/home/chen/桌面/tmp/object");
        student std=new student("chen",29);
        serializable.write(std,file);
        student read_std=(student) serializable.read(file);
        System.out.println(read_std.getName());
        System.out.println(read_std.getAge());

        System.out.println("*********序列化普通变量********");
        File file1=new File("/home/chen/桌面/tmp/object1");
        serializable.write("hello world",file1);
        String str=(String) serializable.read(file1);
        System.out.println(str);
    }
}

class serializable{
    public static void write(Object o,File f) throws Exception {
        FileOutputStream out=new FileOutputStream(f);
        ObjectOutputStream oos=new ObjectOutputStream(out);
        oos.writeObject(o);
        oos.close();
    }
    public static Object read(File f) throws Exception{
        FileInputStream in=new FileInputStream(f);
        ObjectInputStream ois=new ObjectInputStream(in);
        Object o=ois.readObject();
        ois.close();
        return o;

    }
}

class student implements Serializable{     //注意：序列化的对象的类需要实现Serializable接口，虽然什么都没有
    private int age;
    private String name;
    public student(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public int getAge() {
        return age;
    }
}
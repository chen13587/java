import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        File file=new File("../../tmp/new");
        data.write(file);       //先写
        data.read(file);        //后读
    }
}

class data{
    public static void read(File dst) throws IOException {

        FileInputStream in=new FileInputStream(dst);
        DataInputStream dis=new DataInputStream(in);
        int num=dis.readInt();
        char c=dis.readChar();
        String str=dis.readUTF();
        Boolean b=dis.readBoolean();
        float f=dis.readFloat();

        dis.close();

        System.out.println(num);
        System.out.println(c);
        System.out.println(str);
        System.out.println(b);
        System.out.println(f);


    }
    public static void write(File src) throws IOException {
        FileOutputStream out=new FileOutputStream(src);
        DataOutputStream dos=new DataOutputStream(out);
        dos.writeInt(33);
        dos.writeChar('s');
        dos.writeUTF("world");
        dos.writeBoolean(false);
        dos.writeFloat((float)1.2);

        dos.close();
    }
}


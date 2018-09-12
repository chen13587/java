import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {

        System.out.println("*******输入流*******");
        String str="hello";
        ByteArrayInputStream in=new ByteArrayInputStream(str.getBytes());       //getBytes()返回字串的字节数组
        int dat;
        while (-1!=(dat=in.read())){
            System.out.println(dat);
        }

        System.out.println("*******输出流*******");
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        out.write(97);      //写到缓存区
        out.write(98);
        out.write(99);
        byte by[]=out.toByteArray();
        for (byte tmp:by) {
            System.out.println(tmp);
        }
        FileOutputStream f=new FileOutputStream("/home/chen/桌面/tmp/hhhh",true);     //true追加，false覆盖
        out.writeTo(f);     //writeTo写入到指定的输出流
        out.close();


    }
}

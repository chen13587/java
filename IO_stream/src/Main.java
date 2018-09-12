import java.io.*;
public class Main {
    public static void main(String args[]){
        try {
            IO.copy_new(new File("/home/chen/桌面/tmp/test"),new File("/home/chen/桌面/tmp/ff/tmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class IO{
    public static void copy_old(File src,File dst) throws IOException {     //速度慢，没有用到缓存区
        FileInputStream I_src=new FileInputStream(src);
        FileOutputStream O_dst=new FileOutputStream(dst);
        int dat;
        while (-1!=(dat=I_src.read())){     //注意：dat用于接收输入流的字节数据，到达末尾返回-1
            O_dst.write(dat);       //将dat的内容写到输出流
        }
        I_src.close();      //释放资源
        O_dst.close();
    }
    public static void copy_new(File src,File dst) throws IOException {     //使用缓存区，速度明显变快
        FileInputStream I_src=new FileInputStream(src);
        FileOutputStream O_dst=new FileOutputStream(dst);

        byte buf[]=new byte[1021*1024];     //输入流缓存区
        int len;
        while(-1!=(len=I_src.read(buf))){       //dat用来接收实际读取输入流的字节数量，到达末尾返回-1
            O_dst.write(buf,0,len);     //传入缓存区，缓存区数据起始位，缓存区数据末尾
        }

        I_src.close();      //释放资源
        O_dst.close();
    }




















}


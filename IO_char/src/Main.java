import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        file.copy_char(new File("/home/chen/桌面/tmp/任务.txt"),new File("/home/chen/桌面/tmp/任务2.txt"));


    }
}


class file{
    public static void copy_char(File src,File dst) throws IOException {
        FileReader in=new FileReader(src);
        FileWriter out=new FileWriter(dst);
        int len;
        char buf[]=new char[1024*1024];
        while (-1!=(len=in.read(buf))){
            out.write(buf,0,len);
        }
        in.close();
        out.close();        //注意：输出流若不关闭，就无法同步缓冲区内容到文件（默认：达到缓冲区大小一次性搬到文件）
                            //或者强制同步：out.flush();
    }

    public static void copy_byte(File src,File dst) throws IOException {
        FileInputStream in=new FileInputStream(src);
        FileOutputStream out=new FileOutputStream(dst);
        int len;
        byte buf[]=new byte[1024*1024];
        while (-1!=(len=in.read(buf))){
            out.write(buf,0,len);

        }
        in.close();
        out.close();

    }
}
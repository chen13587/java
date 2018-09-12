import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        int old_t= (int) System.currentTimeMillis();
        dir.copy_dir(new File("/home/chen/桌面/tmp"),new File("/home/chen/桌面/tmp3"));
        int spend_time=((int)System.currentTimeMillis()-old_t);
        System.out.println("消耗时间："+spend_time+"毫秒");
    }
}
class dir{
    public static void copy_dir(File src,File dst) throws IOException {
        dst.mkdirs();
        if(src!=null){
            File arr[] = src.listFiles();
            for (File f : arr) {
//                System.out.println(f.getName());
                if (f.isDirectory()) {
                    copy_dir(f,new File(dst.toString()+"/"+f.getName()));       //目标
                }else if(f.isFile()) {
                    byte buf[]=new byte[1024*1024];
                    FileInputStream in=new FileInputStream(f);
                    FileOutputStream out=new FileOutputStream(new File(dst.toString()+"/"+f.getName()));
                    int len;
                    while (-1!=(len=in.read(buf))){
                        out.write(buf,0,len);
                    }
                    in.close();     //注意：一定要关闭流
                    out.close();

                }
            }
        }
    }
}
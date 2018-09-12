import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        file.copy(new File("/home/chen/桌面/tmp/test"),new File("/home/chen/桌面/tmp/任务2.txt"));

    }
}

class file{
    public static void copy(File src, File dst) throws IOException {
        FileReader in=new FileReader(src);
        FileWriter out=new FileWriter(dst);
        BufferedReader br=new BufferedReader(in,8000);       //包装一层，添加缓存区
        BufferedWriter bw=new BufferedWriter(out,8000);
        String str;
        while((str=br.readLine())!=null){       // readLine()读取一行，不包含回车换行
            bw.write(str);
            bw.newLine();       //手动添加换行
        }
        br.close();
        bw.close();
    }
}
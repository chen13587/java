import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        File srcfile=new File("/home/chen/桌面/tmp/test1.txt");
        File dstfile=new File("/home/chen/桌面/tmp/test2.txt");

        change.write(srcfile,"你好\n陈鹏来哦哦","utf-8");       //指定写编码
        change.read(srcfile,dstfile,"utf-8");       //指定读取编码

    }

}
class change{
    public static void write(File file,String str,String encode) throws Exception {     //输出流，写到指定文件
        FileOutputStream out=new FileOutputStream(file);
        OutputStreamWriter osw=new OutputStreamWriter(out,encode);      //可以指定编码encode
        BufferedWriter bw=new BufferedWriter(osw);      //添加缓冲区

        bw.write(str);
        bw.close();
    }
    public static void read(File srcfile,File dstfile,String decode) throws Exception {     //读取源文件到目标文件
        /*******源文件输入流******/
        FileInputStream in=new FileInputStream(srcfile);
        InputStreamReader isr=new InputStreamReader(in,decode);
        BufferedReader br=new BufferedReader(isr);      //添加缓存区

        /*******目标文件输出流******/
        FileOutputStream out=new FileOutputStream(dstfile);
        OutputStreamWriter osw=new OutputStreamWriter(out,decode);
        BufferedWriter bw=new BufferedWriter(osw);      //添加缓冲区

        String line;
        while((line=br.readLine())!=null) {
//            System.out.print(line);       //输出结果到终端
//            System.out.print("\n");
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }
}
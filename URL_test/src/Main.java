import java.io.*;
import java.net.URL;
import java.net.URLConnection;
public class Main {
    public static void main(String args[]) throws IOException {
        file.download("http://fanyi.bdstatic.com/static/translation/img/header/logo_cbfea26.png",
                    "/home/chen/桌面/tmp/cpltest.png");
    }
}
class file{
    public static void download(String srcpath,String savepath) throws IOException {
        URL url=new URL(srcpath);       //实例化URL对象
        URLConnection conn=url.openConnection();    //连接资源
        InputStream is=conn.getInputStream();       //获取资源文件输入流

        File dir=new File(savepath);
        byte buf[]=new byte[1024*1024];
        if(!dir.isFile()){
            FileOutputStream fos=new FileOutputStream(dir);
            int len;
            System.out.println(url.getPath());
            while(-1!=(len=is.read(buf))){
                fos.write(buf,0,len);
            }
            fos.close();
        }else {
            System.out.println("文件已存在");
        }
        is.close();

    }
}
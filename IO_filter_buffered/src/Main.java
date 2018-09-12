import java.io.*;

public class Main {
    public static void main(String args[]){
        try {
            file.copy(new File("../../tmp/test"),new File("../../tmp/ff/test2"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

class file {
    public static void copy(File src, File dst) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out=new FileOutputStream(dst);
        BufferedInputStream bis=new BufferedInputStream(in);
        BufferedOutputStream bos=new BufferedOutputStream(out);     //包装一层
        int dat;
        while (-1!=(dat=bis.read())){       //从缓存区读取数据
            bos.write(dat);     //写到缓冲区，满了一次性搬到输出流
        }
        bis.close();
        bos.close();

    }
}
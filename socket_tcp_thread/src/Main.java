import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Main {
    public static void main(String argsp[]) throws IOException {
        ServerSocket ss=new ServerSocket(8080);
        int client_num = 0;

        while (true){
            System.out.println("等待客户端连接");

            Socket sd=ss.accept();
            System.out.println("客户端："+client_num+" 已连接");
            new Thread(new TCP_server(sd,client_num++))     //创建子线程
                    .start();       //启动子线程
        }
    }
}

class TCP_server implements Runnable{
    private Socket sd=null;
    private int client_num;
    public TCP_server(Socket sd,int client_num){
        this.sd=sd;
        this.client_num=client_num;
    }
    @Override
    public void run(){
        InputStreamReader isr=null;
        BufferedReader br=null;
        /******键盘key输入流+缓存区******/
        Task t1=new Task(client_num,sd);
        t1.start();

        /******Socket输入流*******/
        try{
            isr=new InputStreamReader(sd.getInputStream());
            br=new BufferedReader(isr);
            String line;
            while (!t1.getFlag()&&(null!=(line=br.readLine()))){
                System.out.print("客户端"+client_num+"数据："+line);
                System.out.print("\n");
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Task extends Thread{
    private int client_num;
    private boolean flag=false;
    private Socket sd=null;
    public Task(int client_num,Socket sd){
        this.client_num=client_num;
        this.sd=sd;
    }
    @Override
    public void run() {
        try {
            /*****键盘key输入流******/
            InputStreamReader key_isr=new InputStreamReader(System.in);
            BufferedReader key_br=new BufferedReader(key_isr);

            /******Socket输出流******/
            OutputStreamWriter osw=new OutputStreamWriter(sd.getOutputStream());
            BufferedWriter bos=new BufferedWriter(osw);
            String line;
            int num=0;
            while(!flag){
                line=key_br.readLine();     //注意：每个线程都会排队监听键盘输入流，一次输入，只有一个线程读取，流被读取一次，就没有了
                try{
                    num=Integer.parseInt(line.substring(0,line.indexOf(':')));
                }catch (Exception e){
                    System.out.println("ignore");
                    continue;
                }
                System.out.println("发送序号为"+num);
                if(client_num==num){        //如果输入id和自己不一样，不处理
                    System.out.println(client_num+"：执行发送");
                    bos.write(line.substring(line.indexOf(':')+1));
                    bos.newLine();
                    bos.flush();
                }
            }
            bos.close();
            key_br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean getFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}




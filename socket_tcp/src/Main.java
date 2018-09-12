import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Main {
    public static void main(String args[]) throws IOException {
//        TCP_server.server(8082);
        TCP_client.client("chenpl.xyz",8082);       //IP可以直接填域名
    }
}

/***********服务端：发送和接收为两个独立线程**********/
class TCP_server{
    public static void server(int port) throws IOException {
//        boolean flag=false;
        ServerSocket ss = new ServerSocket(port);

        System.out.println("开始监听");
        Socket sd=ss.accept();      //等待客户端连接，阻塞线程
        System.out.println("客户端已连接");

        /******键盘key输入流+缓存区*******/
        InputStreamReader key_isr=new InputStreamReader(System.in);     //以标准输入为输入流
        BufferedReader key_br=new BufferedReader(key_isr);

        /*******Socket输入流+缓存区*******/
        InputStreamReader idr=new InputStreamReader(sd.getInputStream());
        BufferedReader br=new BufferedReader(idr);

        /*******Socket输出流+缓冲区*******/
        OutputStreamWriter osw=new OutputStreamWriter(sd.getOutputStream());    //如果输出到文件，改成FileOutputStream即可
        BufferedWriter bw=new BufferedWriter(osw);



        /*******接收子线程*******/
        input_task task=new input_task(br);
        task.start();

        String key_line;
        /*******发送到客户端*******/
        while(!task.getFlag()){
            key_line=key_br.readLine();     //阻塞线程
            if(task.getFlag()){
                System.out.println("连接已断开");
                break;
            }
            if(key_line.equals("over")){
                task.setFlag(true);
                System.out.println("连接已断开");
                break;
            }
            bw.write(key_line);
            bw.newLine();
            bw.flush();
        }
        System.out.println("结束键盘输入");
        ss.close();     //关闭所有资源
        sd.close();
        br.close();
        bw.close();

    }
}


/***********客户端：发送和接收为两个独立线程**********/
class TCP_client{

    public static void client(String ip,int port) throws IOException {
        Socket sd=new Socket(ip,port);      //创建套接字对象

        /******键盘key输入流+缓存区*******/
        InputStreamReader key_isr=new InputStreamReader(System.in);
        BufferedReader key_br=new BufferedReader(key_isr);

        /******Socket输入流+缓存区******/
        InputStreamReader isr=new InputStreamReader(sd.getInputStream());
        BufferedReader br=new BufferedReader(isr);

        /******Socket输出流+缓冲区******/
        OutputStreamWriter osw=new OutputStreamWriter(sd.getOutputStream());
        BufferedWriter bw=new BufferedWriter(osw);

        /*******接收子线程*******/
        input_task task=new input_task(br);
        task.start();

        String key_line;
//        String line;
        while (!task.getFlag()){
            key_line=key_br.readLine();     //注意：会阻塞线程，不断读取键盘输入流
            if(task.getFlag()){
                System.out.println("连接已断开 ");
                break;
            }
            if(key_line.equals("over")){
                task.setFlag(true);
                System.out.println("连接已断开");        //?????
                break;
            }
            bw.write(key_line);    //输出到服务端
            bw.newLine();       //注意：因为服务端.readLine()以"\n"换行为结束符，若不换行将出错
            bw.flush();         //立即同步到输出流

//            line=br.readLine();     //读取套接字输入流
//            System.out.print(line);
//            System.out.print("\n");

        }
        System.out.println("结束键盘输入");
        //关闭资源
        key_br.close();
        bw.close();
        br.close();
        sd.close();
    }
}

class input_task extends Thread{
    public boolean flag=false;      //为true时，表示连接关闭
    BufferedReader br=null;
    public input_task( BufferedReader br){

        this.br=br;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public boolean getFlag() {
        return this.flag;
    }
    @Override
    public void run(){
        System.out.println("开启子线程");
        String line;
        try{
            while (!flag&&(null!=(line=br.readLine()))){    //注意：客户端发送的数据结尾一定要加"\n"换行
                //因为.readLine()以"\n"换行为结束符，且返回数据不带"\n"换行
                if (line.equals("over")){
                    flag=true;
                    break;
                }
                System.out.print(line);     //终端显示内容
                System.out.print("\n");
//                bw.write(line);
//                bw.newLine();       //注意：因为客户端.readLine()以"\n"换行为结束符，若不换行将出错
//                bw.flush();     //立即同步到输出流，否则缓冲区满了才同步
            }
            flag=true;
            System.out.println("客户端断开");
//                    ss.close();     //关闭所有资源
//                    sd.close();
//                    br.close();
//                    bw.close();
        }catch(Exception e){
            flag=true;
            System.out.println("线程内发生错误");
            System.out.println(e);
        }finally {
            flag=true;
        }
        System.out.println("结束子线程");
    }
}
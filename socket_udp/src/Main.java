import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException {
        /*****发送******/
//        udp.send("192.168.0.100",8000);

        /*****发送+接收 多线程******/
        udp.send_recv("192.168.0.100",8000);

        /******接收******/
//        udp.recv(8077);
    }
}
class udp{
    public static void send(String ip,int port) throws IOException {
        DatagramSocket sd=new DatagramSocket();

        /**********键盘key输入流+缓存区*********/
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String dat;
        while (true){
            dat=br.readLine();
            if(dat.equals("over")){
                break;
            }
            /**数据转换为字节数组，数据长度，目的地IP，目的地端口**/
            DatagramPacket packet=new DatagramPacket(dat.getBytes(),dat.length(),InetAddress.getByName(ip),port);
            sd.send(packet);
        }
        //关闭资源
        br.close();
        sd.close();
    }
    public static void recv(int port) throws IOException {
        DatagramSocket sd = new DatagramSocket(port);
        byte buf[] = new byte[100];
        while (true) {
            Arrays.fill(buf, (byte) 0);       //数组清零，内部就是for循环清零
            DatagramPacket packet = new DatagramPacket(buf, 100);      //字节缓存区，缓存区长度
            sd.receive(packet);     //接收数据，会阻塞线程

            System.out.println(new String(buf, 0, packet.getLength()));    //去掉尾部空字符
//            System.out.println(new String(packet.getData()).replace('\u0000',' '));       //替换空字符为' '空格
        }

    }

    public static void send_recv(String ip,int port) throws IOException {
        DatagramSocket sd=new DatagramSocket();

        /**********键盘key输入流+缓存区*********/
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String dat;

        Task t1=new Task(port);
        t1.start();

        while (!t1.getFlag()){
            dat=br.readLine();
            if(t1.getFlag()){
                System.out.println("连接已断开");
                break;
            }
            if(dat.equals("over")){
                t1.setFlag(true);
                System.out.println("连接已断开");
                break;
            }
            /**数据转换为字节数组，数据长度，目的地IP，目的地端口**/
            DatagramPacket packet=new DatagramPacket(dat.getBytes(),dat.length(),InetAddress.getByName(ip),port);
            sd.send(packet);
        }
        sd.close();
        br.close();
    }

}

class Task extends Thread{
    int port;
    DatagramSocket sd=null;
    private boolean flag=false;
    public Task(int port){
        this.port=port;
    }
    @Override
    public void run(){
        try {
            sd = new DatagramSocket(port);
            byte buf[] = new byte[100];
            String tmp=null;
            while(!flag) {
                Arrays.fill(buf, (byte) 0);       //数组清零，内部就是for循环清零
                DatagramPacket packet = new DatagramPacket(buf, 100);      //字节缓存区，缓存区长度
                sd.receive(packet);     //接收数据，会阻塞线程
                tmp=new String(buf, 0, packet.getLength());
                if (tmp.equals("over")){
                    flag=true;
                    break;
                }
                System.out.println(tmp);    //去掉尾部空字符
            }

        }catch(Exception e){
            System.out.println("线程内错误");
            System.out.println(e);
            flag=true;
        }
        flag=true;
        System.out.println("连接断开");
        sd.close();     //关闭资源
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}


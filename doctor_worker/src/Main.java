import java.util.Random;
public class Main {
    public static void main(String args[]){
        worker w=new worker();
        doctor d=new doctor();
        try {
            w.work();
        }catch (custom_abnormal e){
            System.out.println(e.getMsg());
            d.cure(w);
            System.out.println(w.getStatus());
        }finally{
            System.out.println("结束");
        }
    }
}

class custom_abnormal extends Exception{
    private String msg;
    public custom_abnormal(String msg){
        this.msg=msg;
    }
    public String getMsg() {
        return msg;
    }
}

class doctor{
    private Random ran=new Random();
    private int num;
    public void cure( worker w){
        num=ran.nextInt(3);
        if(num==1){
            w.setStatus("治不好，不幸身亡");
        }else {
            w.setStatus("治好了，恢复健康");
        }
    }
}

class worker{
    private Random ran=new Random();
    private int num;
    private String status;
    public void work()throws custom_abnormal{
        num=ran.nextInt(3);
        if(num==1){
            throw new custom_abnormal("我生病了");
        }else {
            System.out.println("正常上班");
        }
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}


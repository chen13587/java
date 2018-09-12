public class Main {
    public static void main(String args[]){
        bank bk=new bank();
        person per1=new person(bk,300);
        person per2=new person(bk,300);
        per1.start();
        per2.start();

    }
}
class person extends Thread{
    private bank bk=null;
    private int money;
    public person(bank bk,int money){
        this.bk=bk;
        this.money=money;
    }
    @Override
    public void run(){
        bk.get(money);
    }
}
class bank{
    private int money=500;
    private Object obj=new Object();
    public void get(int num) {        //同步方法
        synchronized(obj) {
            if(money<=0){
            System.out.println("余额为空");
            }else if(money<num){
                System.out.println("钱不够");
            }

            else{

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("错误：" + e);

                    }
                    money -= num;
                    System.out.println("取钱成功，余额：" + money);

            }
        }
    }
}


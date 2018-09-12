public class Main {
    public static void main(String args[]){
        person per=new person();
        try{
            per.check(12);
        }catch(custom_abnormal e){
            System.out.println(e.getmsg());
        }
    }
}

class custom_abnormal extends Exception{
    private String msg;
    public custom_abnormal(String msg){     //构造方法
        this.msg=msg;
    }
    public String getmsg(){
        return msg;
    }
}

class person {
    public void check(int age) throws custom_abnormal{
        if (age<18){
            throw new custom_abnormal("错误，年龄太小");
        }else {
            System.out.println("欢迎");
        }
    }
}

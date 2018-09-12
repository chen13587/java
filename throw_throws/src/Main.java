public class Main {
    public static void main(String args[]){
        try {
            bar per=new bar();
            per.check_age(85);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}

class bar{
    public void check_age(int age) throws Exception ,IllegalAccessException{
        if(age<18){
            throw new Exception("年龄太小");

        }else if(age>60){
            throw new IllegalAccessException("年龄太大");
        }else {
            System.out.println("欢迎光临");
        }

    }


}






public class object_test {
    public static void main(String args[]){
        user chen=new user("chen",18);
        chen.money=100;
        System.out.println(chen.toString());


    }



}

class user {
    private String name;
    private int age;
    public int money;
    public user(String name,int age){
        this.name=name;
        this.age=age;


    }
    @Override
    public String toString(){       //重写Object类的toString()方法
        return "hello ";
    }


}











public class static_test {
    public static void main(String args[]){
        person.sta_f();
        person.key=4;       //修改静态成员值
        person c=new person();
        System.out.println(c.key);  //静态成员值=上次修改的结果（因为共享一份）
    }
}

class person{
    public static int key;      //静态成员
    public String name ;      //非静态成员

    static {
        key=1;
        System.out.println("我是static语句块");  //调用类时就会执行，只执行1次，再次调用不再执行

    }
    public static void sta_f(){
        System.out.println("我是静态方法"+key);       //静态方法不能调用非静态成员name
    }


}








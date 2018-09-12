public class Main {
    public static void main(String args[]){
        try {
            char a[]=new char[2];
            System.exit(0);     //结束整个程序，将不会执行finally代码块
            a[12]=2;       //异常代码

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);

        }finally {
            System.out.println("善后工作");
        }
        System.out.println("正常");

    }
}






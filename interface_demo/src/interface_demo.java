import java.util.Scanner;

public class interface_demo {
    public static void main(String args[]){

        father f=new father();
        Scanner in=new Scanner(System.in);
        String in_str=in.nextLine();

        Iidea i = f.search(in_str);
        if(i!=null) {
            i.print();
            i.showdata();
//            System.out.println(i.name);
        }else {
            System.out.println("找不到指定的打印机");
        }
    }
}

class father{
    public Iidea search(String str){
        if(str.equals("黑白")){
            return new blackprint();
        }else if(str.equals("彩色")) {
            return new colorprint();

        }else{
            return null;
        }

    }
}

interface Iidea{        //接口
    public static final String name="hello";
    public abstract void print();
    public abstract void showdata();

}

class colorprint implements Iidea{
    @Override
    public void print() {
        System.out.println("彩色打印机");
    }
    @Override
    public void showdata() {
        System.out.println("彩色信息");
    }
}

class blackprint implements Iidea{
    @Override
    public void print() {
        System.out.println("黑白打印机");
    }
    @Override
    public void showdata() {
        System.out.println("黑白信息");
    }
}



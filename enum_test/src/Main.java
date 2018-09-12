public class Main {
    public static void main(String args[]){

//        System.out.println(Color.RED);
        System.out.println(Color.BLUE);     //直接调用对象，会自动调用.toString()方法
        Color c[]=Color.values();
        for (Color tmp :c){
            System.out.println(tmp);

        }
        switch (Color.GREEN){
            case BLUE:
                System.out.println("蓝色");
                break;
            case GREEN:
                System.out.println("蓝色");
                break;
            default :
                System.out.println("没有找到");
                break;
        }

    }
}

enum Color{
    RED(1),GREEN(2),BLUE(3),YEELOW(4);      //如果重写构造函数，并且带形参，枚举成员必须带实参
    private int age;

    private Color(int age){
        System.out.println("执行构造函数");
        this.age=age;

    }
    public int getAge(){
        return this.age;

    }
    public String toString(){
        return "重写自动调用方法"+name();
    }


}













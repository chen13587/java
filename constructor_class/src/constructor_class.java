public class constructor_class {
    public static void main(String args[]){
        cla a=new cla("chen",18);
        a.output();

    }

}


class cla{
    private String name;
    private int age;

    public cla(String name,int age){
        this.name=name;
        this.age=age;

    }
    public cla(){
        System.out.println("chen");
    }
    public void output(){
        System.out.println("名字: "+this.name+"，年龄: "+age);


    }


}



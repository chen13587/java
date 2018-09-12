

public class constructor_overload {
    public static void main(String args[]){
        person per=new person("chen",100,(byte)18);
        System.out.println(per.getdata());
        per.setdata("yxy",200);
        System.out.println(per.getdata());




    }
}

class person{
    public String name;
    public int money;
    public byte age;
    public person(String name,int money,byte age){
        this.name=name;
        this.money=money;
        this.age=age;
    }
    public person(String name,int money){
        this.name=name;
        this.money=money;

    }
    public person(String name){
        this.name=name;
    }
    public person(){

    }

    public void setdata(String name,int money,byte age) {
        this.name=name;
        this.money=money;
        this.age=age;
    }
    public void setdata(String name,int money) {
        this.name=name;
        this.money=money;

    }
    public void setdata(String name) {
        this.name=name;

    }

    public String getdata() {
        return "名字："+name+"，金钱："+money+"，年龄："+age;
    }
}





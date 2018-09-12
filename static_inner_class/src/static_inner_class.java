public class static_inner_class {
    public static void main(String args[]){
        person.inner obj=new person.inner();        //直接实例化静态内部类
        obj.setname("chen");
        obj.output();

        System.out.println(person.inner.money);     //直接访问静态内部类的静态成员/方法
    }
}

class person{
    public static String name;
    public int age;
//    inner n=new inner();
    public static class inner {
        public static  int money=10;
        public void setname(String name) {
            person.name = name;
        }
        public void output() {
            System.out.println(name);
        }
    }
}

















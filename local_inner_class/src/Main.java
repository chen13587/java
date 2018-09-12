public class Main {
    public static void main(String args[]){
        person per=new person();
        per.func();

    }
}

class person{
    public int age=20;
    public void func(){
        final String name="chen";
        class local_inner{
            public void getname(){
                System.out.println(person.this.age);
                System.out.println(name);       //访问所在方法的局部变量，该变量需要final修饰
            }
        }
        local_inner in=new local_inner();
        in.getname();
    }
}















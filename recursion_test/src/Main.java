public class Main {
    public static void main(String args[]){
        recursion r=new recursion();
        System.out.println(r.func(5));
    }
}
class recursion{
    public int func(int num){
        if(num==1){
            return 1;
        }
        return num * func(num - 1);
    }
}
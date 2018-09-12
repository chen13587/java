import java.util.Scanner;

public class get_input {
    public static void main(String args[]){
        char a[]={2,4,6,4};
        System.out.println("please input int");
        Scanner input =new Scanner(System.in);
        int num=input.nextInt();
        for(int i=0;i<a.length;i++){
            if (a[i] == num){
                System.out.println(i);
                break;
            }
        }
    }
}

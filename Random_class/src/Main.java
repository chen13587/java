import java.util.Random;

public class Main {

    public static void main(String args[]){
        Random rand=new Random(/*随机种子，可缺省*/);
        System.out.println(rand.nextInt(5));
        System.out.println(rand.nextDouble());
        System.out.println(put_random.output());
        System.out.println(put_random.output());

    }
}

class put_random{
    private static char char_arr[]={'a','b','c','d','e','f','g','h','i','j','k','1','2','3','4','5','6','7','8','9','0'};
    private static Random rand=new Random();

    public static String output(){
        char out[]=new char[4];
        int num;
        for(int i=0;i<out.length;i++) {
            num=rand.nextInt(21);
            out[i]=char_arr[num];
        }
        String str=new String(out,0,out.length);
        return str;
    }






}







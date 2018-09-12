import java.util.Scanner;

//实现二分查找法，前提是数组按大小有序排列
class search_bin{
    public int sea(int arr[],int num){
        int sta=0,end=arr.length,now=0;
        while (true){
            int bin=((end-sta)/2)+sta;        //二分下标
            if(arr[bin]==num){
                return bin;
            }
            else if(num>arr[bin]){
                sta=bin;
            }
            else if(num<arr[bin]){
                end=bin;
            }
        }
    }
}

public class binarysearch {
    public static void main(String args[]){
        int tmp[]={2,3,4,6,7,9,11,15,18,21};
        System.out.println("input search number:");
        Scanner input =new Scanner(System.in);
        int num=input.nextInt();
        search_bin search=new search_bin();
        System.out.println(search.sea(tmp,num));

    }
}


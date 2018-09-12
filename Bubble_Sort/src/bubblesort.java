public class bubblesort {
    public static void main(String args[]){
        int arr[]={8,15,9,43,16,22,21};
        sort c=new sort();
        c.func(arr);
    }
}

class sort{
    public void func(int arr[]){
       // 冒泡排序
        int tmp;
        for(int i=0;i<arr.length-1;i++){
            for(int t=0;t<(arr.length-i)-1;t++){
                if(arr[t]>arr[t+1]){
                    tmp=arr[t];
                    arr[t]=arr[t+1];
                    arr[t+1]=tmp;
                }
            }
        }


        for(int n=0;n<arr.length;n++){
            System.out.println(arr[n]);
        }
    }
}
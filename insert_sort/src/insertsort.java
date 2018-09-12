public class insertsort {
    public static void main(String args[]){
        int arr[]={5,7,1,78,6,2,8,20};
        insert s=new insert();
        s.sort(arr);
    }
}

class insert{
    public void sort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int j=i;
            while(j>0){
                if(arr[j]<arr[j-1]){
                    int tmp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=tmp;
                }

                j--;
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
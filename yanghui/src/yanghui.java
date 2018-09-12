public class yanghui {
    public static void main(String args[]){
    yh exe=new yh();
    exe.outout();

    }
}

class yh{
    public void outout() {
        int row = 8;
        int arr[][] = new int[row][row];
        for (int i=0;i<arr.length;i++) {
            for (int i2=0;i2<i+1;i2++){
                 arr[i][i2]=(i2==0)?(arr[i][i2]=1):(arr[i][i2]=arr[i-1][i2-1]+arr[i-1][i2]);
            }
        }


        for(int t=0;t<arr.length;t++){
            for(int t2=0;t2<arr[t].length;t2++){
                if(arr[t][t2]!=0){
                    System.out.print(arr[t][t2]+" ");
                }
            }
            System.out.println();

        }

    }

}





















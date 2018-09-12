

public class two_array {
    public static void main(String args[]){
        int arr[][]=new int[3][];   //声明二维数组

        arr[0]=new int[3];
        arr[1]=new int[4];
        arr[2]=new int[5];

        arr[0][0]=1;
        arr[0][1]=2;
        arr[0][2]=3;

        arr[1][0]=4;
        arr[1][1]=5;
        arr[1][2]=6;
        arr[1][3]=7;

        arr[2][0]=8;
        arr[2][1]=9;
        arr[2][2]=10;
        arr[2][3]=11;
        arr[2][4]=12;

        for(int t=0;t<arr.length;t++){
            for(int i=0;i<arr[t].length;i++){
                System.out.println(arr[t][i]);

            }
        }
    }


}

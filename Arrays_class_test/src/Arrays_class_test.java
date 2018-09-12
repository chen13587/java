import java.util.Arrays;

public class Arrays_class_test {
    public static void main(String args[]){
        System.out.println("数组拷贝");
        int arr[]={2,5,1,75,11,5};
        int tmp1[]=Arrays.copyOf(arr,10);

        for(int i=0;i<tmp1.length;i++)
            System.out.println(tmp1[i]);


        System.out.println("数组区间拷贝");
        int tmp2[]=Arrays.copyOfRange(arr,2,5);

        for(int i=0;i<tmp2.length;i++)
            System.out.println(tmp2[i]);


        System.out.println("数组比较");
        int arr1[]={1,2,3,4};
        int arr2[]={1,2,3,4};
        int arr3[]={4,7,8,5};
        boolean flag1= Arrays.equals(arr1,arr2);
        System.out.println(flag1);
        boolean flag2= Arrays.equals(arr1,arr3);
        System.out.println(flag2);


        System.out.println("数组填充");
        int arr4[]=new int[10];
        Arrays.fill(arr4,2,6,4);
        for(int i=0;i<arr4.length;i++)
            System.out.println(arr4[i]);



        System.out.println("数组排序");
        int arr5[]={2,5,8,3,1,6};
        Arrays.sort(arr5);
        for(int i=0;i<arr5.length;i++)
            System.out.println(arr5[i]);


        System.out.println("数组排序->二分法查找");
        int arr6[]={18,14,16,1,18,9,2,4,81};
        Arrays.sort(arr6);
        int num=Arrays.binarySearch(arr6,9);
        System.out.println(num);

    }







}

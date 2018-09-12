import java.lang.reflect.Array;
public class Main {
    public static void main(String args[]) throws Exception {
        System.out.println("***** 1维数组 ******");

        Class<?> tmp=Class.forName("java.lang.String");
        Object arr=Array.newInstance(tmp,10);
        Array.set(arr,2,"chen");
        System.out.println(Array.get(arr,2));

        System.out.println("***** 2维数组 ******");
        int arr1[]={3,3};    //尺寸

        Object arr_dou=Array.newInstance(int.class,arr1);    //创建arr2
        Object arr_sin=Array.get(arr_dou,1);       //难点：获取二维数组的一维数组，进行下一步操作
        Array.set(arr_sin,2,333);        //将一维数组赋值
        int arr_tmp[][]=(int[][]) arr_dou;     //强制转换

        System.out.println(arr_tmp[1][2]);




    }
}






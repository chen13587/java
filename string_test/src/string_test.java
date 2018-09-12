public class string_test {



    public static void main(String args[]){
        boolean f;
        String str=new String("hello chen");

        System.out.println("比较字串大小");
        String str1="Hello";
        String str2="hello";
        System.out.println(str1.compareTo(str2));


        System.out.println("判断字串是否相等");
        f=str.equals("hello");
        System.out.println(f);


        System.out.println("获取指定下标的字符");
        char a=str.charAt(3);
        System.out.println(a);


        System.out.println("获取字串第一次出现的下标");
        int num=str.indexOf("el");
        System.out.println(num);


        System.out.println("替换字符");
        String new_str=str.replace('e','a');
        System.out.println(new_str);


        System.out.println("分割字串为数组");
        String arr[]=str.split("ll");
        for (int i=0;i<arr.length;i++)
            System.out.println(arr[i]);


        System.out.println("区间截取字串");
        String new_str1=str.substring(2,7);
        System.out.println(new_str1);


    }






}

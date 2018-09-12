public class Main {
    public static void main(String args[]){
        StringBuilder str=new StringBuilder();

        str.append("append");
        System.out.println(str);

        str.insert(2,"insert");
        System.out.println(str);

        int i=str.indexOf("insert",0);
        System.out.println(i);

        System.out.println(str.length());       //返回字串长度
        System.out.println(str.charAt(4));

        System.out.println(str.capacity());     //返回字串变量的容量


    }
}





















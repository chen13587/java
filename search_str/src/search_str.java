public class search_str {
    public static void main(String args[]){
        String str="yxysdhsyxysidhyxysdfjs";
        search s=new search();
        int num=s.func(str,"yxy");
        System.out.println(num);
    }
}
class search{
    public int func(String str,String dst){
        int index=0,num=0;
        for(;;){
           index=str.indexOf(dst,index);
           if(index==-1){
               break;
           }
           index+=dst.length();
           num+=1;
        }
        return num;
    }
}
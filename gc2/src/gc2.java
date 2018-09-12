
public class gc2{

    static class fat_cla{
        public String s="hello";
        public void func(String str){
            System.out.println(str);

        }
    }
    static class  chi_cla extends fat_cla{

        public void func2(String str) {
            super.func(str);
        }
    }

    public static void main(String[] args){

        chi_cla c =new chi_cla();
        c.func2("hhhhhh");
    }

}










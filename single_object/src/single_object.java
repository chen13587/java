public class single_object {
    public static void main(String args[]){
        single_cla obj_1=single_cla.new_object();
        single_cla obj_2=single_cla.new_object();
        obj_1.name="name";
        System.out.println(obj_2.name);




    }
}

class single_cla{
    private static single_cla object=null;      //声明静态对象为null
    public String name;
    private single_cla(){
        System.out.println("我被实例化了");
    }
    public static single_cla new_object(){      //声明为静态，因为不能实例化，但要调用。声明为single_cla，因为要返回对象
        if(object==null){       //如果对象为null
            object=new single_cla();    //实例化一个对象
        }
        return object;
    }
}
























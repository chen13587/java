import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;



public class Main {
    public static void main(String args[]){
        System.out.println("*******创建目录*******");
        File new_dir=new File("/home/chen/桌面/tmp");
        System.out.println(new_dir.mkdir());      //创建指定目录

        System.out.println("*******创建文件*******");
        File new_f=new File("/home/chen/桌面/tmp/tt");
        try {
            System.out.println(new_f.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(new_f.exists());     //是否存在
        System.out.println(new_f.isDirectory());    //是否目录


        System.out.println("*******删除文件*******");
        File del_f=new File("/home/chen/桌面/tmp/tt");
        System.out.println(del_f.delete());


        System.out.println("*******返回目录内容*******");
        File dir_list=new File("/home/chen/桌面/tmp");
        String list[]=dir_list.list();
        for(String str:list){
            System.out.println(str);
        }

        System.out.println("*******返回过滤目录内容*******");
        File dir_filter=new File("/home/chen/桌面/tmp");
        String str[]=dir_filter.list(new FilenameFilter(){
            @Override
            public boolean accept(File dir,String name){
                return name.endsWith(".c");     //匹配结尾为".c"的
            }
        });
        for (String s:str){
            System.out.println(s);
        }

        System.out.println("*******返回目录下文件*******");
        File dir_file=new File("/home/chen/桌面/tmp");
        File file[]=dir_file.listFiles();
        for (File f:file){
            System.out.println(f.getName()+"->"+f.length());        //输出文件名和文件大小
        }

        System.out.println("*******带过滤，返回目录下文件*******");
        File f=new File("/home/chen/桌面/tmp");
        File f_arr[]=f.listFiles(new FileFilter(){
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith("c");
            }
        });
        for(File tmp:f_arr){
            System.out.println(tmp.getName()+"->"+tmp.length());
        }

    }
}

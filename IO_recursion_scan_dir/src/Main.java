import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String args[]){
        file f=new file();
        f.show("/home/chen/桌面/Java project");
    }
}
class file{
    private List<String> al=new ArrayList<>();
    private int level=0;        //记录目录层级

    public void show(String path){
        File dir=new File(path);        //得到目录句柄
        scan(dir);
        for (String s:al){      //输出目录内容
            System.out.println(s);
        }
    }

    private void scan(File path){
        File dir[]=path.listFiles();
        dir=sort(dir);
        for(File f:dir){

            if(f.isDirectory()){        //如果是文件夹
                al.add(getTab(level)+f.getName()+"/");
                level++;
                scan(f);
                level--;
            }
            else if(f.isFile()){        //如果是文件
                al.add(getTab(level)+f.getName());
            }
//            else if(f==null){       //没有了
//                return;
//            }
        }
    }
    private File[] sort(File old_f[]){      //对目录下的内容排序，目录靠前，文件靠后
        List<File> new_arr=new ArrayList<>();
        for(File tmp:old_f){
            if(tmp.isDirectory()){
                new_arr.add(tmp);
            }
        }
        for(File tmp:old_f){
            if(tmp.isFile()){
                new_arr.add(tmp);
            }
        }
        return new_arr.toArray(new File[new_arr.size()]);       //toArray：将数组转换为目标类型
    }
    private String getTab(int level){
        StringBuilder tab=new StringBuilder();
        for (int i=0;i<level;i++){
            tab.append("——");
        }
        return tab.toString();
    }
}
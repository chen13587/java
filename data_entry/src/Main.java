import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        entry en=new entry();
        en.setDb("szy",13);
        en.setDb("yff",23);
        en.setDb("fff",19);
        en.setDb("陈鹏来",20);
        en.setDb("杨欣怡",21);
        en.setDb("chen",18);
        en.setDb("wpl",14);
        en.setDb("szy",13);
        en.setDb("yff",23);
        en.setDb("fff",19);
        en.setDb("陈鹏来",20);
        en.setDb("杨欣怡",21);

        entry.database arr[]=en.getDb();
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i].getName());
            System.out.println(arr[i].getAge());
        }
    }
}


class entry{
    private database db[]=new database[5];
    private int counter=0;
    public void setDb(String name, int age){
        db[counter]=new database(name,age);
        counter++;
        if (counter>=db.length) {
            db=Arrays.copyOf(db,db.length*2);   //拷贝到更大的数组里
        }
    }
    class database{
        String name;
        int age;
        public database(String name, int age){      //构造方法
            this.name=name;
            this.age=age;

        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }

    public database[] getDb() {

        db=Arrays.copyOf(db,counter);
        return db;
    }
}





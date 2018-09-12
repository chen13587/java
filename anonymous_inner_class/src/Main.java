public class Main {
    public static void main(String[] args) {
        anonymous_inner dog=new anonymous_inner(){
            @Override
            public void eat(){
                System.out.println("吃骨头");
            }

        };
        dog.eat();
        new anonymous_inner(){
            @Override
            public void eat(){
                System.out.println("吃鱼肉");
            }
            public void run(){
                System.out.println("跑");

            }
        }.run();
    }
}

abstract class anonymous_inner {
    public abstract void eat();

}










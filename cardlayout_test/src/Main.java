import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String args[]){
        cardlayout cl=new cardlayout("cardlayout",600,500);
//        cl.init(600,600);

        cardlayout2 tmp=new cardlayout2("cardlayout",400,300);

    }
}

class cardlayout extends Frame {
    private Panel pa_1=new Panel();
    private Panel pa_2=new Panel();
    private FlowLayout fl_1=new FlowLayout(FlowLayout.LEFT);
    private FlowLayout fl_2=new FlowLayout(FlowLayout.RIGHT);
    private CardLayout cl_1=new CardLayout();
    private Label lb_1=new Label("111"),lb_2=new Label("222");
    public Button btn_1=new Button("btn1"),btn_2=new Button("btn2"),btn_3=new Button("btn3"),btn_4=new Button("btn4");
    public cardlayout(String title,int width ,int height){
        super(title);
        init( width , height);
        register_listener();
    }
    public void init(int width ,int height){
        this.setSize(width,height);
        this.setBackground(Color.PINK);
        this.setBounds(300,300,width,height);

        pa_1.setSize(400,400);
        pa_1.setBounds(0,0,400,400);
        pa_1.setBackground(Color.yellow);
        pa_1.setLayout(cl_1);
//        pa_1.add(new Button("btn1"));
//        pa_1.add(new Button("btn2"));
        pa_1.add(lb_1);

        pa_2.setSize(400,400);
        pa_2.setBounds(0,0,400,400);
        pa_2.setLayout(fl_1);       //设置为卡片布局
        pa_2.add(btn_1);       //添加控件
        pa_2.add(btn_2);
        pa_2.add(btn_3);
        pa_2.add(btn_4);
        pa_2.setBackground(Color.BLUE);
//        pa_2.add(lb_2);


        this.add(pa_1,BorderLayout.CENTER);
        this.add(pa_2,BorderLayout.SOUTH);

        this.setVisible(true);
    }
    public void register_listener(){
        btn_listener li=new btn_listener();     //实例化监听对象
        btn_1.addActionListener(li);        //btn绑定监听
        btn_2.addActionListener(li);
        btn_3.addActionListener(li);
        btn_4.addActionListener(li);

    }
}

class btn_listener implements ActionListener{       //设置监听事件
    @Override
    public void actionPerformed(ActionEvent e) {        //监听到就回调该方法
        System.out.println(e.getActionCommand());
//        System.out.println(btn_1);

    }
}

class cardlayout2 extends Frame{
    private CardLayout cl;
    private Panel pl;
    public cardlayout2(String str,int width,int height){
        super(str);
        init( width, height);
    }
    public void init(int width,int height){
        this.setSize(width,height);
        this.setBackground(Color.CYAN);
        this.setBounds(200,200,width,height);
        cl=new CardLayout();
        pl=new Panel();
        pl.setLayout(cl);
        pl.add(new Button("hello"));

        this.add(pl);
        this.setVisible(true);
    }
}


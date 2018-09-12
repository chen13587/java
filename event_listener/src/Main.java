import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String args[]){
        btn t=new btn("btn_listener",600,300);

    }
}
class btn extends Frame{
    private Button btn_1,btn_2;
    private Panel pl_1,pl_2;
    private CardLayout cl;
    private Label la;
    private TextField tx_1;
    public btn(String title,int width,int height){
        super(title);
        init(width,height);
        register();
    }
    public void init(int width,int height){
        this.setSize(width,height);
        this.setBackground(Color.yellow);
        this.setBounds(500,500,width,height);
        pl_1=new Panel();
        pl_1.setSize(300,300);
        pl_1.setLayout(new FlowLayout(FlowLayout.LEFT));      //面板1 设为流式布局
        btn_1=new Button("previous");
        btn_2=new Button("next");
        pl_1.add(btn_1);
        pl_1.add(btn_2);

        la=new Label("hello");
        tx_1=new TextField("hello");
        pl_2=new Panel();

        cl=new CardLayout();
        pl_2.setBackground(Color.CYAN);     //背景色
        pl_2.setLayout(cl);     //面板2 设为卡片布局
        pl_2.add(new Label("第一页"));
        pl_2.add(new Label("第二页"));
        pl_2.add(la);
        pl_2.add(tx_1);
        pl_2.add(new Label("第三页"));
        pl_2.add(new Label("第四页"));

        this.add(pl_2,BorderLayout.CENTER);
        this.add(pl_1,BorderLayout.SOUTH);
        this.setVisible(true);

    }
    public void register(){
        btn_listener listener=new btn_listener();
        btn_1.addActionListener(listener);      //button 绑定监听
        btn_2.addActionListener(listener);

        la.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e){     //dragged鼠标按下 并且移动
                la.setText("dragged");
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                la.setText(e.getX()+": "+e.getY());

            }
        });
        tx_1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }
        });

        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.out.println("关闭");
                System.exit(0);
            }
        });


    }




    class btn_listener implements ActionListener{       //匿名内部类
        @Override
        public void actionPerformed(ActionEvent e) {
//        System.out.println("监听到事件");
//        System.out.println(e.getSource());
//        System.out.println(e.getActionCommand());
            Object o=e.getSource(); //获取对象
            if(o==btn_1){
                System.out.println("按钮1 按下");
                cl.previous(pl_2);      //卡片布局 上一页
            }else if(o==btn_2){
                System.out.println("按钮2 按下");
                cl.next(pl_2);      //卡片布局 下一页

            }
        }
    }
}


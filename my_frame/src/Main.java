import java.awt.*;

public class Main {
    public static void main(String args[]){
        flowlayout mf=new flowlayout("flowlayout");
        mf.init(600,450);

        panellayout mf2=new panellayout("panellayout");
        mf2.init(600,400);

        borderlayout bl=new borderlayout("borderlayout");
        bl.init(400,250);

        gridlayout gl=new gridlayout("gridlayout");
        gl.init(400,400);
    }
}

class panellayout extends Frame {       //面板布局
    public panellayout(String title){
        super(title);
    }
    public void init(int width,int height){     //设置窗体宽和高
        this.setSize(width,height);
        this.setBackground(Color.pink);
        this.setBounds(500,400,width,height);
        this.setLayout(null);       //去掉窗口默认布局

        Panel panel=new Panel();    //实例化面板对象
        panel.setLayout(null);      //去掉面板默认布局
        panel.setBackground(Color.BLUE);    //面板颜色
        panel.setBounds(0,0,300,300);

        Button btn1=new Button("click");        //实例化button
        btn1.setBounds(200,100,100,50);     //设置button位置和大小
//        btn1.setSize(100,50);       //button大小
        btn1.setBackground(Color.gray);

        panel.add(btn1);

        this.add(panel);
        this.setVisible(true);   //显示窗口
    }

}
class flowlayout extends Frame{         //流式布局
    public flowlayout(String title){
        super(title);
    }
    public void init(int width,int height){
        this.setBackground(Color.yellow);
        this.setBounds(400,400,500,300);
        FlowLayout flow=new FlowLayout(FlowLayout.LEFT,20,20);

        this.setLayout(flow);
        this.add(new Button("btn1"));
        this.add(new Button("btn2"));
        this.add(new Button("btn3"));
        this.add(new Button("btn4"));
        this.add(new Button("btn5"));
        this.setVisible(true);
    }
}

class borderlayout extends Frame{          //边界布局
    public borderlayout(String title){
        super(title);
    }
    public void init(int width,int height){
        this.setSize(width,height);
        this.setBounds(200,200,width,height);
        this.setBackground(Color.yellow);
        this.add(new Button("btn1"),BorderLayout.EAST);
        this.add(new Button("btn1"),BorderLayout.CENTER);
        this.add(new Button("btn1"),BorderLayout.SOUTH);

        this.setVisible(true);
    }
}

class gridlayout extends Frame{         //网格布局
    public gridlayout(String title){
        super(title);
    }
    public void init(int width ,int height){
        this.setSize(width,height);
        this.setLayout(null);
        this.setBackground(Color.pink);
        this.setBounds(200,200,width,height);
        GridLayout gl=new GridLayout(2,6);
        this.setLayout(gl);

        this.add(new Button("btn1"));
        this.add(new Button("btn2"));
        Button btn4=new Button("bth4");
        btn4.setSize(40,20);
        this.add(btn4);
        this.add(new Button("btn5"));

        this.setVisible(true);
    }
}














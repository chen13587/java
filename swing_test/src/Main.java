import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
    public static void main(String args[]){
        my_frame mf=new my_frame("swing",400,400);
    }
}
class my_frame extends JFrame {
    private JTextArea ta=null;
    private Button btn1=null;
    private JScrollPane sp=null;
    private JMenuBar mb=null;
    private JMenuItem nfile,ofile,cfile,npro,cpro,abt;
    private JPanel pa;
    public my_frame(String title,int width,int height){
        super(title);
        init( width, height);

    }
    public void init(int width,int height){
        this.setSize(width,height);
        Container con=this.getContentPane();
        btn1=new Button("btn1");

        con.setBackground(Color.yellow);

        ta=new JTextArea();
        sp=new JScrollPane();
        sp.setViewportView(ta);

        //创建菜单栏
        mb=new JMenuBar();
        JMenu file=new JMenu("file");
        JMenu project=new JMenu("project");
        JMenu about=new JMenu("about");
        //菜单
        mb.add(file);
        mb.add(project);
        mb.add(about);
        //菜单下拉项
         nfile=new JMenuItem("新文件");
         ofile=new JMenuItem("打开文件");
         cfile=new JMenuItem("关闭文件");
         npro=new JMenuItem("新工程");
         cpro=new JMenuItem("关闭工程");
         abt=new JMenuItem("关于");

        file.add(nfile);        //下拉项添加到菜单
        file.add(ofile);
        file.add(cfile);

        project.add(npro);
        project.add(cpro);

        about.add(abt);

        this.setJMenuBar(mb);
//        con.add(mb,BorderLayout.NORTH);
        pa=new JPanel();
        pa.add(btn1);       //注意：按钮添加到面板中，才不会铺满空间
        con.add(sp,BorderLayout.CENTER);
//        btn1.setSize(30,54);
        con.add(pa,BorderLayout.SOUTH);

        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension ds=kit.getScreenSize();

        int w=ds.width;     //获取屏幕宽
        int h=ds.height;    //获取屏幕长
        int win_w=this.getWidth();
        int win_h=this.getHeight();
        this.setLocation((w-win_w)/2,(h-win_h)/2);      //设置窗口位置
//        this.setDefaultCloseOperation();
        register();     //注意：注册监听要在显示界面之前执行
        this.setVisible(true);
    }
    public void register(){     //注册监听
        nfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_file();
            }
        });
        ofile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open_file();
            }
        });
        abt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                about();
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText(ta.getText()+" click");
            }
        });

        this.setDefaultCloseOperation(3);
    }
    public void new_file(){
        if(!ta.getText().equals("")){
            int res=JOptionPane.showConfirmDialog(null,"是否保存","提示",JOptionPane.YES_OPTION,JOptionPane.NO_OPTION);
            if(res==JOptionPane.YES_OPTION){
                System.out.println("save file");
                FileDialog fd=new FileDialog(this,"保存文件",FileDialog.SAVE);
                fd.setVisible(true);
            }else{
                ta.setText("");     //清空TextArea内容
            }
        }
    }
    public void open_file(){        //打开文件
        FileDialog fd=new FileDialog(this,"打开文件",FileDialog.LOAD);
        fd.setVisible(true);
    }
    public void about(){
        about_cialog ab=new about_cialog(this,"about",true);        //模式对话框
    }
}

class about_cialog extends JDialog{
    private JLabel label=new JLabel("hello");
    private JPanel panel=new JPanel();
    private JButton btn=new JButton("ok");
    public about_cialog(Frame f,String t,boolean b){
        super(f,t,b);
        init();

    }
    public void init(){

        label.setText("<html> hello <br/>cpl my pc is linux hhhhh</html>");
        panel.setLayout(new FlowLayout());
//        panel.add(label);
        panel.add(btn);

        this.setSize(200,200);
        this.add(label);
        this.add(panel,BorderLayout.SOUTH);

        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension t=tk.getScreenSize();
        int width=t.width;
        int height=t.height;
        int w=this.getWidth();
        int h=this.getHeight();
        this.setLocation((width-w)/2,(height-h)/2);



        register();
        this.setVisible(true);
    }
    public void register(){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                about_cialog.this.dispose();          //注意：不能直接this，因为当前类为ActionListener类
            }
        });


    }
}


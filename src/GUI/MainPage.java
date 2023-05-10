package GUI;


import DTO.Loger;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage{
    private JFrame frame;
    private JPanel panelMain;
    public MainPage(Loger us){
        frame=new JFrame();
        JPanel mb = new JPanel();
        mb.setBounds(0,0,1100,45);
        mb.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton btnSystem =new JButton("Help");

        JButton btnSearch =new JButton("Search");
        mb.add(btnSystem);

        mb.add(btnSearch);


        JPanel panel=new JPanel();
        panel.setBounds(0,50,290,590);
        panel.setBorder(new LineBorder(Color.BLACK));
        panel.setLayout(new BorderLayout());
        JPanel pn1=new JPanel();
        pn1.setBounds(0,50,288,100);
        pn1.setLayout(new GridLayout(2,2,5,5));
        JLabel lb1=new JLabel("User:");
        lb1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JLabel txtUserName=new JLabel(us.getHoten());
        txtUserName.setForeground(Color.BLUE);
        txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        JLabel lb2=new JLabel("Today:");
        lb2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JLabel time=new JLabel(date.toString());
        time.setForeground(Color.red);
        time.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pn1.add(lb1);
        pn1.add(txtUserName);
        pn1.add(lb2);
        pn1.add(time);
        panel.add(pn1,BorderLayout.NORTH);

        JPanel pnMenu =new JPanel();
        pnMenu.setBounds(0,150,288,390);
        pnMenu.setLayout(new GridLayout(9,1,0,10));
        pnMenu.setBorder(new LineBorder(Color.BLACK));
        JLabel menu=new JLabel("MENU",JLabel.CENTER);
        menu.setFont(new Font("Tahoma", Font.PLAIN, 25));
        menu.setOpaque(true);
        menu.setBackground(Color.BLUE);
        menu.setForeground(Color.WHITE);



        JButton nhapSV=new JButton("Nhập sinh viên");
        nhapSV.setForeground(Color.BLUE);
        JButton nhapGV=new JButton("Nhập Giáo viên");
        nhapGV.setForeground(Color.BLUE);
        JButton nhapDiem=new JButton("Nhập Điểm");
        nhapDiem.setForeground(Color.BLUE);
        JButton nhapLop=new JButton("Nhập Lớp");
        nhapLop.setForeground(Color.BLUE);
        JButton nhapKhoa=new JButton("Nhập Khoa");
        nhapKhoa.setForeground(Color.BLUE);
        JButton nhapMH=new JButton("Nhập Môn học");
        nhapMH.setForeground(Color.BLUE);

        pnMenu.add(menu);
        pnMenu.add(nhapSV);
        pnMenu.add(nhapGV);
        pnMenu.add(nhapDiem);
        pnMenu.add(nhapLop);
        pnMenu.add(nhapKhoa);
        pnMenu.add(nhapMH);
        panel.add(pnMenu,BorderLayout.CENTER);


        //======================================================



        frame.setLayout(new BorderLayout());
        frame.add(mb,BorderLayout.NORTH);
        frame.add(panel,BorderLayout.WEST);
        panelMain=new HDGUI().HD();
        frame.add(panelMain,BorderLayout.CENTER);
        nhapSV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelMain);
                panelMain=new StudentGUI().Student();
                frame.add(panelMain);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
        nhapMH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelMain);
                panelMain=new MonHocGUI().MonHoc();
                frame.add(panelMain);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
        nhapGV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelMain);
                panelMain=new GiangVienGUI().GiangVien();
                frame.add(panelMain);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
        nhapKhoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelMain);
                panelMain=new KhoaGUI().Khoa();
                frame.add(panelMain);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
        nhapLop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelMain);
                panelMain=new LopGUI().Lop();
                frame.add(panelMain);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
        nhapDiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelMain);
                panelMain=new DiemGUI().Diem();
                frame.add(panelMain);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelMain);
                panelMain=new Search().SearchPn();
                frame.add(panelMain);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
        btnSystem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelMain);
                panelMain=new HDGUI().HD();
                frame.add(panelMain);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
        frame.setBounds(200, 20, 1100, 700);
        frame.getContentPane().setBackground(Color.decode("#f89820"));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Wellcome");
    }
}

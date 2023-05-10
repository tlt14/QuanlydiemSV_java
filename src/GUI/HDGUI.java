package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class HDGUI {
    private JFrame frame;
    public JPanel HD(){
        frame=new JFrame();
        JPanel panelMain =new JPanel();
        panelMain.setLayout(new BorderLayout());
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new BorderLayout());
        JLabel lbMain=new JLabel("MARK MANAGER SYSTEM",JLabel.CENTER);
        lbMain.setFont(new Font("Tahoma", Font.PLAIN, 50));
        jPanel.setOpaque(true);
        jPanel.setBackground(Color.BLUE);
        lbMain.setForeground(Color.WHITE);
        jPanel.add(lbMain,BorderLayout.CENTER);

        JPanel pnContent=new JPanel();
        pnContent.setBorder(new LineBorder(Color.gray,5));
        pnContent.setLayout(new BorderLayout());

        JLabel contentName=new JLabel("HƯỚNG DẪN SỬ DỤNG PHẦN MỀM",JLabel.CENTER);
        contentName.setOpaque(true);
        contentName.setForeground(Color.red);

        JPanel pnHD =new JPanel();
        pnHD.setLayout(new GridLayout(5,1,5,10));

        JLabel l1=new JLabel("Bước 1: Kiểm tra và nhập,sửa, xóa... thông tin Khoa.");
        l1.setForeground(Color.red);
        JLabel l2=new JLabel("Bước 2: Kiểm tra và nhập,sửa, xóa... thông tin Lớp và Giáo Viên.");
        l2.setForeground(Color.red);
        JLabel l3=new JLabel("Bước 3: Kiểm tra và nhập,sửa, xóa... thông tin Sinh Viên.");
        l3.setForeground(Color.red);
        JLabel l4=new JLabel("Bước 4: Kiểm tra và nhập,sửa, xóa... thông tin Môn Học.");
        l4.setForeground(Color.red);
        JLabel l5=new JLabel("Bước 5: Kiểm tra và nhập,sửa, xóa... thông tin Điểm.");
        l5.setForeground(Color.red);

        pnHD.add(l1);
        pnHD.add(l2);
        pnHD.add(l3);
        pnHD.add(l4);
        pnHD.add(l5);


        pnContent.add(contentName,BorderLayout.NORTH);
        pnContent.add(pnHD,BorderLayout.CENTER);
        panelMain.add(jPanel,BorderLayout.NORTH);
        panelMain.add(pnContent,BorderLayout.CENTER);

        return panelMain;
    }
}

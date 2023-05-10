package GUI;

import BLL.StudentBLL;
import DTO.Student;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Search {
    private JTable data;
    private JFrame frame;
    private  JTextField txtMaLop;
    private  JTextField txtMaSV;
    private JButton sMaSV,sMaLop;
    public JPanel SearchPn(){
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
        pnContent.setLayout(new BorderLayout());
        JLabel contentName=new JLabel("Search",JLabel.CENTER);
        contentName.setOpaque(true);
        contentName.setBackground(Color.BLUE);
        contentName.setFont(new Font("Tahoma",Font.BOLD,30));
        contentName.setForeground(Color.decode("#f89820"));

        //=============Table
        JPanel pnlDataUser = new JPanel();
        frame.getContentPane().add(pnlDataUser);
        pnlDataUser.setLayout(new BorderLayout());

        data = new JTable();
        data.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
        data.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        data.setDefaultEditor(Object.class,null);

        JScrollPane js=new JScrollPane(data);
        pnlDataUser.add(js,BorderLayout.CENTER);

        JPanel pnFunction =new JPanel();
        pnFunction.setLayout(new BorderLayout());

        JPanel panelInfo=new JPanel();
        panelInfo.setBorder(new LineBorder(Color.BLUE,1));
        panelInfo.setLayout(new GridLayout(1,2,50,10));
        ImageIcon icon=new ImageIcon("images/search.png");
        JLabel s=new JLabel(icon);

        panelInfo.add(s);
        JPanel col1=new JPanel();
        col1.setLayout(new GridLayout(6,4,10,10));
        JLabel nhapMaLop =new JLabel("Nhập mã lớp");


        txtMaLop =new JTextField();
        sMaLop =new JButton("Tìm kiếm");

        col1.add(nhapMaLop);
        col1.add(txtMaLop);
        col1.add(sMaLop);

        JPanel col2=new JPanel();
        col2.setLayout(new GridLayout(6,2,10,10));
        JLabel timtheomasv =new JLabel("Nhập Mã Sinh Viên:");
        sMaSV=new JButton("Tìm kiếm");

        txtMaSV=new JTextField();
        col2.add(timtheomasv);
        col2.add(txtMaSV);
        col2.add(sMaSV);

        panelInfo.add(col1);
        panelInfo.add(col2);


        sMaSV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msv=txtMaSV.getText();
                getWithMaSV(msv);
                if(data.getRowCount()<1){
                    JOptionPane.showMessageDialog(frame,"Không có mã Sinh viên cần tìm","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                }
                txtMaLop.setText("");
                txtMaSV.setText("");
            }
        });
        sMaLop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ml=txtMaLop.getText();
                getWithMaLop(ml);
                if(data.getRowCount()<1){
                    JOptionPane.showMessageDialog(frame,"Không có mã Lớp cần tìm","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                }
                txtMaLop.setText("");
                txtMaSV.setText("");
            }
        });

//        pnFunction.add(panelInfo,BorderLayout.CENTER);
//        pnContent.add(contentName);
//        pnContent.add(pnFunction);
//        pnContent.add(pnlDataUser);
//        panelMain.add(jPanel);
//        panelMain.add(pnContent);

        pnFunction.add(panelInfo,BorderLayout.CENTER);

//===========================================
        pnContent.add(contentName,BorderLayout.NORTH);
        pnContent.add(pnlDataUser,BorderLayout.CENTER);
        pnContent.add(pnFunction,BorderLayout.SOUTH);

        panelMain.add(jPanel,BorderLayout.NORTH);
        panelMain.add(pnContent,BorderLayout.CENTER);
        return panelMain;
    }
    public void getWithMaSV(String masv){
        String[] header = { "ID", "Họ Tên", "ID Lớp", "Hệ đào tạo","Ngày Sinh","Địa chỉ","Giới Tính","Số điện thoại" };
        DefaultTableModel dtm=new DefaultTableModel(header,0);
        StudentBLL stBll =new StudentBLL();
        ArrayList<Student> arr= stBll.getWithMasv(masv);
        Student st=new Student();
        for(int i=0;i<arr.size();i++){
            st=arr.get(i);
            int maSV=st.getMaSV();
            String TenSV=st.getHoten();
            String MaLop=st.getMaLop();
            String Hedt=st.getHedaotao();
            String Ngsinh = st.getNgaySinh();
            String Diachi =st.getDiaChi();
            String gioitinh=st.isGioitinh()?"Nam":"Nữ";
            String Sdt=st.getSDT();
            Object[] row={maSV,TenSV,MaLop,Hedt,Ngsinh,Diachi,gioitinh,Sdt};
            dtm.addRow(row);
        }
        data.setModel(dtm);
    }
    public void getWithMaLop(String malop){
        String[] header = { "ID", "Họ Tên", "ID Lớp", "Hệ đào tạo","Ngày Sinh","Địa chỉ","Giới Tính","Số điện thoại" };
        DefaultTableModel dtm=new DefaultTableModel(header,0);
        StudentBLL stBll =new StudentBLL();
        ArrayList<Student> arr= stBll.getWithMalop(malop);
        Student st=new Student();
        for(int i=0;i<arr.size();i++){
            st=arr.get(i);
            int maSV=st.getMaSV();
            String TenSV=st.getHoten();
            String MaLop=st.getMaLop();
            String Hedt=st.getHedaotao();
            String Ngsinh = st.getNgaySinh();
            String Diachi =st.getDiaChi();
            String gioitinh=st.isGioitinh()?"Nam":"Nữ";
            String Sdt=st.getSDT();
            Object[] row={maSV,TenSV,MaLop,Hedt,Ngsinh,Diachi,gioitinh,Sdt};
            dtm.addRow(row);
        }
        data.setModel(dtm);
    }

    private void resetForm(){
        txtMaLop.setText("");
        txtMaSV.setText("");

    }
    public void setPicture(JLabel label, String fileName) {
        try {
            BufferedImage image = ImageIO.read(new File(fileName));
            int w = label.getSize().width;
            int h = label.getSize().height;
            int iw = image.getWidth();
            int ih = image.getHeight();
            int dw = 0;
            int dh = 0;
            if (w / h > iw / ih) {
                dh = h;
                dw = dh * iw / ih;
            } else {
                dw = w;
                dh = dw * ih / iw;
            }
            ImageIcon icon = new ImageIcon(image.getScaledInstance(dw, dh,
                    Image.SCALE_SMOOTH));
            label.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

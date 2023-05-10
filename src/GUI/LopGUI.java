package GUI;


import BLL.KhoaBLL;
import BLL.LopBLL;
import CheckForm.check;
import DTO.Khoa;
import DTO.Lop;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

public class LopGUI {
    private JTable data;
    private JFrame frame;
    private  JTextField txtMaLop;
    private  JTextField txtTenLop;
    private  JTextField txtKhoaHoc;
    private JComboBox cb;
    private JButton ADD,DELETE,UPDATE;
    public JPanel Lop(){
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
        JLabel contentName=new JLabel("INFORMATION CLASS",JLabel.CENTER);
        contentName.setOpaque(true);
        contentName.setBackground(Color.BLUE);
        contentName.setFont(new Font("Tahoma",Font.BOLD,30));
        contentName.setForeground(Color.decode("#f89820"));

        //=============Table
        data= new JTable();
        JPanel pnlDataUser = new JPanel();
        frame.getContentPane().add(pnlDataUser);
        pnlDataUser.setLayout(new BorderLayout());

        data.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
        data.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        data.setDefaultEditor(Object.class,null);

        getAllLop();
        JScrollPane js=new JScrollPane(data);
        pnlDataUser.add(js);

        JPanel pnFunction =new JPanel();
        pnFunction.setLayout(new BorderLayout());

        JPanel panelInfo=new JPanel();
        panelInfo.setBorder(new LineBorder(Color.BLUE,1));
        panelInfo.setLayout(new GridLayout(1,2,10,10));

        JPanel col1=new JPanel();
        col1.setLayout(new GridLayout(4,4,10,10));
        JLabel MaLop =new JLabel("Mã Lớp");
        JLabel TenLop =new JLabel("Tên Lớp");
        JLabel MaKhoa =new JLabel("Mã Khoa");
        JLabel KhoaHoc =new JLabel("Khóa Học");


        txtMaLop =new JTextField();
        txtTenLop =new JTextField();
        txtKhoaHoc =new JTextField();

        col1.add(MaLop);
        col1.add(txtMaLop);
        col1.add(TenLop);
        col1.add(txtTenLop);
        col1.add(MaKhoa);

        ArrayList<Khoa> k=new ArrayList<Khoa>();
        KhoaBLL khoaBLL=new KhoaBLL();
        k=khoaBLL.getAllCat();
        Vector<String> makhoa=new Vector<String>();
        for(int i=0;i<k.size();i++){
            makhoa.add(k.get(i).getMaKhoa());
        }
        cb=new JComboBox(makhoa);

        col1.add(cb);
        col1.add(KhoaHoc);
        col1.add(txtKhoaHoc);


        panelInfo.add(col1);


        JPanel panelButton=new JPanel();
        panelButton.setBorder(new LineBorder(Color.BLUE,1));
        panelButton.setLayout(new GridLayout(4,1,10,10));
        panelButton.setPreferredSize(new Dimension(150,170));
        ADD=new JButton("ADD");
        ADD.setBackground(Color.WHITE);
        UPDATE=new JButton("UPDATE");
        UPDATE.setBackground(Color.WHITE);
        DELETE=new JButton("DELETE");
        DELETE.setBackground(Color.WHITE);
        ADD.setEnabled(true);
        DELETE.setEnabled(false);
        UPDATE.setEnabled(false);
        JButton RESET=new JButton("RESET");
        RESET.setBackground(Color.WHITE);
        panelButton.add(ADD);
        panelButton.add(UPDATE);
        panelButton.add(DELETE);
        panelButton.add(RESET);


        pnFunction.add(panelInfo,BorderLayout.CENTER);
        pnFunction.add(panelButton,BorderLayout.EAST);

//===========================================
        pnContent.add(contentName,BorderLayout.NORTH);
        pnContent.add(pnlDataUser,BorderLayout.CENTER);
        pnContent.add(pnFunction,BorderLayout.SOUTH);

        panelMain.add(jPanel,BorderLayout.NORTH);
        panelMain.add(pnContent,BorderLayout.CENTER);
        ADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkdata()){
                    Lop lop =new Lop();
                    lop.setMaLop(txtMaLop.getText());
                    lop.setTenLop(txtTenLop.getText().trim());
                    lop.setKhoaHoc(txtKhoaHoc.getText().trim());
                    lop.setMaKhoa(cb.getItemAt(cb.getSelectedIndex()).toString());
                    LopBLL lopBLL= new LopBLL();
                    int result=lopBLL.Insert(lop);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllLop();
                        resetForm();
                    }
                }
            }
        });
        UPDATE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkdata()){
                    Lop cat=new Lop();
                    cat.setTenLop(txtTenLop.getText());
                    cat.setMaLop(txtMaLop.getText().trim());
                    cat.setKhoaHoc(txtKhoaHoc.getText().trim());
                    cat.setMaKhoa(cb.getItemAt(cb.getSelectedIndex()).toString());
                    LopBLL catBLL= new LopBLL();
                    int result =catBLL.Update(cat);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Cập nhật thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllLop();
                        resetForm();
                    }
                }
            }
        });
        DELETE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lop cat=new Lop();
                cat.setMaLop(txtMaLop.getText());
                LopBLL catBLL= new LopBLL();
                int choice=JOptionPane.showConfirmDialog(frame,"Bạn chắc chắn muốn xóa chứ!!");
                if(choice==JOptionPane.YES_OPTION){
                    int result =catBLL.Delete(cat);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllLop();
                        resetForm();
                    }else{
                        JOptionPane.showMessageDialog(frame,"Xóa Thất bại","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        data.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row=data.getSelectedRow();
                ADD.setEnabled(false);
                DELETE.setEnabled(true);
                UPDATE.setEnabled(true);
                if(row!=-1){
                    txtMaLop.setEditable(false);
                    txtMaLop.setText(data.getValueAt(row,0).toString());
                    txtTenLop.setText(data.getValueAt(row,1).toString());
                    cb.setSelectedItem(data.getValueAt(row,2).toString());
                    txtKhoaHoc.setText(data.getValueAt(row,3).toString());
                }
            }
        });
        RESET.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });
        return panelMain;
    }
    public void getAllLop(){
        String[] header={"Mã Lớp","Tên Lớp","Mã Khoa","Khóa Học"};
        DefaultTableModel dtm=new DefaultTableModel(header,0);
        LopBLL catBll =new LopBLL();
        ArrayList<Lop> arr=catBll.getAll();
        Lop cat=new Lop();
        for(int i=0;i<arr.size();i++){
            cat=arr.get(i);
            String MaLop=cat.getMaLop();
            String TenLop=cat.getTenLop();
            String MaKhoa=cat.getMaKhoa();
            String KhoaHoc=cat.getKhoaHoc();
            Object[] row={MaLop,TenLop,MaKhoa,KhoaHoc};
            dtm.addRow(row);
        }
        data.setModel(dtm);
    }
    private void resetForm(){
        txtMaLop.setText("");
        txtMaLop.setEditable(true);
        txtTenLop.setText("");
        txtKhoaHoc.setText("");
        cb.setSelectedIndex(0);
        ADD.setEnabled(true);
        DELETE.setEnabled(false);
        UPDATE.setEnabled(false);
    }
    public boolean checkdata(){
        check c=new check();
        if(!c.isRequired(txtMaLop.getText()) ||
                !c.isRequired(txtKhoaHoc.getText())
                || !c.isRequired(txtTenLop.getText())
        ){
            JOptionPane.showMessageDialog(frame,"Vui lòng nhập đầy đủ thông tin.","Lỗi",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}

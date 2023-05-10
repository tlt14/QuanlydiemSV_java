package GUI;

import BLL.KhoaBLL;
import CheckForm.check;
import DTO.Khoa;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KhoaGUI {
    private JTable data;
    private JFrame frame;
    private  JTextField txtMaKhoa;
    private  JTextField txtTenKhoa;
    private  JTextField txtSDT;
    private JButton ADD,UPDATE,DELETE;
    public JPanel Khoa(){
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
        JLabel contentName=new JLabel("FACULTY INFORMATION",JLabel.CENTER);
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

        getAllKhoa();
        JScrollPane js=new JScrollPane(data);
        pnlDataUser.add(js,BorderLayout.CENTER);

        JPanel pnFunction =new JPanel();
        pnFunction.setLayout(new BorderLayout());

        JPanel panelInfo=new JPanel();
        panelInfo.setBorder(new LineBorder(Color.BLUE,1));
        panelInfo.setLayout(new GridLayout(1,2,10,10));

        JPanel col1=new JPanel();
        col1.setLayout(new GridLayout(4,4,10,10));
        JLabel MaMonHoc =new JLabel("Mã Khoa");
        JLabel TenMH=new JLabel("Tên Khoa");
        JLabel SoTC =new JLabel("Số ĐT Khoa");


        txtMaKhoa =new JTextField();
        txtTenKhoa =new JTextField();
        txtSDT =new JTextField();

        col1.add(MaMonHoc);
        col1.add(txtMaKhoa);
        col1.add(TenMH);
        col1.add(txtTenKhoa);
        col1.add(SoTC);
        col1.add(txtSDT);

        panelInfo.add(col1);


        JPanel panelButton=new JPanel();
        panelButton.setBorder(new LineBorder(Color.BLUE,1));
        panelButton.setLayout(new GridLayout(4,1,10,10));

        ADD=new JButton("ADD");
        ADD.setBackground(Color.WHITE);
        UPDATE=new JButton("UPDATE");
        UPDATE.setBackground(Color.WHITE);
        UPDATE.setEnabled(false);
        DELETE=new JButton("DELETE");
        DELETE.setBackground(Color.WHITE);
        DELETE.setEnabled(false);
        JButton RESET=new JButton("RESET");
        RESET.setBackground(Color.WHITE);
        panelButton.add(ADD);
        panelButton.add(UPDATE);
        panelButton.add(DELETE);
        panelButton.add(RESET);

        panelButton.setPreferredSize(new Dimension(150,150));

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
                    Khoa cat=new Khoa();
                    cat.setMaKhoa(txtMaKhoa.getText());
                    cat.setTenKhoa(txtTenKhoa.getText().trim());
                    cat.setSDT(txtSDT.getText().trim());
                    KhoaBLL catBLL= new KhoaBLL();
                    int result=catBLL.InsertCat(cat);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllKhoa();
                        resetForm();
                    }
                }
            }
        });
        UPDATE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkdata()){
                    Khoa cat=new Khoa();
                    cat.setMaKhoa(txtMaKhoa.getText());
                    cat.setTenKhoa(txtTenKhoa.getText().trim());
                    cat.setSDT(txtSDT.getText().trim());
                    KhoaBLL catBLL= new KhoaBLL();
                    int result =catBLL.UpdateCat(cat);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Cập nhật thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllKhoa();
                        resetForm();
                    }
                }
            }
        });
        DELETE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Khoa cat=new Khoa();
                cat.setMaKhoa(txtMaKhoa.getText());
                KhoaBLL catBLL= new KhoaBLL();
                int choice=JOptionPane.showConfirmDialog(frame,"Bạn chắc chắn muốn xóa chứ!!");
                if(choice==JOptionPane.YES_OPTION){
                    int result =catBLL.DeleteCat(cat);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllKhoa();
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
                if(row!=-1){
                    ADD.setEnabled(false);
                    DELETE.setEnabled(true);
                    UPDATE.setEnabled(true);
                    txtMaKhoa.setEditable(false);
                    txtMaKhoa.setText(data.getValueAt(row,0).toString());
                    txtTenKhoa.setText(data.getValueAt(row,1).toString());
                    txtSDT.setText(data.getValueAt(row,2).toString());
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
    public void getAllKhoa(){
        String[] header={"Mã Khoa","Tên Khoa","Số Điện Thoại"};
        DefaultTableModel dtm=new DefaultTableModel(header,0);
        KhoaBLL catBll =new KhoaBLL();
        ArrayList<Khoa> arr=catBll.getAllCat();
        Khoa cat=new Khoa();
        for(int i=0;i<arr.size();i++){
            cat=arr.get(i);
            String id=cat.getMaKhoa();
            String name=cat.getTenKhoa();
            String status=cat.getSDT();
            Object[] row={id,name,status};
            dtm.addRow(row);
        }
        data.setModel(dtm);
    }
    private void resetForm(){
        txtMaKhoa.setText("");
        txtTenKhoa.setText("");
        ADD.setEnabled(true);
        DELETE.setEnabled(false);
        UPDATE.setEnabled(false);
        txtSDT.setText("");
    }
    public boolean checkdata(){
        check c=new check();
        if(!c.isRequired(txtTenKhoa.getText()) ||
                !c.isRequired(txtSDT.getText())
                || !c.isRequired(txtMaKhoa.getText())
        ){
            JOptionPane.showMessageDialog(frame,"Vui lòng nhập đầy đủ thông tin.","Lỗi",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!c.checkPhone(txtSDT.getText())){
            JOptionPane.showMessageDialog(frame,"Số điện thoại không hợp lệ.","Lỗi",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}

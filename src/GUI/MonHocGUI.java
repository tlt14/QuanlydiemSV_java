package GUI;

import BLL.MonhocBLL;
import CheckForm.check;
import DTO.Monhoc;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MonHocGUI {
    private JTable data;
    private JFrame frame;
    private  JTextField txtMaMH  ;
    private  JTextField txtTenMH ;
    private  JTextField txtSTC   ;
    private  JTextField txtHocky ;
    private JTextField txtPhonghoc  ;
    private JComboBox txtHinhThucThi;
    private JButton ADD,UPDATE,DELETE;
    public JPanel MonHoc(){
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
        JLabel contentName=new JLabel("SUBJECT INFORMATION",JLabel.CENTER);
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

        getAllMH();
        JScrollPane js=new JScrollPane(data);
        pnlDataUser.add(js,BorderLayout.CENTER);

        JPanel pnFunction =new JPanel();
        pnFunction.setBounds(5,300,780,250);
        pnFunction.setLayout(new BorderLayout());

        JPanel panelInfo=new JPanel();
        panelInfo.setBorder(new LineBorder(Color.BLUE,1));
        panelInfo.setLayout(new GridLayout(1,2,10,10));

        JPanel col1=new JPanel();
        col1.setLayout(new GridLayout(4,4,10,10));
        JLabel MaMonHoc =new JLabel("Mã Môn Học");
        JLabel TenMH=new JLabel("Tên Môn Học");
        JLabel SoTC =new JLabel("Số TC");
        JLabel HocKy=new JLabel("Học Kỳ");


        txtMaMH  =new JTextField();
        txtTenMH =new JTextField();
        txtSTC   =new JTextField();
        txtHocky =new JTextField();

        col1.add(MaMonHoc);
        col1.add(txtMaMH);
        col1.add(TenMH);
        col1.add(txtTenMH);
        col1.add(SoTC);
        col1.add(txtSTC);
        col1.add(HocKy);
        col1.add(txtHocky);

        JPanel col2=new JPanel();
        col2.setLayout(new GridLayout(6,2,10,10));
        col2.setBounds(0,5,200,200);
        JLabel PhongHoc =new JLabel("Phòng Học:");
        JLabel HinhTT=new JLabel("Hình Thức Thi:");



        String HTT[]={"Trắc Nghiệm","Tự Luận","Vấn Đáp"};
         txtPhonghoc      =new JTextField();
        txtHinhThucThi    =new JComboBox(HTT);

        col2.add(PhongHoc);
        col2.add(txtPhonghoc);
        col2.add(HinhTT);
        col2.add(txtHinhThucThi);

        panelInfo.add(col1);
        panelInfo.add(col2);


        JPanel panelButton=new JPanel();
        panelButton.setBorder(new LineBorder(Color.BLUE,1));
        panelButton.setLayout(new GridLayout(4,1,10,10));

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

        panelButton.setPreferredSize(new Dimension(150,2));

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
                    Monhoc mh=new Monhoc();
                    mh.setTenMH(txtTenMH.getText());
                    mh.setSTC(Integer.parseInt(txtSTC.getText()));
                    mh.setPhongHoc(txtPhonghoc.getText());
                    mh.setHocKy(Integer.parseInt(txtHocky.getText()));
                    mh.setHinhThucThi(txtHinhThucThi.getItemAt(txtHinhThucThi.getSelectedIndex()).toString());
                    MonhocBLL mhBll=new MonhocBLL();
                    int result=mhBll.Insert(mh);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllMH();
                        resetForm();
                    }
                }
            }
        });
        UPDATE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkdata()){
                    Monhoc mh=new Monhoc();
                    mh.setTenMH(txtTenMH.getText());
                    mh.setSTC(Integer.parseInt(txtSTC.getText()));
                    mh.setPhongHoc(txtPhonghoc.getText());
                    mh.setHocKy(Integer.parseInt(txtHocky.getText()));
                    mh.setHinhThucThi(txtHinhThucThi.getItemAt(txtHinhThucThi.getSelectedIndex()).toString());
                    mh.setMaMH(Integer.parseInt(txtMaMH.getText()));
                    MonhocBLL mhBll=new MonhocBLL();
                    int result=mhBll.Update(mh);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Cập nhật thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllMH();
                        resetForm();
                    }
                }
            }
        });
        DELETE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Monhoc mh=new Monhoc();
                mh.setMaMH(Integer.parseInt(txtMaMH.getText()));
                MonhocBLL mhBll=new MonhocBLL();
                int choice=JOptionPane.showConfirmDialog(frame,"Bạn chắc chắn muốn xóa chứ!!");
                if(choice==JOptionPane.YES_OPTION){
                    int result =mhBll.Delete(mh);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllMH();
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
                    txtMaMH.setEditable(false);
                    txtMaMH.setText(data.getValueAt(row,0).toString());
                    txtTenMH.setText(data.getValueAt(row,1).toString());
                    txtSTC.setText(data.getValueAt(row,2).toString());
                    txtHinhThucThi.setSelectedItem(data.getValueAt(row,3).toString());
                    txtPhonghoc.setText(data.getValueAt(row,4).toString());
                    txtHocky.setText(data.getValueAt(row,5).toString());
                }
            }
        });
        RESET.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });
        txtMaMH.setEditable(false);
        return panelMain;
    }
    public void getAllMH(){
        String[] header={"Mã Môn Học","Tên Môn Học","Số Tín Chỉ","Hình thức thi","Phòng Học","Học Kỳ"};
        DefaultTableModel dtm=new DefaultTableModel(header,0);
        MonhocBLL mhBll =new MonhocBLL();
        ArrayList<Monhoc> arr= mhBll.getAllMH();
        Monhoc mh=new Monhoc();
        for(int i=0;i<arr.size();i++){
            mh=arr.get(i);
            int maMH=mh.getMaMH();
            String TenMH=mh.getTenMH();
            int STC=mh.getSTC();
            String Hinhthucthi=mh.getHinhThucThi();
            String Phonghoc = mh.getPhongHoc();
            int HocKy=mh.getHocKy();
            Object[] row={maMH,TenMH,STC,Hinhthucthi,Phonghoc,HocKy};
            dtm.addRow(row);
        }
        data.setModel(dtm);
    }
    private void resetForm(){
        txtHocky.setText("");
        txtPhonghoc.setText("");
        txtMaMH.setText("");
        txtMaMH.setEditable(false);
        txtSTC.setText("");
        txtHinhThucThi.setSelectedIndex(0);
        txtTenMH.setText("");
        ADD.setEnabled(true);
        DELETE.setEnabled(false);
        UPDATE.setEnabled(false);
    }
    public boolean checkdata(){
        check c=new check();
        if(!c.isRequired(txtPhonghoc.getText()) ||
                !c.isRequired(txtTenMH.getText())
                || !c.isRequired(txtHocky.getText())
                || !c.isRequired(txtSTC.getText())
        ){
            JOptionPane.showMessageDialog(frame,"Vui lòng nhập đầy đủ thông tin.","Lỗi",JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}

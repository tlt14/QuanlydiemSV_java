package GUI;

import BLL.GiangVienBLL;
import BLL.MonhocBLL;
import CheckForm.check;
import DTO.GiangVien;
import DTO.Monhoc;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class GiangVienGUI {
    private JFrame frame;
    private JTable data;
    private JTextField txtNgaysinh;
    private JTextField txtDiachi;
    private ButtonGroup txtGioiTinh;
    private JTextField txtSodienThoai;
    private JTextField txtMaGV;
    private JTextField txtHoten;
    private JTextField txtEmail;
    private String GT;
    private JComboBox cb;
    private JRadioButton radioBtn1,radioBtn2;
    private JButton ADD,UPDATE,DELETE;
    public JPanel GiangVien(){
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
        JLabel contentName=new JLabel("TEACHER INFORMATION",JLabel.CENTER);
        contentName.setOpaque(true);
        contentName.setBackground(Color.BLUE);
        contentName.setFont(new Font("Tahoma",Font.BOLD,30));
        contentName.setForeground(Color.decode("#f89820"));

        //=============Table
        data= new JTable();
        JPanel pnlDataUser = new JPanel();
        frame.getContentPane().add(pnlDataUser);
        pnlDataUser.setLayout(new BorderLayout());

        data = new JTable();
        data.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
        data.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getAllGv();
        JScrollPane js=new JScrollPane(data);
        pnlDataUser.add(js,BorderLayout.CENTER);

        JPanel pnFunction =new JPanel();
        pnFunction.setLayout(new BorderLayout());

        JPanel panelInfo=new JPanel();
        panelInfo.setBorder(new LineBorder(Color.BLUE,1));
        panelInfo.setLayout(new GridLayout(1,2,10,10));

        JPanel col1=new JPanel();
        col1.setLayout(new GridLayout(4,4,10,10));
        JLabel MaGV =new JLabel("Mã Giảng Viên");
        JLabel HoTen=new JLabel("Họ Tên");
        JLabel Email=new JLabel("Email");
        JLabel MonGiangDay =new JLabel("Môn Giảng Dạy");


        ArrayList<Monhoc> mh=new ArrayList<Monhoc>();
        MonhocBLL mhBLL=new MonhocBLL();
        mh=mhBLL.getAllMH();
        Vector<String> MaMH=new Vector<String>();
        for(int i=0;i<mh.size();i++){
            Monhoc Monhoc=mh.get(i);
            MaMH.add(String.valueOf(Monhoc.getMaMH()));
        }
        txtMaGV=new JTextField();
        txtHoten=new JTextField();
        txtEmail=new JTextField();
        cb=new JComboBox(MaMH);

        col1.add(MaGV);
        col1.add(txtMaGV);
        col1.add(HoTen);
        col1.add(txtHoten);
        col1.add(Email);
        col1.add(txtEmail);
        col1.add(MonGiangDay);
        col1.add(cb);

        JPanel col2=new JPanel();
        col2.setLayout(new GridLayout(4,4,10,10));
        JLabel Ngaysinh =new JLabel("Ngày Sinh");
        JLabel Diachi=new JLabel("Địa Chỉ");
        JLabel GioiTinh =new JLabel("Giới Tính");
        JLabel SodienThoai=new JLabel("Số điện thoại");


        txtNgaysinh=new JTextField();
        txtDiachi=new JTextField();
        txtGioiTinh=new ButtonGroup();
        radioBtn1 = new JRadioButton(" Nam");
        radioBtn1.setSelected(true);
        radioBtn2 = new JRadioButton(" Nữ");
        GT="1";
        radioBtn1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                GT= e.getStateChange()==1?"1":"0";
            }
        });
        radioBtn2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                GT=e.getStateChange()==1?"0":"1";
            }
        });
        JPanel radio=new JPanel();
        radio.setLayout(new FlowLayout(FlowLayout.LEFT));
        radio.add(radioBtn1);
        radio.add(radioBtn2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioBtn1);
        bg.add(radioBtn2);

        txtSodienThoai=new JTextField();

        col2.add(Ngaysinh);
        col2.add(txtNgaysinh);
        col2.add(Diachi);
        col2.add(txtDiachi);
        col2.add(GioiTinh);
        col2.add(radio);
        col2.add(SodienThoai);
        col2.add(txtSodienThoai);

        panelInfo.add(col1);
        panelInfo.add(col2);


        JPanel panelButton=new JPanel();
        panelButton.setBorder(new LineBorder(Color.BLUE,1));
        panelButton.setLayout(new GridLayout(4,2,10,10));

        ADD=new JButton("ADD");
        ADD.setBackground(Color.WHITE);
        UPDATE=new JButton("UPDATE");
        UPDATE.setEnabled(false);
        UPDATE.setBackground(Color.WHITE);
        DELETE=new JButton("DELETE");
        DELETE.setEnabled(false);
        DELETE.setBackground(Color.WHITE);
        JButton RESET=new JButton("RESET");
        RESET.setBackground(Color.WHITE);
        panelButton.add(ADD);
        panelButton.add(UPDATE);
        panelButton.add(DELETE);
        panelButton.add(RESET);

        panelButton.setPreferredSize(new Dimension(150,2));

        pnFunction.add(panelInfo,BorderLayout.CENTER);
        pnFunction.add(panelButton,BorderLayout.EAST);

        pnContent.add(contentName,BorderLayout.NORTH);
        pnContent.add(pnlDataUser,BorderLayout.CENTER);
        pnContent.add(pnFunction,BorderLayout.SOUTH);

        panelMain.add(jPanel,BorderLayout.NORTH);
        panelMain.add(pnContent,BorderLayout.CENTER);
        ADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkdata()) {
                    GiangVien gv=new GiangVien();
                    gv.setHoten(txtHoten.getText());
                    gv.setEmail(txtEmail.getText());
                    gv.setMonGiangDay(Integer.parseInt(cb.getItemAt(cb.getSelectedIndex()).toString()));
                    gv.setNgaySinh(txtNgaysinh.getText());
                    gv.setDiaChi(txtDiachi.getText());
                    gv.setGioitinh(Integer.parseInt(GT));
                    gv.setSDT(txtSodienThoai.getText());
                    GiangVienBLL gvBLL =new GiangVienBLL();
                    int result=gvBLL.Insert(gv);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllGv();
                        resetForm();
                    }
                }
            }
        });
        UPDATE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkdata()){
                    GiangVien st=new GiangVien();
                    st.setMaGV(Integer.parseInt(txtMaGV.getText()));
                    st.setHoten(txtHoten.getText());
                    st.setEmail(txtEmail.getText());
                    st.setMonGiangDay(Integer.parseInt(cb.getItemAt(cb.getSelectedIndex()).toString()));
                    st.setNgaySinh(txtNgaysinh.getText());
                    st.setDiaChi(txtDiachi.getText());
                    st.setGioitinh(Integer.parseInt(GT));
                    st.setSDT(txtSodienThoai.getText());
                    GiangVienBLL gvBLL =new GiangVienBLL();
                    int result=gvBLL.Update(st);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Cập nhật thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllGv();
                        resetForm();
                    }
                }
            }
        });
        DELETE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GiangVien st=new GiangVien();
                st.setMaGV(Integer.parseInt(txtMaGV.getText()));
                GiangVienBLL gvBLL=new GiangVienBLL();
                int choice=JOptionPane.showConfirmDialog(frame,"Bạn chắc chắn muốn xóa chứ!!");
                if(choice==JOptionPane.YES_OPTION){
                    int result =gvBLL.Delete(st);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllGv();
                        resetForm();
                    }else{
                        JOptionPane.showMessageDialog(frame,"Xóa Thất bại","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        RESET.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });
        data.setDefaultEditor(Object.class,null);
        data.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row=data.getSelectedRow();
                if(row!=-1){
                    ADD.setEnabled(false);
                    UPDATE.setEnabled(true);
                    DELETE.setEnabled(true);
                    txtMaGV.setEditable(false);
                    txtMaGV.setText(data.getValueAt(row,0).toString());
                    txtHoten.setText(data.getValueAt(row,1).toString());
                    txtEmail.setText(data.getValueAt(row,2).toString());
                    cb.setSelectedItem(data.getValueAt(row,3).toString());
                    txtNgaysinh.setText(data.getValueAt(row,4).toString());
                    txtDiachi.setText(data.getValueAt(row,5).toString());
                    if(data.getValueAt(row,6).toString()=="Nam"){
                        radioBtn1.setSelected(true);
                    }else{
                        radioBtn2.setSelected(true);
                    }
                    txtSodienThoai.setText(data.getValueAt(row,7).toString());
                }
            }
        });
        return panelMain;
    }
    public void getAllGv(){
        String[] header = { "ID", "Họ Tên", "Email", "Mã Môn Giảng Dạy","Ngày Sinh","Địa chỉ","Giới Tính","Số điện thoại" };
        DefaultTableModel dtm=new DefaultTableModel(header,0);
        GiangVienBLL gvBll =new GiangVienBLL();
        ArrayList<GiangVien> arr= gvBll.getAll();
        GiangVien gv=new GiangVien();
        for(int i=0;i<arr.size();i++){
            gv=arr.get(i);
            int maGv=gv.getMaGV();
            String TenGV=gv.getHoten();
            String Email=gv.getEmail();
            int MGD=gv.getMonGiangDay();
            String Ngsinh = gv.getNgaySinh();
            String Diachi =gv.getDiaChi();
            String gioitinh=gv.isGioitinh()?"Nam":"Nữ";
            String Sdt=gv.getSDT();
            Object[] row={maGv,TenGV,Email,MGD,Ngsinh,Diachi,gioitinh,Sdt};
            dtm.addRow(row);
        }
        data.setModel(dtm);
    }
    private void resetForm(){
        txtDiachi.setText("");
        cb.setSelectedIndex(0);
        radioBtn1.setSelected(true);
        txtHoten.setText("");
        txtSodienThoai.setText("");
        txtMaGV.setText("");
        txtMaGV.setEditable(false);
        txtEmail.setText("");
        txtNgaysinh.setText("");
        ADD.setEnabled(true);
        UPDATE.setEnabled(false);
        DELETE.setEnabled(false);
    }
    public boolean checkdata(){
        check c=new check();
        if(!c.isRequired(txtHoten.getText()) ||
                !c.isRequired(txtNgaysinh.getText())
                || !c.isRequired(txtDiachi.getText())
                || !c.isRequired(txtSodienThoai.getText())
                || !c.isRequired(txtEmail.getText())
        ){
            JOptionPane.showMessageDialog(frame,"Vui lòng nhập đầy đủ thông tin.","Lỗi",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!c.checkDate(txtNgaysinh.getText())){
            JOptionPane.showMessageDialog(frame,"Vui lòng nhập ngày sinh theo dạng dd/mm/yyyy hoặc dd-mm-yyyy.","Lỗi",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!c.checkPhone(txtSodienThoai.getText())){
            JOptionPane.showMessageDialog(frame,"Số điện thoại không hợp lệ.","Lỗi",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!c.checkEmail(txtEmail.getText())){
            JOptionPane.showMessageDialog(frame,"Email không hợp lệ.","Lỗi",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}

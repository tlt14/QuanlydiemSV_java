package GUI;

import BLL.LopBLL;
import BLL.StudentBLL;
import CheckForm.check;
import DTO.Lop;
import DTO.Student;
import Export.EpStudent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class StudentGUI {
    private JFrame frame;
    private JTable data;
    private JTextField txtNgaysinh;
    private JTextField txtDiachi;
    private ButtonGroup txtGioiTinh;
    private JTextField txtSodienThoai;
    private JTextField txtMasv;
    private JTextField txtHoten;
    private JComboBox txtLop;
    private JComboBox txtHdt;
    private String GT;
    private JRadioButton radioBtn1,radioBtn2;
    private JButton ADD,DELETE,UPDATE;
    public JPanel Student(){
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
        JLabel contentName=new JLabel("STUDENT INFORMATION",JLabel.CENTER);
        contentName.setOpaque(true);
        contentName.setBackground(Color.BLUE);
        contentName.setFont(new Font("Tahoma",Font.BOLD,30));
        contentName.setForeground(Color.decode("#f89820"));

        //=============Table
//        data= new JTable();
        JPanel pnlDataUser = new JPanel();
        frame.getContentPane().add(pnlDataUser);
        pnlDataUser.setLayout(new BorderLayout());


        data = new JTable();
        data.setDefaultEditor(Object.class,null);
        data.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
        data.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getAllSt();
        JScrollPane js=new JScrollPane(data);

        pnlDataUser.add(js,BorderLayout.CENTER);

        JPanel pnFunction =new JPanel();
        pnFunction.setLayout(new BorderLayout());

        JPanel panelInfo=new JPanel();
        panelInfo.setBorder(new LineBorder(Color.BLUE,1));
        panelInfo.setLayout(new GridLayout(1,2,10,10));

        JPanel col1=new JPanel();
        col1.setLayout(new GridLayout(4,4,10,10));
        JLabel MaSinhVien =new JLabel("Mã Sinh Viên");
        JLabel HoTen=new JLabel("Họ Tên");
        JLabel Lop =new JLabel("Lớp");
        JLabel HeDaoTao=new JLabel("Hệ đào tạo");


        txtMasv=new JTextField();
        txtHoten=new JTextField();
        ArrayList<DTO.Lop> l=new ArrayList<Lop>();
        LopBLL lBLL=new LopBLL();
        l=lBLL.getAll();
        Vector<String> Mal=new Vector<String>();
        for(int i=0;i<l.size();i++){
            Lop lop=l.get(i);
            Mal.add(String.valueOf(lop.getMaLop()));
        }
        txtLop=new JComboBox(Mal);
        String[]hdt={"Chính quy","Cao đẳng"};
        txtHdt=new JComboBox(hdt);

        col1.add(MaSinhVien);
        col1.add(txtMasv);
        col1.add(HoTen);
        col1.add(txtHoten);
        col1.add(Lop);
        col1.add(txtLop);
        col1.add(HeDaoTao);
        col1.add(txtHdt);

        JPanel col2=new JPanel();
        col2.setLayout(new GridLayout(4,4,10,10));
        JLabel Ngaysinh =new JLabel("Ngày Sinh");
        JLabel Diachi=new JLabel("Địa Chỉ");
        JLabel GioiTinh =new JLabel("Giới Tính");
        JLabel SodienThoai=new JLabel("Số điện thoại");


        txtNgaysinh=new JTextField();
        txtNgaysinh.setToolTipText("dd/mm/yyyy");
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
        panelButton.setLayout(new GridLayout(5,1,10,10));

        ADD=new JButton("ADD");
        ADD.setBackground(Color.WHITE);
        UPDATE=new JButton("UPDATE");
        UPDATE.setBackground(Color.WHITE);
        DELETE=new JButton("DELETE");
        DELETE.setBackground(Color.WHITE);
        JButton RESET=new JButton("RESET");
        RESET.setBackground(Color.WHITE);
        ADD.setEnabled(true);
        DELETE.setEnabled(false);
        UPDATE.setEnabled(false);
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



        JButton ex=new JButton("Export table");
        ex.setBackground(Color.GREEN);
        panelButton.add(ex);
        ADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkdata()){
                    Student st=new Student();
                    st.setHoten(txtHoten.getText());
                    st.setMaLop(txtLop.getItemAt(txtLop.getSelectedIndex()).toString());
                    st.setHedaotao(txtHdt.getItemAt(txtHdt.getSelectedIndex()).toString());
                    st.setNgaySinh(txtNgaysinh.getText());
                    st.setDiaChi(txtDiachi.getText());
                    st.setGioitinh(Integer.parseInt(GT));
                    st.setSDT(txtSodienThoai.getText());
                    StudentBLL stBLL =new StudentBLL();
                    int result=stBLL.Insert(st);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllSt();
                        resetForm();
                    }
                }
            }
        });
        UPDATE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkdata()) {
                    Student st=new Student();
                    st.setMaSV(Integer.parseInt(txtMasv.getText()));
                    st.setHoten(txtHoten.getText());
                    st.setMaLop(txtLop.getItemAt(txtLop.getSelectedIndex()).toString());
                    st.setHedaotao(txtHdt.getItemAt(txtHdt.getSelectedIndex()).toString());
                    st.setNgaySinh(txtNgaysinh.getText());
                    st.setDiaChi(txtDiachi.getText());
                    st.setGioitinh(Integer.parseInt(GT));
                    st.setSDT(txtSodienThoai.getText());
                    StudentBLL stBLL =new StudentBLL();
                    int result=stBLL.Update(st);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Cập nhật thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllSt();
                        resetForm();
                    }
                }
            }
        });
        DELETE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student st=new Student();
                st.setMaSV(Integer.parseInt(txtMasv.getText()));
                StudentBLL studentBLL=new StudentBLL();
                int choice=JOptionPane.showConfirmDialog(frame,"Bạn chắc chắn muốn xóa chứ!!");
                if(choice==JOptionPane.YES_OPTION){
                    int result =studentBLL.Delete(st);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllSt();
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
                    DELETE.setEnabled(true);
                    UPDATE.setEnabled(true);
                    txtMasv.setEditable(false);
                    txtMasv.setText(data.getValueAt(row,0).toString());
                    txtHoten.setText(data.getValueAt(row,1).toString());
                    txtLop.setSelectedItem(data.getValueAt(row,2).toString());
                    txtHdt.setSelectedItem(data.getValueAt(row,3).toString());
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
        ex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Nhập Mã Lớp muốn xuất");
                EpStudent ep=new EpStudent();
                ArrayList<Student> students=new StudentBLL().getAll();
                final String excelFilePath = "FileExport/Students_"+input+".xlsx";
                if(timMaSV(input,students)!=-1){
                    try {
                        final ArrayList<Student> student= new StudentBLL().getWithMalop(input);
                        ep.writeExcel(student,excelFilePath);
                        JOptionPane.showMessageDialog(frame,"File đã xuất nằm trong thư mục FileExport","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(frame,"Không tìm thấy lớp muốn xuất!","Thông báo",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return panelMain;
    }
    public void getAllSt(){
        String[] header = { "ID", "Họ Tên", "ID Lớp", "Hệ đào tạo","Ngày Sinh","Địa chỉ","Giới Tính","Số điện thoại" };
        DefaultTableModel dtm=new DefaultTableModel(header,0);
        StudentBLL stBll =new StudentBLL();
        ArrayList<Student> arr= stBll.getAll();
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
        txtDiachi.setText("");
        txtHdt.setSelectedIndex(0);
        radioBtn1.setSelected(true);
        txtHoten.setText("");
        txtSodienThoai.setText("");
        txtLop.setSelectedItem(0);
        txtMasv.setText("");
        txtNgaysinh.setText("");
        ADD.setEnabled(true);
        DELETE.setEnabled(false);
        UPDATE.setEnabled(false);
    }
    private int timMaSV(String s,ArrayList<Student> a){
        int result=-1;
        for(int i=0;i<a.size();i++){
            if(a.get(i).getMaLop().equals(s)){
                result =i;
                break;
            }
        }
        return result;
    }
    public boolean checkdata(){
        check c=new check();
        if(!c.isRequired(txtHoten.getText()) ||
                !c.isRequired(txtNgaysinh.getText())
                || !c.isRequired(txtDiachi.getText())
                || !c.isRequired(txtSodienThoai.getText())
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
        return true;
    }
}

package GUI;


import BLL.DiemBLL;
import BLL.LopBLL;
import BLL.MonhocBLL;
import BLL.StudentBLL;
import CheckForm.check;
import DTO.Diem;
import DTO.Lop;
import DTO.Monhoc;
import DTO.Student;
import Export.EpDiem;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class DiemGUI {
    private JTable data;
    private JFrame frame;
    private  JTextField txtDiem;
    private JComboBox  MaSV,MaLop,Mamh,LanThi,HeSo;
    private JRadioButton trangthai;
    private JButton ADD,DELETE,UPDATE;
    public JPanel Diem(){
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
        JPanel contentName =new JPanel();
        contentName.setLayout(new BorderLayout());

        JLabel content1=new JLabel("MARK INFORMATION",JLabel.CENTER);
        content1.setFont(new Font("Tahoma",Font.BOLD,30));
        content1.setForeground(Color.decode("#f89820"));
        String []fi={"Sắp xếp","Điểm tăng dần","Điểm giảm dần"};

        JComboBox sort=new JComboBox(fi);
        contentName.add(sort,BorderLayout.WEST);
        contentName.add(content1,BorderLayout.CENTER);
        contentName.setOpaque(true);
        contentName.setBackground(Color.BLUE);


        //=============Table
        data= new JTable();
        JPanel pnlDataUser = new JPanel();
        frame.getContentPane().add(pnlDataUser);
        pnlDataUser.setLayout(new BorderLayout());

        data = new JTable();
        data.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
        data.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        data.setDefaultEditor(Object.class,null);

        getAllDiem();
        JScrollPane js=new JScrollPane(data);
        pnlDataUser.add(js);

        JPanel pnFunction =new JPanel();
        pnFunction.setLayout(new BorderLayout());

        JPanel panelInfo=new JPanel();
        panelInfo.setBorder(new LineBorder(Color.BLUE,1));
        panelInfo.setLayout(new GridLayout(1,2,10,10));

        JPanel col1=new JPanel();
        col1.setLayout(new GridLayout(4,4,10,10));
        JLabel malop =new JLabel("Mã Lớp");
        JLabel masv=new JLabel("Mã Sinh Viên");
        JLabel mamh =new JLabel("Mã Môn học");
        JLabel lanthi =new JLabel("Lần thi");
        ArrayList<Lop> l=new ArrayList<Lop>();
        LopBLL lBLL=new LopBLL();
        l=lBLL.getAll();
        Vector<String> Mal=new Vector<String>();
        for(int i=0;i<l.size();i++){
            Lop lop=l.get(i);
            Mal.add(String.valueOf(lop.getMaLop()));
        }
        MaLop=new JComboBox(Mal);
        MaLop.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                ArrayList<Student> st=new ArrayList<Student>();
                StudentBLL stBLL=new StudentBLL();
                st=stBLL.getWithMalop(MaLop.getSelectedItem().toString());
                Vector<String> MaSt=new Vector<String>();
                for(int i=0;i<st.size();i++){
                    Student stn=st.get(i);
                    MaSt.add(String.valueOf(stn.getMaSV()));
                }
                col1.remove(malop);
                col1.remove(MaSV);
                col1.remove(masv);
                col1.remove(MaSV);
                col1.remove(mamh);
                col1.remove(Mamh);
                col1.remove(lanthi);
                col1.remove(LanThi);
                MaSV=new JComboBox(MaSt);
                col1.add(malop);
                col1.add(MaLop);
                col1.add(masv);
                col1.add(MaSV);
                col1.add(mamh);
                col1.add(Mamh);
                col1.add(lanthi);
                col1.add(LanThi);
                SwingUtilities.updateComponentTreeUI(col1);
            }
        });

        ArrayList<Student> st=new ArrayList<Student>();
        StudentBLL stBLL=new StudentBLL();
        st=stBLL.getAll();
        Vector<String> MaSt=new Vector<String>();
        for(int i=0;i<st.size();i++){
            Student stn=st.get(i);
            MaSt.add(String.valueOf(stn.getMaSV()));
        }
        MaSV=new JComboBox(MaSt);

        ArrayList<Monhoc> mhs=new ArrayList<Monhoc>();
        MonhocBLL mhBLL=new MonhocBLL();
        mhs=mhBLL.getAllMH();
        Vector<String> MaMH=new Vector<String>();
        for(int i=0;i<mhs.size();i++){
            Monhoc stn=mhs.get(i);
            MaMH.add(String.valueOf(stn.getMaMH()));
        }
        Mamh=new JComboBox(MaMH);
        String[] lt={"1","2","3"};
        LanThi=new JComboBox(lt);
        col1.add(malop);
        col1.add(MaLop);
        col1.add(masv);
        col1.add(MaSV);
        col1.add(mamh);
        col1.add(Mamh);
        col1.add(lanthi);
        col1.add(LanThi);

        JPanel col2=new JPanel();
        col2.setLayout(new GridLayout(6,2,10,10));
        col2.setBounds(0,5,200,200);
        JLabel heso =new JLabel("Hệ số");
        JLabel diem=new JLabel("Điểm");
        JLabel tt=new JLabel("Trạng Thái: ");
        trangthai=new JRadioButton("Bật/Tắt");
        txtDiem =new JTextField();

        String[] hs={"1","2","3"};
        HeSo=new JComboBox(hs);

        col2.add(heso);
        col2.add(HeSo);
        col2.add(diem);
        col2.add(txtDiem);
        col2.add(tt);
        col2.add(trangthai);

        panelInfo.add(col1);
        panelInfo.add(col2);


        JPanel panelButton=new JPanel();
        panelButton.setBorder(new LineBorder(Color.BLUE,1));
        panelButton.setBounds(620,5,150,220);
        panelButton.setLayout(new GridLayout(5,1,10,10));

        ADD=new JButton("ADD");
        ADD.setBackground(Color.WHITE);
        UPDATE=new JButton("UPDATE");
        UPDATE.setBackground(Color.WHITE);
        UPDATE.setEnabled(false);
        DELETE=new JButton("DELETE");
        DELETE.setEnabled(false);
        DELETE.setBackground(Color.WHITE);
        JButton RESET=new JButton("RESET");
        RESET.setBackground(Color.WHITE);
        panelButton.add(ADD);
        panelButton.add(UPDATE);
        panelButton.add(DELETE);
        panelButton.add(RESET);

        JButton ex=new JButton("Export table");
        ex.setBackground(Color.GREEN);
        panelButton.add(ex);
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
                    Diem d=new Diem();
                    d.setMaSV(Integer.parseInt(MaSV.getItemAt(MaSV.getSelectedIndex()).toString()));
                    d.setMaMH(Integer.parseInt(Mamh.getItemAt(Mamh.getSelectedIndex()).toString()));
                    d.setLanThi(Integer.parseInt(LanThi.getItemAt(LanThi.getSelectedIndex()).toString()));
                    d.setHeso(Integer.parseInt(HeSo.getItemAt(HeSo.getSelectedIndex()).toString()));
                    d.setDiem(Float.parseFloat(txtDiem.getText()));
                    d.setTrangThai(trangthai.isSelected()?1:0);
                    DiemBLL diemBLL= new DiemBLL();
                    int result=diemBLL.Insert(d);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllDiem();
                        resetForm();
                    }
                }
            }
        });
        UPDATE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkdata()){
                    Diem d=new Diem();
                    d.setMaSV(Integer.parseInt(MaSV.getItemAt(MaSV.getSelectedIndex()).toString()));
                    d.setMaMH(Integer.parseInt(Mamh.getItemAt(Mamh.getSelectedIndex()).toString()));
                    d.setLanThi(Integer.parseInt(LanThi.getItemAt(LanThi.getSelectedIndex()).toString()));
                    d.setHeso(Integer.parseInt(HeSo.getItemAt(HeSo.getSelectedIndex()).toString()));
                    d.setDiem(Float.parseFloat(txtDiem.getText()));
                    d.setTrangThai(trangthai.isSelected()?1:0);
                    DiemBLL diemBLL= new DiemBLL();
                    int result =diemBLL.Update(d);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Cập nhật thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllDiem();
                        resetForm();
                    }
                }
            }
        });
        DELETE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Diem cat=new Diem();
                cat.setMaSV(Integer.parseInt(MaSV.getItemAt(MaSV.getSelectedIndex()).toString()));
                DiemBLL diemBLL= new DiemBLL();
                int choice=JOptionPane.showConfirmDialog(frame,"Bạn chắc chắn muốn xóa chứ!!");
                if(choice==JOptionPane.YES_OPTION){
                    int result =diemBLL.Delete(cat);
                    if(result!=0){
                        JOptionPane.showMessageDialog(frame,"Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        getAllDiem();
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
                    UPDATE.setEnabled(true);
                    DELETE.setEnabled(true);
                    MaSV.setSelectedItem(data.getValueAt(row,0).toString());
                    MaSV.setEnabled(false);
                    Mamh.setSelectedItem(data.getValueAt(row,1).toString());
                    Mamh.setEnabled(false);
                    LanThi.setSelectedItem(data.getValueAt(row,2).toString());
                    LanThi.setEnabled(false);
                    HeSo.setSelectedItem(data.getValueAt(row,3).toString());
                    txtDiem.setText(data.getValueAt(row,4).toString());
                    trangthai.setSelected((data.getValueAt(row,5).toString()=="true")?true:false);
                }
            }
        });
        RESET.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });
        ex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EpDiem ep=new EpDiem();
                String input = JOptionPane.showInputDialog("Nhập Mã Lớp muốn xuất điểm!");
                final ArrayList<Diem> diems = new DiemBLL().exportMark(input);
                if (diems.size()<1){
                    JOptionPane.showMessageDialog(frame,"Mã lớp không tồn tại","THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                final String excelFilePath = "FileExport/Marks_"+input+".xlsx";
                try {
                    ep.writeExcel(diems, excelFilePath);
                    JOptionPane.showMessageDialog(frame,"File đã xuất nằm trong thư mục FileExport","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        sort.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(sort.getSelectedIndex()==1){
                    thapdencao();
                }
                if(sort.getSelectedIndex()==2){
                    caodenthap();
                }
            }
        });
        return panelMain;
    }
    public void getAllDiem(){
        String[] header={"Mã SV","Tên Sinh Viên","Mã Môn Học","Lần Thi","Hệ Số","Điểm","Đậu/Rớt"};
        DefaultTableModel dtm=new DefaultTableModel(header,0);
        DiemBLL diemBll =new DiemBLL();
        ArrayList<Diem> arr=diemBll.getAll();
        Diem d=new Diem();
        for(int i=0;i<arr.size();i++){
            d=arr.get(i);
            int MaSV=d.getMaSV();
            String TenSv=d.getTenSV();
            int MaMH=d.getMaMH();
            int LanThi=d.getLanThi();
            int HeSo=d.getHeso();
            float Diem=d.getDiem();
            boolean trangthai=d.isTrangThai();
            String daurot=d.getDiem()>=4?"Đậu":"Rớt";
            Object[] row={MaSV,TenSv,MaMH,LanThi,HeSo,Diem,daurot};
            dtm.addRow(row);

        }
        data.setModel(dtm);
    }
    public void thapdencao(){
        String[] header={"Mã SV","Tên Sinh Viên","Mã Môn Học","Lần Thi","Hệ Số","Điểm","Trạng Thái"};
        DefaultTableModel dtm=new DefaultTableModel(header,0);
        DiemBLL diemBll =new DiemBLL();
        ArrayList<Diem> arr=diemBll.Thapdencao();
        Diem d=new Diem();
        for(int i=0;i<arr.size();i++){
            d=arr.get(i);
            int MaSV=d.getMaSV();
            String TenSv=d.getTenSV();
            int MaMH=d.getMaMH();
            int LanThi=d.getLanThi();
            int HeSo=d.getHeso();
            float Diem=d.getDiem();
            boolean trangthai=d.isTrangThai();
            Object[] row={MaSV,TenSv,MaMH,LanThi,HeSo,Diem,trangthai};
            dtm.addRow(row);
        }
        data.setModel(dtm);
    }
    public void caodenthap(){
        String[] header={"Mã SV","Tên Sinh Viên","Mã Môn Học","Lần Thi","Hệ Số","Điểm","Trạng Thái"};
        DefaultTableModel dtm=new DefaultTableModel(header,0);
        DiemBLL diemBll =new DiemBLL();
        ArrayList<Diem> arr=diemBll.Caodenthap();
        Diem d=new Diem();
        for(int i=0;i<arr.size();i++){
            d=arr.get(i);
            int MaSV=d.getMaSV();
            String tensv=d.getTenSV();
            int MaMH=d.getMaMH();
            int LanThi=d.getLanThi();
            int HeSo=d.getHeso();
            float Diem=d.getDiem();
            boolean trangthai=d.isTrangThai();
            Object[] row={MaSV,tensv,MaMH,LanThi,HeSo,Diem,trangthai};
            dtm.addRow(row);
        }
        data.setModel(dtm);
    }
    private void resetForm(){
        MaLop.setSelectedIndex(0);
//        MaSV.setSelectedIndex(0);
        MaSV.setEnabled(true);
        Mamh.setSelectedIndex(0);
        Mamh.setEnabled(true);
        HeSo.setSelectedIndex(0);
        HeSo.setEnabled(true);
        LanThi.setSelectedIndex(0);
        LanThi.setEnabled(true);
        txtDiem.setText("");
        trangthai.setSelected(false);
        ADD.setEnabled(true);
        UPDATE.setEnabled(false);
        DELETE.setEnabled(false);
    }
    public boolean checkdata(){
        check c=new check();
        if(!c.isRequired(txtDiem.getText())
        ){
            JOptionPane.showMessageDialog(frame,"Vui lòng nhập điểm.","Lỗi",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!c.checkMark(txtDiem.getText())){
            JOptionPane.showMessageDialog(frame,"Điểm không hợp lệ","Lỗi",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}

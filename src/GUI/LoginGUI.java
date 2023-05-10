package GUI;

import BLL.LoginBLL;
import DTO.Loger;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginGUI implements KeyListener {
    private JFrame frame;
    private JButton btnLogin,btnExit;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    public LoginGUI(){
        initialize();
    }
    private void initialize(){
        frame= new JFrame("Login");

        frame.setSize(400,400);
        frame.setDefaultCloseOperation(3);
        frame.getContentPane().setLayout(new BorderLayout());
        headerLabel = new JLabel("", JLabel.CENTER);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        frame.add(headerLabel,BorderLayout.NORTH);
        headerLabel.setText("LOGIN");
        headerLabel.setFont(new Font("Tohoma",Font.PLAIN,50));
        headerLabel.setOpaque(true);
        headerLabel.setBackground(Color.decode("#f89820"));
        headerLabel.setForeground(Color.BLUE);

//        JLabel label = new JLabel("", JLabel.CENTER);
//        label.setText("Please enter username and password.");
//        label.setFont(new Font("Tohoma",Font.PLAIN,20));
//        label.setForeground(Color.BLUE);
//        frame.add(label);



        //
        JPanel pnlInfoUser = new JPanel();
        pnlInfoUser.setBorder(new EmptyBorder(20,20,20,20));

        JLabel lblUsername = new JLabel("Username: ");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblUsername.setPreferredSize(new Dimension(150,50));
        lblUsername.setForeground(Color.BLUE);


        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblUserpass = new JLabel("Password: ");
        lblUserpass.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblUserpass.setForeground(Color.BLUE);


        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JPanel btn=new JPanel();
        btn.setLayout(new FlowLayout());
        btnLogin=new JButton("Login");
        btnLogin.setForeground(Color.BLUE);
        btnLogin.setBackground(Color.WHITE);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginBLL lg=new LoginBLL();
                if (lg.CheckLogin(txtUsername.getText(), txtPassword.getPassword())) {
                    if(lg.getUser(txtUsername.getText(), txtPassword.getPassword())!=null){
                        Loger a= lg.getUser(txtUsername.getText(), txtPassword.getPassword());
                        new MainPage(a);
                        frame.dispose();
                    }

                }else {
                    JOptionPane.showMessageDialog(frame, "Tên đăng nhập hoặc mật khẩu không đúng!",
                            "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnExit=new JButton("Exit");
        btnExit.setForeground(Color.RED);
        btnExit.setBackground(Color.WHITE);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        ImageIcon icon =new ImageIcon("images/check.png");
        Image img = icon.getImage() ;
        Image newimg = img.getScaledInstance( 20, 20,  Image.SCALE_REPLICATE ) ;
        icon = new ImageIcon( newimg );


        ImageIcon icon_exit =new ImageIcon("images/exit.png");
        Image exit = icon_exit.getImage() ;
        Image imgnew = exit.getScaledInstance( 20, 20,  Image.SCALE_REPLICATE ) ;
        icon_exit = new ImageIcon( imgnew );

        btnLogin.setIcon(icon);
        btnExit.setIcon(icon_exit);
        btn.add(btnLogin);
        btn.add(btnExit);

        JPanel pnlb=new JPanel();

        pnlb.setLayout(null);

        lblUsername.setBounds(20,20,100,50);
        txtUsername.setBounds(170,20,150,50);
        txtUsername.setBorder(new LineBorder(Color.black));
        pnlb.add(lblUsername);
        pnlb.add(txtUsername);

        JPanel pntxt=new JPanel();
        pntxt.setLayout(null);

        lblUserpass.setBounds(20,00,100,50);
        txtPassword.setBounds(170,0,150,50);
        txtPassword.setBorder(new LineBorder(Color.black));
        pntxt.add(lblUserpass);
        pntxt.add(txtPassword);

        txtUsername.addKeyListener(this);
        txtPassword.addKeyListener(this);
        pnlInfoUser.setLayout(new GridLayout(2,1,50,20));
        pnlInfoUser.add(pnlb);
        pnlInfoUser.add(pntxt);
        btn.setBorder(new EmptyBorder(20,20,20,20));
        frame.add(pnlInfoUser,BorderLayout.CENTER);
        frame.add(btn,BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            LoginBLL lg=new LoginBLL();
            if (lg.CheckLogin(txtUsername.getText(), txtPassword.getPassword())) {
                if(lg.getUser(txtUsername.getText(), txtPassword.getPassword())!=null){
                    Loger a= lg.getUser(txtUsername.getText(), txtPassword.getPassword());
                    new MainPage(a);
                    frame.dispose();
                }

            }else {
                JOptionPane.showMessageDialog(frame, "Tên đăng nhập hoặc mật khẩu không đúng!",
                        "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

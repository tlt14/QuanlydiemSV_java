package BLL;

import DAL.Login;
import DTO.Loger;
import DTO.Student;
//import DTO.User;

public class LoginBLL {
    private Login lg=new Login();
    public boolean CheckLogin(String a,char [] b){
        return lg.checkData(a,b);
    }
    public Loger getUser(String a,char [] b){
        return lg.getUserlogin(a,b);
    }
}

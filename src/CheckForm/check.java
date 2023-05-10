package CheckForm;

import javax.swing.*;
import java.util.regex.Pattern;

public class check {
    public boolean isRequired(String s){
        if(s.equals("")){
            return false;
        }else{
            return true;
        }
    }
    public boolean checkDate(String s){
        Pattern pattern = Pattern.compile("^\\d{2}[-|/]\\d{2}[-|/]\\d{4}$");
        return pattern.matcher(s).matches();
    }
    public boolean checkPhone(String s){
        Pattern pattern = Pattern.compile("^0[983]{1}\\d{8}$");
        return pattern.matcher(s).matches();
    }
    public boolean checkEmail(String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    public boolean checkMark(String s){
        float t= -1;
        try {
            t=Float.parseFloat(s);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Điểm không hợp lệ","Lỗi ",JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
        if(t<=10 && t>=0){
            return true;
        }else {
            return false;
        }
    }
}

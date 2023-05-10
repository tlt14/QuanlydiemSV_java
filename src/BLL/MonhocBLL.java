package BLL;

import DAL.MonHocDAL;
import DTO.Monhoc;

import java.util.ArrayList;

public class MonhocBLL {
    MonHocDAL mhDAL=new MonHocDAL();
    public ArrayList<Monhoc> getAllMH(){
        return mhDAL.getAll();
    }
    public ArrayList<Monhoc> getWithMamh(String a){
        return mhDAL.getWithMaSV(a);
    }

    public int Insert(Monhoc mh){
        return mhDAL.InsertMH(mh);
    }
    public int Update(Monhoc mh){
        int result = mhDAL.UpdateMH(mh);
        return result;
    }
    public int Delete(Monhoc mh){
        int result = mhDAL.Delete(mh);
        return result;
    }
}

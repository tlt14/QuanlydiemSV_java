package BLL;

import DAL.StudentDAL;
import DTO.Student;

import java.util.ArrayList;

public class StudentBLL {
    StudentDAL studentDAL =new StudentDAL();
    public ArrayList<Student>getAll(){
        return studentDAL.getAllStudent();
    }
    public ArrayList<Student>getWithMalop(String a){
        return studentDAL.getWithMaLop(a);
    }
    public ArrayList<Student>getWithMasv(String a){
        return studentDAL.getWithMaSV(a);
    }

    public int Insert(Student us){
        int result = studentDAL.insertStudent(us);
        return result;
    }
    public int Update(Student us){
        int result = studentDAL.updateSt(us);
        return result;
    }
    public int Delete(Student us){
        int result = studentDAL.deleteSt(us);
        return result;
    }
}

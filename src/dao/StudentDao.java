package dao;

import java.util.List;

public interface StudentDao {
	 void insert(Student user) throws Exception;

     void delete(int Student_ID) throws Exception;

     void update(Student student) throws Exception;

     Student querryByString(int Student_ID) throws Exception;

     List<Student> querryALL(int init,int pres) throws Exception;
}

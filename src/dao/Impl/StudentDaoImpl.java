package dao.Impl;

import dao.JDBCconnector;
import dao.Student;
import dao.StudentDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class StudentDaoImpl implements StudentDao {


	public void insert(Student user) throws Exception {
		JDBCconnector con = null;
        PreparedStatement pstm = null;
      
        String sql = "insert into Student(Student_ID,Student_Name,Student_Sex,Student_Age,Student_Telephone,Student_Class,Student_Birthday,Student_Nativeplace,Student_Nation,Student_Major) values(?,?,?,?,?,?,?,?,?,?)";
        try{
            con=new JDBCconnector();	           
            pstm = con.getConnection().prepareStatement(sql);
            pstm.setInt(1, user.getStudent_ID());
            pstm.setString(2, user.getStudent_Name());
            pstm.setString(3, user.getStudent_Sex());
            pstm.setInt(4, user.getStudent_Age());
            pstm.setLong(5, user.getStudent_Telephone());
            pstm.setString(6, user.getStudent_Class());
            pstm.setString(7, user.getStudent_Birthday());
            pstm.setString(8, user.getStudent_Nativeplace());
            pstm.setString(9, user.getStudent_Nation());
            pstm.setString(10, user.getStudent_Major());
            
            pstm.executeUpdate();
            if (pstm != null)
            {
                pstm.close();
            }
        }
        catch (Exception e)
        {
            System.out.println("添加数据失败");
        }
        finally
        {
            if (con != null)
            {
                con.close();
            }
        }
	}

	public void delete(int Student_ID) throws Exception {
        JDBCconnector con = null;
        PreparedStatement pstm = null;
        String sql = "delete from student where Student_ID=?";
        try
        {
            con = new JDBCconnector();
            pstm = con.getConnection().prepareStatement(sql);
            pstm.setInt(1, Student_ID);
            pstm.executeUpdate();
            if (pstm != null)
            {
                pstm.close();
            }
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("删除数据操作异常");
        } finally
        {
            if (con != null)
            {
                con.close();
            }
        }
		
	}

	public void update(Student student) throws Exception {
        JDBCconnector con = null;
        PreparedStatement pstm = null;
        String sql = "update student set Student_Name=?,Student_Sex=?,Student_Age=?,Student_Telephone=?,Student_Class=?,Student_Birthday=?,Student_Nativeplace=?,Student_Nation=?,Student_Major=? where Student_ID=?";

        try
        {
            con = new JDBCconnector();
            pstm = con.getConnection().prepareStatement(sql);
            pstm.setString(1,student.getStudent_Name());
            pstm.setString(2,student.getStudent_Sex());
            pstm.setInt(3,student.getStudent_Age());
            pstm.setLong(4,student.getStudent_Telephone());
            pstm.setString(5,student.getStudent_Class());
            pstm.setString(6,student.getStudent_Birthday());
            pstm.setString(7,student.getStudent_Nativeplace());
            pstm.setString(8,student.getStudent_Nation());
            pstm.setString(9,student.getStudent_Major());
            pstm.setInt(10,student.getStudent_ID());
            pstm.executeUpdate();
            if (pstm != null)
            {
                pstm.close();
            }
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("更新数据操作异常,sql:"+sql);
        } finally
        {
            if (con != null)
            {
                con.close();
            }
        }
		
	}
	@Override
	public Student querryByString(int Student_ID) throws Exception {
		JDBCconnector con = null;
        PreparedStatement pstm = null;
        ResultSet rs=null;
        Student student=null;

        String sql = "select * from Student where Student_ID=?";
        try
        {
            con = new JDBCconnector();
            pstm = con.getConnection().prepareStatement(sql);
            
            pstm.setInt(1, Student_ID);
            rs = pstm.executeQuery();
            rs.next();
            student = new Student();
           
            student.setStudent_ID(rs.getInt(1));
            student.setStudent_Name(rs.getString(2));
            student.setStudent_Sex(rs.getString(3));
            student.setStudent_Age(rs.getInt(4));
            student.setStudent_Telephone(rs.getLong(5));
            student.setStudent_Class(rs.getString(6));
            student.setStudent_Birthday(rs.getString(7));
            student.setStudent_Nativeplace(rs.getString(8));
            student.setStudent_Nation(rs.getString(9));
            student.setStudent_Major(rs.getString(10));
            if (pstm != null)
            {
                pstm.close();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            // TODO Auto-generated catch block
            System.out.println("查询数据失败   sql:"+sql);
            return  null;
        } finally
        {
            if (con != null)
            {
                con.close();
            }
        }
        return student;
	}

	public List<Student> querryALL(int init,int pres ) throws Exception {
		JDBCconnector con = null;
        PreparedStatement pstm = null;
        ResultSet rs=null;
        Student student=null;
        List<Student> lsu=new ArrayList<Student>();
        String sql = "select * from student limit ?,?";

        try
        {
            con = new JDBCconnector();

            pstm = con.getConnection().prepareStatement(sql);
            pstm.setInt(1,init);
            pstm.setInt(2,pres);
            rs = pstm.executeQuery();

            while(rs.next())
            {
            	student = new Student();

            	student.setStudent_ID(rs.getInt(1));
                student.setStudent_Name(rs.getString(2));
                student.setStudent_Sex(rs.getString(3));
                student.setStudent_Age(rs.getInt(4));
                student.setStudent_Telephone(rs.getLong(5));
                student.setStudent_Class(rs.getString(6));
                student.setStudent_Birthday(rs.getString(7));
                student.setStudent_Nativeplace(rs.getString(8));
                student.setStudent_Nation(rs.getString(9));
                student.setStudent_Major(rs.getString(10));
                
                lsu.add(student);
            }
            if (pstm != null)
            {
                pstm.close();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            // TODO Auto-generated catch block
            System.out.println("查询所有Student信息失败");
        } finally
        {
            if (con != null)
            {
                con.close();
            }
        }
        return lsu;
	}


}

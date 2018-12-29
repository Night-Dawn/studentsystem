package dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.JDBCconnector;
import dao.User;
import dao.UserDao;


public class UserDaoImpl implements UserDao {

	public void insert(User user) throws Exception {
		 	JDBCconnector con = null;
	        PreparedStatement pstm = null;
	        String sql = "insert into User(username,password) values(?,?)";
	        try{
	            con=new JDBCconnector();	           
	            pstm = con.getConnection().prepareStatement(sql);
	            pstm.setString(1, user.getUsername());
	            pstm.setString(2, user.getPassword());
	            pstm.executeUpdate();
	            if (pstm != null)
	            {
	                pstm.close();
	            }
	        }
	        catch (Exception e)
	        {
	            System.out.println("添加user信息失败");
	        }
	        finally
	        {
	            if (con != null)
	            {
	                con.close();
	            }
	        }
		
	}

	public void delete(String username) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public User querryByString(String username) throws Exception {
		
		JDBCconnector con = null;
        PreparedStatement pstm = null;
        ResultSet rs=null;
        User user=null;

        String sql = "select * from User where username=?";
        try
        {
            con = new JDBCconnector();
            pstm = con.getConnection().prepareStatement(sql);
            
            pstm.setString(1,username);
            rs = pstm.executeQuery();
            rs.next();
            user = new User();

            user.setUsername(rs.getString(1));
            user.setPassword(rs.getString(2));


            if (pstm != null)
            {
                pstm.close();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            // TODO Auto-generated catch block
            System.out.println("查询user信息失败   sql:"+sql);
            return  null;
        } finally
        {
            if (con != null)
            {
                con.close();
            }
        }
        return user;
	}

	public List<User> querryALL() throws Exception {
		JDBCconnector con = null;
        PreparedStatement pstm = null;
        ResultSet rs=null;
        List<User> lsu=new ArrayList<User>();
        String sql = "select * from User";
        try
        {

            con = new JDBCconnector();

            pstm = con.getConnection().prepareStatement(sql);

            rs = pstm.executeQuery();

            while(rs.next())
            {
                User user = new User();

                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
                
                lsu.add(user);
            }
            if (pstm != null)
            {
                pstm.close();
            }
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("查询user数据失败");
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

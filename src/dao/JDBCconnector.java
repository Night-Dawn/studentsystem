package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCconnector {
	private Connection conn =null;
    private String DRIVERNAME="com.mysql.jdbc.Driver";
    private String DBURL = "jdbc:mysql://localhost:3306/studentsystem?useUnicode=true&characterEncoding=UTF-8";
    private String username ="root";
    private String password = "root";
    public JDBCconnector()
    {
        try {
            Class.forName(DRIVERNAME);
            this.conn= DriverManager.getConnection(DBURL,username,password);

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("加载驱动失败");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("加载驱动失败");
        }
    }
    public Connection getConnection()
    {
        return this.conn;
    }
    public void close()
    {
        if(this.conn!=null)
        {
            try
            {
                this.conn.close();
            } catch (SQLException e)
            {
                // TODO Auto-generated catch block
                System.out.println("数据库连接关闭失败");
            }
        }
    }
}

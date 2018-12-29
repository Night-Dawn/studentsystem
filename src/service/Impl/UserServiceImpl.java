package service.Impl;

import dao.Impl.UserDaoImpl;
import dao.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    UserDaoImpl ud = new UserDaoImpl();
    User user =null;
    @Override
    public boolean userLogin(String username, String password) throws Exception {
        try{
            user=ud.querryByString(username);
            if(user!=null && user.getPassword().equals(password))
            {
                return  true;
            }
            return  false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception("登录失败");
        }
    }

    @Override
    //注册功能
    public boolean userRegister(String username, String password, String confirm) throws Exception {
        try
        {
            user =new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setConfirm(confirm);
            User u = new User();
            u=ud.querryByString(username);
            if(user.getPassword().equals(user.getConfirm())&&u==null)
            {
                ud.insert(user);
                return true;
            }
            return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception("注册失败");
        }

    }
}

package service;

public interface UserService {

    boolean userLogin(String username, String password) throws Exception;

    boolean userRegister(String username,String password,String confirm) throws Exception;
}

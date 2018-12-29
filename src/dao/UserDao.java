package dao;

import java.util.List;

public interface UserDao {
	  void insert(User user) throws Exception;

	     void delete(String username) throws Exception;

	     void update(User user) throws Exception;

	     User querryByString(String username) throws Exception;

	     List<User> querryALL() throws Exception;
}

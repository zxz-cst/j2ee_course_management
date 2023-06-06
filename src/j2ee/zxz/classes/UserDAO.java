package j2ee.zxz.classes;


import java.sql.SQLException;
import java.util.*;
import java.sql.*;

import j2ee.zxz.utils.*;
public class UserDAO {
	   List<User> users;
	   public UserDAO()
	   {
		   users = new ArrayList<User>();
	   }
	   public boolean deleteBookByName(User user) {
			Map<String, Object> whereMap = new HashMap<>();
		    whereMap.put("uName", user.getUserName());
		    try {
	            int count = DBUtil.delete("user", whereMap);
	            
	            if(count > 0){
	            	return true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return false;
		}
	   
	   public User getUser(String uId) {
		   User user = null;
		   Map<String, Object> map = null;
		   Map<String, Object> whereMap = new HashMap<>();
		   whereMap.put("uId", uId);
		   try {
			   List<Map<String, Object>> list = DBUtil.query("user",whereMap);
			   int size = list.size();
			   System.out.print(size);
			   if(size == 1){
				   map = list.get(0);
				   user = new User(((String)map.get("uId")),
						   (String)map.get("uName")
						   );
			   }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e){
	            e.printStackTrace();
	        }
	       return user;
	   }
}

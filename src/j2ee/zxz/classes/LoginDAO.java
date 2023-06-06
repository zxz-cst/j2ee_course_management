package j2ee.zxz.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LoginDAO {
    public LoginDAO()
    {
    	;
    }
    
  
    
    public boolean isHave(Login login){
		Connection conn = null;
		String userName = login.getUserName();
		String password = login.getPassword();
		try{
	String jndi = "java:comp/env/jdbc/lib";
	Context ctx = (Context) new InitialContext();
	DataSource ds = (DataSource) ctx.lookup(jndi);
	conn = ds.getConnection();
    Statement stm = conn.createStatement();
    ResultSet rs = stm.executeQuery("select * "+"from user");
    while(rs.next())
    {
    	if(rs.getString(1).equals(userName)&&rs.getString(3).equals(password))
    	{
    		stm.close();
    		return true;
    	}
    }
    conn.close();
    return false;
	}
	catch(SQLException 	e){
		System.err.println("SQLException:"+e.getMessage());
	}
	catch(NamingException e)
	{
		System.err.println("NamingException:"+e.getMessage());
	}
	return false;
    }
}

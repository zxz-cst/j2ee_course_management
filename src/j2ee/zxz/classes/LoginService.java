package j2ee.zxz.classes;

import java.util.List;

public class LoginService {
    public LoginService()
    {
      ;
    }
	public String deal(Login login)
	{
		String userName = login.getUserName();
		String password = login.getPassword();
		String yanzhengma = login.getYanzhengma();
		LoginDAO DAO = new LoginDAO();
		String s = "8774";
		if(userName == "")
		{
			return "用户名不能为空";
		}
		
		else if(password == "")
			return "密码不能为空";
		else if(!yanzhengma.equals("8774"))
		    return "验证码输入错误";
		else if(!DAO.isHave(login))
		{
			return "用户名或密码错误";
		}
		else
			return "成功";
	}
	public void delUser(User user)
	{
		UserDAO Dao = new UserDAO();
		Dao.deleteBookByName(user);
    }

	public User getUser(String uId)
	{
		UserDAO Dao = new UserDAO();
		return Dao.getUser(uId);
	}
	
	public List<HitCourse> getAllHitCourse(String uId) 
	{
		HitCourseDAO Dao = new HitCourseDAO();
		return Dao.getAllHitCourse(uId);
	}
	
}

package j2ee.zxz.classes;

public class Login {
	private String userName;
	private String password;
	private String yanzhengma;
	public Login()
	{
		;
	}
	public Login(String userName,String password,String yanzhengma)
	{
		this.userName = userName;
		this.password = password;
		this.yanzhengma = yanzhengma;
	}
    public void setUserName(String userName)
    {
    	this.userName = userName;
    }
    public void setPassword(String password)
    {
    	this.password = password;
    }
    public void setYanzhengma(String yanzhengma)
    {
    	this.yanzhengma = yanzhengma;
    }
    public String getUserName()
    {
    	return userName;
    }
    public String getPassword()
    {
    	return password;
    }
    public String getYanzhengma()
    {
    	return yanzhengma;
    }
    
}

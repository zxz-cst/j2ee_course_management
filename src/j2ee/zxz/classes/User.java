package j2ee.zxz.classes;

public class User {
      private String uId;
      private String uName;
      private String uPw;
      private String uSchool;
      private String uDepartment;
      public User()
      {
    	  ;
      }
      public User(String uId,String uName)
      {
    	  this.uId = uId;
    	  this.uName= uName;
      }
      public void setUserId(String userId)
      {
      	this.uId = userId;
      } 
      public String getUserId()
      {
      	return uId;
      }
      public void setUserName(String uName)
      {
      	this.uName = uName;
      } 
      public String getUserName()
      {
      	return uName;
      }
      public void setUserPw(String uPw)
      {
      	this.uPw = uPw;
      } 
      public String getUserPw()
      {
      	return uPw;
      }
      public void setUserSchool(String uSchool)
      {
      	this.uSchool = uSchool;
      } 
      public String getUserSchool()
      {
      	return uSchool;
      }
      public void setUserDp(String uDepartment)
      {
      	this.uDepartment = uDepartment;
      } 
      public String getUserDp()
      {
      	return uDepartment;
      }
}

package j2ee.zxz.classes;

public class HitCourse {
        private String uId;
        private String uName;
        private String cId; 
        private String cName;
        private int score;
        private int cNum;
        
        public HitCourse(String uId,String cId,String cName,int score,int cNum)
        {
      	  this.uId = uId;
      	 this.cId = cId;
         this.cName = cName;
     	 this.score = score;
     	 this.cNum = cNum;
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
        public void setCourseId(String cId)
        {
        	this.cId = cId;
        } 
        public String getCourseId()
        {
        	return cId;
        }
        public void setCourseName(String cName)
        {
        	this.cName = cName;
        } 
        public String getCourseName()
        {
        	return cName;
        }
        public void setScore(int score)
        {
        	this.score = score;
        } 
        public int getScore()
        {
        	return score;
        }
        public void setcNum(int cNum)
        {
        	this.cNum = cNum;
        } 
        public int getcNum()
        {
        	return cNum;
        }
}

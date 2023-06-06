package j2ee.zxz.classes;

public class Course {

	private int courseId;
	private String courseName;
	private int courseNum;
	private String courseType;
	public Course()
	{
		;
	}
	public Course(int courseId,String courseName,int courseNum,String courseType)
	{
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseNum = courseNum;
		this.courseType = courseType;
	}
	public void setCourseId(int courseId)
    {
    	this.courseId = courseId;
    } 
    public int getCourseId()
    {
    	return courseId;
    }
    public void setCourseName(String courseName)
    {
    	this.courseName = courseName;
    } 
    public String getCourseName()
    {
    	return courseName;
    }
    public void setCourseNum(int courseNum)
    {
    	this.courseNum = courseNum;
    } 
    public int getCourseNum()
    {
    	return courseNum;
    }
    public void setCourseType(String courseType)
    {
    	this.courseType = courseType;
    } 
    public String getCourseType()
    {
    	return courseType;
    }
   
}

package j2ee.zxz.classes;
import java.util.*;
public class CourseService {
	public CourseService()
    {
      ;
    }
	public boolean insert(Course course)
	{
		CourseDAO DAO = new CourseDAO();
	    if(DAO.insertcourse(course))
	    	return true;
	    else
	    	return false;
	}

	
	public int delete(String[] a)
	{
		CourseDAO DAO = new CourseDAO();
	    return DAO.delcourse(a);
	    
	}
	public boolean select(Course course)
	{
		CourseDAO DAO = new CourseDAO();
	    if(DAO.selectcourse(course))
	    	return true;
	    else
	    	return false;
	}

	public boolean addHitCourse(List<HitCourse> hitcourses)
	{
		CourseDAO DAO = new CourseDAO();
		return DAO.addHitCourse(hitcourses);
		
	}
	
	public boolean delHitCourse(String[] cId)
	{
		CourseDAO DAO = new CourseDAO();
		return DAO.deleteHitCourse(cId);
	}
	
	public int getCountofCourses() 
	{
		CourseDAO DAO = new CourseDAO();
		return DAO.getCountofCourses();
	}
	
	public List<Course> getAllCourses(int curPage, int pageSize)
	{
		CourseDAO DAO = new CourseDAO();
		return DAO.getAllCourses(curPage, pageSize);
	}
	/*public boolean deselect(String[] a)
	{
		CourseDAO DAO = new CourseDAO();
	    if(DAO.deselectcourse(a))
	    	return true;
	    else
	    	return false;
	}*/
}

package j2ee.zxz.classes;

import java.sql.*;
import java.util.*;

import j2ee.zxz.utils.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;







import java.sql.SQLException;


public class CourseDAO {
	private  List<Course> courses;
     public CourseDAO()
     {
     courses = new ArrayList<Course>();
     }
	 public Course[]  findcourse()
	 {
		 Connection conn = null;
		
			try{ 
		String jndi = "java:comp/env/jdbc/lib";
		Context ctx = (Context) new InitialContext();
		DataSource ds = (DataSource) ctx.lookup(jndi);
		conn = ds.getConnection();
	    Statement stm = conn.createStatement();
	    ResultSet rs = stm.executeQuery("select * " + "from course");
	    Course[] cs = new Course[10000];
	    int i = 0;
	    while(rs.next())
	    {
	    	Course c = new Course(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
	    	cs[i++] = c;
	    }
	    conn.close();
	    return cs;
		}
		catch(SQLException 	e){
			System.err.println("SQLException:"+e.getMessage());
		}
		catch(NamingException e)
		{
			System.err.println("NamingException:"+e.getMessage());
		}
		return null;
		
	 }
     
	 public boolean insertcourse(Course course){
		   
			Connection conn = null;
			try{ 
			String courseName = course.getCourseName();
			int courseNum = course.getCourseNum();
			String courseType = course.getCourseType();
			if(courseName.equals("")||courseNum==-1)
				return false;
		String jndi = "java:comp/env/jdbc/lib";
		Context ctx = (Context) new InitialContext();
		DataSource ds = (DataSource) ctx.lookup(jndi);
		conn = ds.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * " + "from course");
		rs.last();
		//String id = Integer.toString((Integer.parseInt(rs.getString(1))+1));
	    PreparedStatement pstm  = conn.prepareStatement("insert into course(cId,cName,cNum,cType) values(?,?,?,?)");
	    pstm.setInt(1, rs.getInt(1)+1);
	    pstm.setString(2, courseName);
	    pstm.setInt(3, courseNum);
	    pstm.setString(4, courseType);
	    pstm.execute();
	    conn.close();
		}
		catch(SQLException 	e){
			System.err.println("SQLException:"+e.getMessage());
			return  false;
		}
		catch(NamingException e)
		{
			System.err.println("NamingException:"+e.getMessage());
			return false;
		}
		return true;
	    }
	 
	 public int delcourse(String[] a)
	 {
		 Connection conn = null;
			try{ 
		String jndi = "java:comp/env/jdbc/lib";
		Context ctx = (Context) new InitialContext();
		DataSource ds = (DataSource) ctx.lookup(jndi);
		conn = ds.getConnection();
		if(a == null)
			return 1;
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		for(int i = 0;i<a.length;i++)
		{
			if(a[i]== null)
				break;
			int x = Integer.parseInt(a[i]);
			ResultSet rs  = st.executeQuery("select cId from hitcourse where cId = "+x);
			//System.out.print(rs.getInt(1));
			
			if(rs.next())
			{
				return 2;
			}
			st.executeUpdate("delete from course where cId = "+x);
		}
		/*ResultSet rs = st.executeQuery("select * " + "from course");
		int i = 1;
		while(rs.next())
		{
			rs.updateInt(1, i++);
			rs.updateRow();
		}*/
		conn.close();
		}
		catch(SQLException 	e){
			System.err.println("SQLException:"+e.getMessage());
			return  1;
		}
		catch(NamingException e)
		{
			System.err.println("NamingException:"+e.getMessage());
			return 1;
		}
	    
		return 0;
	 }
	 
	 public boolean selectcourse(Course course){
		   return false;
		
		 
	    }
		public boolean addHitCourse(List<HitCourse> hitcourses) {
		    List<Map<String, Object>> datas = new ArrayList<>();
		    Map<String, Object> whereMap = new HashMap<>();
			   Map<String, Object> valueMap = new HashMap<>();
		  
			     try {
			    	  if(hitcourses != null){
						    for (int i = 0; i < hitcourses.size(); i++) {
						        Map<String, Object> map1 = new HashMap<>();
						        Map<String, Object> map2 = new HashMap<>();
						        Map<String, Object> map3 = new HashMap<>();
						        map1.put("cId", hitcourses.get(i).getCourseId());
						        map1.put("uId", hitcourses.get(i).getUserId());
						        map1.put("score", hitcourses.get(i).getScore());
						        datas.add(map1);
			           		    whereMap.put("cId", hitcourses.get(i).getCourseId());
			           		 List<Map<String, Object>> list = DBUtil.query("hitCourse",whereMap);
				  			   int size = list.size();
				  			   if(size >= 1){
				  				  return false;   
				  			   }    
			           	   List<Map<String, Object>> list1 = DBUtil.query("course",whereMap);
			  			   int size1 = list1.size();
			  			   if(size1 == 1){
			  				   map3 = list1.get(0);
			  				   valueMap.put("cNum", (int)map3.get("cNum")+1);
			  			   }
			           		    
			           		    DBUtil.update("course",valueMap, whereMap);
						     }
			    	  }
			    	  else
			    		  return false;
			        long start = System.currentTimeMillis();
			        DBUtil.insertAll("hitCourse", datas);
			        System.out.println("����ʱ" + (System.currentTimeMillis() - start));
			        return true;
			     } catch (SQLException e) {
			        e.printStackTrace();
			     }catch (Exception e){
			            e.printStackTrace();
			        }
		    
		    return false;
		}
	 
		public boolean deleteHitCourse(String[] cId) {
			Map<String, Object> whereMap = new HashMap<>();
			Map<String, Object> map2 = new HashMap<>();
			 Map<String, Object> valueMap = new HashMap<>();
			 
		    try {
		    	for(int i = 0;i<cId.length;i++)
		    	{
		    		whereMap.put("cId", cId[i]);
		    		 List<Map<String, Object>> list = DBUtil.query("course",whereMap);
		  			   int size = list.size();
		  			   if(size == 1){
		  				   map2 = list.get(0);
		  				   valueMap.put("cNum", (int)map2.get("cNum")-1);
		  			   }
		           		    
		           		    DBUtil.update("course",valueMap, whereMap);
		    		DBUtil.delete("hitCourse", whereMap);
		    	}
	           return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
			return false;
		}
	 public boolean deselect(String[] a)
	 {
		 Connection conn = null;
			try{ 
		String jndi = "java:comp/env/jdbc/lib";
		Context ctx = (Context) new InitialContext();
		DataSource ds = (DataSource) ctx.lookup(jndi);
		conn = ds.getConnection();
		if(a == null)
			return false;
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		for(int i = 0;i<a.length;i++)
		{
			if(a[i]== null)
				break;
			int x = Integer.parseInt(a[i]);
			st.executeUpdate("delete from course where cId = "+x);
		}
		ResultSet rs = st.executeQuery("select * " + "from course");
		int i = 1;
		while(rs.next())
		{
			rs.updateInt(1, i++);
			rs.updateRow();
		}
		conn.close();
		}
		catch(SQLException 	e){
			System.err.println("SQLException:"+e.getMessage());
			return  false;
		}
		catch(NamingException e)
		{
			System.err.println("NamingException:"+e.getMessage());
			return false;
		}
	    
		return true;
	 }
	 
	 
	 
	 
	 public int getCountofCourses() {
			try {
			   List<Map<String, Object>> list = DBUtil.query("course",null);
			   return list.size();
		    } catch (SQLException e) {
		       e.printStackTrace();
		    } catch (Exception e){
		       e.printStackTrace();
		    }
			return 0;
		}

		
		public List<Course> getAllCourses(int curPage, int pageSize) {
			Map<String, Object> map = null;
			Course course = null;
			String sql ="select * from course limit "+ (curPage-1)*pageSize+","+pageSize;
			try {
				List<Map<String, Object>> list = DBUtil.query(sql);
				System.out.print(list.size());
				int size = list.size();
				for(int i=0;i<size;i++){
				  map = list.get(i);
				  course = new Course(((Integer)map.get("cId")).intValue(),
						   (String)map.get("cName"),
						   ((Integer)map.get("cNum")).intValue(),
						   (String)map.get("cType"));
			      courses.add(course);
		        }
		     } catch (SQLException e) {
		        e.printStackTrace();
		     } catch (Exception e){
		        e.printStackTrace();
		     }
			 return courses;
		}
}

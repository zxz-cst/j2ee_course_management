package j2ee.zxz.classes;

import j2ee.zxz.utils.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoursePage {
		private  List<Course> courses;
		public CoursePage()
		{
			courses = new ArrayList<Course>();
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

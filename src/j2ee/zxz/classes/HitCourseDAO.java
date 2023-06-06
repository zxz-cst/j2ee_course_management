package j2ee.zxz.classes;


import java.sql.SQLException;
import java.util.*;
import java.sql.*;

import j2ee.zxz.utils.*;

public class HitCourseDAO {
	
	 List<HitCourse> hitCourses;
	   public HitCourseDAO()
	   {
		   hitCourses = new ArrayList<HitCourse>();
	   }
	   
	   public List<HitCourse> getAllHitCourse(String uId) {
			Map<String, Object> map1 = null;
			Map<String, Object> map2 = null;
			HitCourse hitcourse = null;
			String sql1 ="select * from hitCourse where uId = "+uId;
	
			try {
				List<Map<String, Object>> list1 = DBUtil.query(sql1);
				int size1 = list1.size();
				for(int i=0;i<size1;i++){
				  map1 = list1.get(i);
				  String cId = (String)map1.get("cId");
				  String sql2 = "select * from course where cId = "+cId;
				  List<Map<String, Object>> list2 = DBUtil.query(sql2);
				  int size2 = list2.size();
				   if(size2 == 1){
					   map2 = list2.get(0);
					   hitcourse = new HitCourse((String)map1.get("uId"),
							   (String)map1.get("cId"),
							   (String)map2.get("cName"),
				    		   ((Integer)map1.get("score")).intValue(),
				    		   ((Integer)map2.get("cNum")).intValue());
				   }
				/*  hitcourse = new HitCourse((String)map.get("uId"),
						   (String)map.get("cId"),
			    		   ((Integer)map.get("score")).intValue());*/
				  hitCourses.add(hitcourse);
		        }
		     } catch (SQLException e) {
		        e.printStackTrace();
		     } catch (Exception e){
		        e.printStackTrace();
		     }
			 return hitCourses;
		}

}

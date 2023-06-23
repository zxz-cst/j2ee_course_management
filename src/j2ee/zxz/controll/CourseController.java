package j2ee.zxz.controll;

import j2ee.zxz.classes.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CourseController extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CourseController() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	   {
		response.setContentType("text/html;charset = utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String courseName = request.getParameter("coursename");
		String courseNum = request.getParameter("coursenum");
		String courseType = request.getParameter("coursetype");
		String sub = request.getParameter("sub");
		HttpSession Session = request.getSession(true);
		LoginService logs = new LoginService();
		String uId = (String)Session.getAttribute("result1");
		String uName = (String)Session.getAttribute("result2");
		System.out.print(234);
		if(sub.equals("课程管理"))
		{
		//CourseService service = new CourseService();
		//Session.setAttribute("courses", service.getAllCourses(1, 5));
		response.sendRedirect("/Homework_062/allCourse.jsp");
    	return;
		}
		
		if(sub.equals("确认"))
		{
		if(courseNum.equals("")) {
			Session.setAttribute("rs","课程名称和课程人数不能为空，新增失败");
	    	response.sendRedirect("/Homework_062/courseFailure.jsp");
	    	return;
		}
		Course course = new Course(1,courseName,Integer.parseInt(courseNum),courseType);
		CourseService service = new CourseService();
	    if(service.insert(course))
	    {
	    	response.sendRedirect("/Homework_062/allCourse.jsp");
	    	return;
	    }
	    else 
	    	Session.setAttribute("rs","课程名称和课程人数不能为空，新增失败");
	    	response.sendRedirect("/Homework_062/courseFailure.jsp");
	    	return;
		}
		if(sub.equals("选课"))
		{
			HitCourse hitcourse;
			List<HitCourse> hitcourses = new ArrayList<>();
			
			String[] a = request.getParameterValues("checkbox");
			CourseService service = new CourseService();
		    if(a==null)
		    {
		    	Session.setAttribute("rs","请选择要选修的课程");
				response.sendRedirect("/Homework_062/courseFailure.jsp");
				return;
		    }
			for(int i = 0;i<a.length;i++)
			{
				hitcourse = new HitCourse(uId,a[i],"",(int)(Math.random()*40)+60,1);
				hitcourses.add(hitcourse);
			}
			if(service.addHitCourse(hitcourses))
			{
		
		   
			Session.setAttribute("result3", logs.getAllHitCourse(uId));
			response.sendRedirect("/Homework_062/hitCourse.jsp");
			return;	
			}
			else
			{
				Session.setAttribute("rs","该课程已经选过了");
				response.sendRedirect("/Homework_062/courseFailure.jsp");
				return;
			}
			
		}
		if(sub.equals("退选"))
		{
			String[] a = request.getParameterValues("checkbox");
			CourseService service = new CourseService();
			if(service.delHitCourse(a))
				{
				Session.setAttribute("result3", logs.getAllHitCourse(uId));
				response.sendRedirect("/Homework_062/hitCourse.jsp");
				}
			else
			{
				Session.setAttribute("rs","请选择要删除的课程，删除失败");
				response.sendRedirect("/Homework_062/courseFailure.jsp");
				return;
			}
		}
		if(sub.equals("删除"))
		{
		String[] a = request.getParameterValues("checkbox");
		CourseService service = new CourseService();
		int rs  = service.delete(a);
		if(rs==0)
		{
			response.sendRedirect("/Homework_062/delCourse.jsp");
			return;
		}
		else if(rs==1)
		{
			Session.setAttribute("rs","请选择要删除的课程，删除失败");
			response.sendRedirect("/Homework_062/courseFailure.jsp");
			return;
		}
		else {
			Session.setAttribute("rs",uName+"已经选修该课程，不允许删除");
			response.sendRedirect("/Homework_062/courseFailure.jsp");
			return;
		}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

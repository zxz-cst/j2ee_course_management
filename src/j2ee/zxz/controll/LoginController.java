package j2ee.zxz.controll;

import java.io.IOException;

import j2ee.zxz.classes.*;

import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class LoginController extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginController() {
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
			throws ServletException, IOException {

		response.setContentType("text/html;charset = utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String yanzhengma = request.getParameter("yanzhengma");
		Login login = new Login(userName,password,yanzhengma);
		LoginService service = new LoginService();
		String result = service.deal(login);	
		if(result == "成功")
		{
			User us = service.getUser(userName);
			
			HttpSession Session = request.getSession(true);
			Session.setAttribute("result1", us.getUserId());
			Session.setAttribute("result2", us.getUserName());
			Session.setAttribute("result3", service.getAllHitCourse(userName));
			getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("result", result);
			getServletContext().getRequestDispatcher("/loginFailure.jsp").forward(request, response);
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

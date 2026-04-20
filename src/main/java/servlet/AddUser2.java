package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import db.DBHandler;


@WebServlet("/adduser2")
public class AddUser2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	// 1. 생성자 : 보통은 생략을 한다.
    public AddUser2() {
    	System.out.println("생성자");
    }

    // 2. init - 초기화
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 실행");
	}

	// 6. destroy 클래스의 인스턴스 소멸될 때 : 보통은 생략을 한다.
	public void destroy() {
		System.out.println("destroy() 실행");
	}

	// 3. service - doget 인지 dopost 인지 판단
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 실행");
	}
	*/

	// 4. doGet
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		// System.out.println("doGet() 실행");
		String userid     = request.getParameter("userid");
		String username   = request.getParameter("username");
		String email      = request.getParameter("email");
		
		DBHandler db = new DBHandler();
		try {
			db.addUser(userid, username, email);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/PrjJsp02/");
		
		/*
		// Console
		System.out.println(userid);
		// Html 페이지에 출력
		// application/xml(.xml), application/json(.json), plaint/text(.txt)
		response.setContentType("text/html;charset=utf-8"); // 이거 안붙이면 글자깨짐
		PrintWriter out = response.getWriter();
		out.write( userid );
		out.close();
		*/
		
		
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// 5. doPost
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		System.out.println("doPost() 실행");
		doGet(request, response);
	}

}

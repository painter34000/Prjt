package co.yedam.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MemberLogout.do")
public class MemberLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberLogout() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter  out = response.getWriter();
		
		HttpSession session = request.getSession();
		session.invalidate();  //세션 삭제
		// "/" 리다이렉트
		response.sendRedirect(request.getContextPath()+"/");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

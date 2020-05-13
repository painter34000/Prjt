package co.yedam.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MemberLogin.do")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 파라미터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// 2. 서비스 로직
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMember(id);

		// id로 조회, 조회 결과가 없으면 id가 없다.
		if (vo.getId() == null) { // id 오류
			request.setAttribute("errorMsg", "ID오류");
			request.getRequestDispatcher("/member/memberLogin.jsp").forward(request, response);
		} else if (!vo.getPwd().equals(pwd)) { // pwd 오류
			request.setAttribute("errorMsg", "패스워드 오류");
			request.getRequestDispatcher("/member/memberLogin.jsp").forward(request, response);
		} else { // 로그인 성공
			// 세션에 로그인 여부를 저장
			HttpSession session = request.getSession();
			session.setAttribute("loginId", id);
			session.setAttribute("loginMember", vo);
			response.sendRedirect(request.getContextPath() + "/");
		}
		// 조회가 된 경우에는 password가 맞는지 검사
		// 로그인
		// 3. 결과 저장

		// 4. 뷰페이지로 포워드
	}

//로그인 페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/member/MemberLogin.jsp").forward(request, response);
	}

}
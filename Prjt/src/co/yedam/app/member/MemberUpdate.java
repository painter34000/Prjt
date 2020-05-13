package co.yedam.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberUpdateForm
 */
@WebServlet("/MemberUpdate.do")
public class MemberUpdate extends HttpServlet {
   private static final long serialVersionUID = 1L;

   // 수정 처리
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // 파라미터 받기

      // 응답결과 인코딩
      response.setContentType("text/html; charset=UTF-8");
      // 요청정보 인코딩
      request.setCharacterEncoding("utf-8");
      // 1 파라미터 받기
      request.setCharacterEncoding("utf-8");
      String id = request.getParameter("id");
      String pwd = request.getParameter("pwd");
      String name = request.getParameter("name");
      String gender = request.getParameter("gender");
      String religion = request.getParameter("religion");
      String introduction = request.getParameter("introduction");
      // 자기소개, 이름, 종교 ,
      // 취미
      String[] hobby = request.getParameterValues("hobby");
      String hobbys = "";
      if (hobby != null)
         for (String temp : hobby) {
            hobbys += temp + ",";
         }
      // 2. 서비스 로직 처리 (DAO)
      MemberDAO memberDAO = new MemberDAO();
      MemberVO member = new MemberVO();
      member.setId(id);
      member.setPwd(pwd);
      member.setName(name);
      member.setHobby(hobbys);
      member.setGender(gender);
      member.setReligion(religion);
      member.setIntroduction(introduction);

      int r = memberDAO.memberUpdate(member);
      // 3.결과 출력
      PrintWriter out = response.getWriter();
      out.print("<br>아이디 = " + id); // System.out.____
      out.append("<br>pwd = " + pwd);
      out.append("<br>name = " + name);
      out.append("<br>취미 = " + hobbys);
      out.append("<br>gender = " + gender);// 아래내용이랑 같다.
      out.append("<br>religion = " + religion);
      out.append("<br>introduction = " + introduction);
      out.print("<br> 처리된 건수 = " + r);
   }

   /**
    * @see HttpServlet#HttpServlet()
    */
   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   // 수정페이지로 이동
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // 파리미터 받기 -> 세선에서 id 가져오기
      String id = (String) request.getSession().getAttribute("loginId");
      if (id == null) {
         response.sendRedirect(request.getContextPath() + "/MemberLogin.do");
         return;
      }
      // 서비스 로직 처리(회원정보 1건 조회)
      MemberDAO dao = new MemberDAO();
      MemberVO vo = dao.getMember(id);
      // 결과 저장
      request.setAttribute("member", vo);
      // 뷰페이지로 이동
      request.getRequestDispatcher("/member/memberUpdate.jsp").forward(request, response);
   }

}
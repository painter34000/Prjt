package co.yedam.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberInsert
 */
@WebServlet("/MemberInsert.do")
public class MemberInsert extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public MemberInsert() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
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

      int r = memberDAO.memberinsert(member);
//      String name = request.getParameter("name");
//      String hobby = request.getParameter("hobby");
//      String religion = request.getParameter("religion");
//      String introduction = request.getParameter("introduction");

      // 3.회원목록 이동 //include, forward, sendRedirect
      String contextPath = getServletContext().getContextPath();
      response.sendRedirect(contextPath + "/MemberList.do");
//      request.getRequestDispatcher("/MemberList.do").forward(request, response);

      // 결과 출력
      PrintWriter out = response.getWriter();
      out.print("<br>아이디 = " + id); // System.out.____
      out.append("<br>pwd = " + pwd);
      out.append("<br>name = " + name);
      out.append("<br>취미 = " + hobbys);
      out.append("<br>gender = " + gender);// 아래내용이랑 같다.
      out.append("<br>religion = " + religion);
      out.append("<br>introduction = " + introduction); // 아래내용이랑 같다.
      out.print("<br> 처리된 건수 = " + r);
//      response.getWriter().append("<br>아이디 = " + id).append("<br>pwd = " + pwd)
//      .append("<br>name = " +name).append("<br>취미 = " +hobbys).append("<br>religion = " +religion)
//      .append("<br>introduction = " +introduction);
   }
   //회원가입 페이지로 포워드
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      request.getRequestDispatcher("/member/memberInsert.jsp").forward(request, response);
   }
//      //응답결과 인코딩
//      response.setContentType("text/html; charset=UTF-8");
//      
//      String queryString = request.getQueryString(); //get방식에서만 사용 가능.
//      response.getWriter().append("질의문자열=" + queryString);
//   }
}
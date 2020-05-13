package co.yedam.app.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/boardInsert.do")
public class BoardInsert extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public BoardInsert() {
      super();

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
      String seq = request.getParameter("seq");
      String title = request.getParameter("title");
      String name = request.getParameter("name");
      String contents = request.getParameter("contents");
      String id = request.getParameter("id");
      String regdt = request.getParameter("regdt");
      // 2. 서비스 로직 처리 (DAO)
      BoardDAO boardDAO = new BoardDAO();
      BoardVO board = new BoardVO();
      board.setId(seq);
      board.setTitle(title);
      board.setTitle(name);
      board.setContents(contents);
      board.setId(id);
      board.setRegdt(regdt);

      int r = boardDAO.BoardInsert(board);

      // 3.회원목록 이동 //include, forward, sendRedirect
      response.sendRedirect("/prjt/BoardList.do");
//      request.getRequestDispatcher("/MemberList.do").forward(request, response);
//            // 3.결과 출력
      PrintWriter out = response.getWriter();
      out.print("<br>= " + seq);
      out.print("<br>작성자 = " + id); // System.out.____
      out.append("<br>제목 = " + title);
      out.append("<br>이름 = " + name);
      out.append("<br>내용 = " + contents);
      out.append("<br>작성일자 = " + regdt);// 아래내용이랑 같다.
      out.print("<br> 처리된 건수 = " + r);
   }
}
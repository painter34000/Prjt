//package co.yedam.app.board;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import co.yedam.app.member.MemberVO;
//
///**
// * Servlet implementation class BoradList
// */
//@WebServlet("/BoradList")
//public class BoradList extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//
//    public BoradList() {
//        super();
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
//    		throws ServletException, IOException {
//    	//1.파라미터
//    	
//    	//2.서비스 (DAO 목록조회)
//		BoardDAO dao = new BoardDAO();
//		ArrayList<BoardVO> list = dao.getBoardList();
//		
//    	//3.결과출력 or 결과저장해서 view 포워드 넘어가도 됨
//		request.setAttribute("list", list);
//		request
//		.getRequestDispatcher("/board/boardList.jsp")
//		.forward(request, response);
//	}
//
//
//
//}
package co.yedam.app.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      BoardDAO dao = new BoardDAO();
      List<BoardVO> boardList = dao.getBoardList();
      
      
      //포워드
      request.setAttribute("boardList", boardList);
      request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doGet(request, response);
   }

}